package com.hanson.transform.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hanson.base.enums.DataStatus;
import com.hanson.base.util.DateUtils;
import com.hanson.transform.dao.gen.entity.*;
import com.hanson.transform.dao.gen.mapper.SYFCBuildingMapper;
import com.hanson.transform.dao.gen.mapper.SYFCCommunityMapper;
import com.hanson.transform.dao.gen.mapper.SYFCHouseMapper;
import com.hanson.transform.enums.BuildingStatusEnum;
import com.hanson.transform.enums.BuildingTypeEnum;
import com.hanson.transform.enums.DistrictEnum;
import com.hanson.transform.enums.HouseStateEnum;
import com.hanson.transform.service.SYFCSalesBuildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by hanlin on 2019年1月30日
 **/
@Service
public class SYFCSalesBuildServiceImpl implements SYFCSalesBuildService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String BUILD_COLLECTION = "syfc_new_build_detail";
	private static final String NUM_COLLECTION = "syfc_sales_num_detail";
	private static final String PRICE_COLLECTION = "syfc_sales_price_detail";
	private static final String HOUSE_COLLECTION = "syfc_new_build_house";
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	SYFCCommunityMapper communityMapper;
	@Autowired
	SYFCBuildingMapper buildingMapper;
	@Autowired
	SYFCHouseMapper houseMapper;
	
	@Override
	public void saveCommunity() {
		//销售日期倒序,已经采集完详情的
		Query query = new Query();  
		query.with(new Sort(new Order(Direction.DESC,"start_sales_date")));
		query.addCriteria(Criteria.where("collect_state").is(1).and("trans_state").ne(1));
		List<JSONObject> communitylist = mongoTemplate.find(query,JSONObject.class, BUILD_COLLECTION);
		
		//所有的楼盘
		for (JSONObject community : communitylist) {
			try {
				String company = community.getString("company");
//				String start_sales_date = community.getString("start_sales_date");
				//所属区
				String district = community.getString("district");
				String subordinate_district = community.getString("subordinate_district");
				DistrictEnum districtEnum = DistrictEnum.UNKNOWN;
				try {
					districtEnum = DistrictEnum.textOf(district);
				} catch (Exception e) {
					//未解析到主区域，解析副区域
					logger.warn("未解析到区域,主内容{},唯一标识:{}",district,community.get("third_record_id"));
					try {
						districtEnum = DistrictEnum.textOf(subordinate_district);
					} catch (Exception e2) {
						logger.warn("未解析到区域,副内容{},唯一标识:{}",subordinate_district,community.get("third_record_id"));
					}
					if(districtEnum.code() == DistrictEnum.UNKNOWN.code()) {
						logger.error("未解析到区域,主内容｛{}｝，副内容{},唯一标识:{}",district,subordinate_district,community.get("third_record_id"));
						
					}
				}
				//楼栋信息
				JSONArray builds = community.getJSONArray("build_detail_list");
				//售价信息,可以用详细地址关联
				String programLocaltion = builds.size()>0?((JSONObject)builds.get(0)).getString("build_location"):"";
				
				//洗入mysql的數據 TODO:
				SYFCCommunity record = new SYFCCommunity();
				record.setCompany(company);
				record.setDistrict(districtEnum);
				//获取-前面的（通常是门牌前的地址）
				programLocaltion = programLocaltion.indexOf("-")>0?programLocaltion.split("-")[0]:programLocaltion;
				//去掉数字
//				programLocaltion = programLocaltion.replaceAll("\\d+","");
				record.setProgramLocaltion(programLocaltion);
				record.setProgramDescription(community.getString("program_describe"));
//				record.setProgramName(programName);
				Date salesDate = null;
				try {
					salesDate = new SimpleDateFormat(DateUtils.ISO_DATE).parse(community.getString("start_sales_date"));
				} catch (ParseException e) {
					logger.error("解析开盘日期错误,开发商:{},楼盘:{},唯一标识:{}",company,community.get("program_describe"),programLocaltion,community.get("third_record_id"));
				}
				record.setSalesDate(salesDate);
				record.setThirdRecordId(community.getInteger("third_record_id"));
				record.setBuildCount(builds.size());
				this.saveCommunity(record);
//				Update update = new Update();
//				update.addToSet("trans_state", 1);
//				Query updateQuery = new Query();
//				updateQuery.addCriteria(Criteria.where("third_record_id").is(community.get("third_record_id")));
//				mongoTemplate.updateFirst(updateQuery , update , JSONObject.class);
			} catch (Exception e) {
				logger.error("转换楼盘错误,唯一标识:{}",community.get("third_record_id"),e);
			}
		}
	}

	/**
	 * 从已经清洗到mysql的community,在MongoDB中拿到此community信息构建builds
	 */
	public void saveBuilds() {
		SYFCCommunityExample example = new SYFCCommunityExample();;
		example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
		List<SYFCCommunity> selectByExample = communityMapper.selectByExample(example);
		for (SYFCCommunity record : selectByExample) {
			Query query = new Query();
			query.addCriteria(Criteria.where("third_record_id").is(String.valueOf(record.getThirdRecordId())));
			JSONObject community = mongoTemplate.findOne(query , JSONObject.class,BUILD_COLLECTION);
			this.saveBuilds(community,record);
		}
	}
	
	/**
	 * 保存楼盘的每栋建筑
	 * @param community
	 * @param record
	 */
	private void saveBuilds(JSONObject community, SYFCCommunity record) {
		JSONArray builds = community.getJSONArray("build_detail_list");
		String company = community.getString("company");
		//存储每栋的信息
		for (Object build : builds) {
			//存储每个建筑
			BuildingStatusEnum buildingStatus = BuildingStatusEnum.NORMAL;
			SYFCBuilding building = new SYFCBuilding();
			//每栋的信息
			JSONObject buildJson = (JSONObject)build;
			//转换成纯数字
			try {
				buildJson.getInteger("third_record_id");
			} catch (Exception e) {
				//只保留数字
				String building_id = buildJson.getString("third_record_id");
				String regEx="[^0-9]";  
				Pattern p = Pattern.compile(regEx);  
				Matcher m = p.matcher(building_id);  
				buildJson.put("third_record_id",m.replaceAll(""));
			}
			
			Integer buildingId = buildJson.getInteger("third_record_id");
			String build_location = buildJson.getString("build_location");
			int topTier = 0;
			double build_avg_price = 0.0;
			double build_min_price = 0.0;
			double build_max_price = 0.0;
			double build_total_price = 0.0;
			long total_house = 0L;
			BuildingTypeEnum build_type_enum = BuildingTypeEnum.UNKNOWN;
			String sales_num = null;
			Query price_query = new Query(); 
			price_query.addCriteria(Criteria.where("collect_state").is(1).and("third_record_id").is(buildingId));
			JSONObject buildingPrice = mongoTemplate.findOne(price_query,JSONObject.class, PRICE_COLLECTION);
			
			if(buildingPrice != null) {
				logger.debug("每栋的信息,开发商:{},楼盘:{},地址:{},唯一标识:{}",company,community.get("program_describe"),build_location,community.get("third_record_id"));
				//每户的售价
				if(!buildingPrice.containsKey("sales_price_detail_list")) {
					logger.warn("已生成售价列表，但未采集到详情,开发商:{},楼盘:{},地址:{},唯一标识:{}",company,community.get("program_describe"),build_location,buildingPrice.getString("third_record_id"));
					buildingStatus = BuildingStatusEnum.GENERATED_NOT_COLLECT;
					continue;
				}
				JSONArray tierPriceList = buildingPrice.getJSONArray("sales_price_detail_list");
				topTier = tierPriceList.size();
				for (Object tierPrice : tierPriceList) {
					//每一层
					JSONArray housePriceListJson = (JSONArray)tierPrice;
					for (Object housePrice : housePriceListJson) {
						//每个房源的价格
						JSONObject housePriceJSON = (JSONObject)housePrice;
//								String house_localtion = housePriceJSON.getString("house_localtion");//房屋地址
//								String house_structure = housePriceJSON.getString("house_structure");//房屋结构
//								HouseStateEnum state = HouseStateEnum.codeOf(houseJSON.getInteger("sales_state_enum"));
//								String house_tier = housePriceJSON.getString("house_tier");//房屋楼层
								sales_num = housePriceJSON.getString("sales_no");//预售许可证
//								String total_price = housePriceJSON.getString("total_price");//总价
//								String house_state = housePriceJSON.getString("house_state");//房屋状态
//								String house_use = housePriceJSON.getString("house_use");//房屋用途
//								String unit_price = housePriceJSON.getString("unit_price");//房屋单价
//								double house_build_area = housePriceJSON.containsKey("house_build_area")?housePriceJSON.getDouble("house_build_area"):0.0;;//建筑面积
						try {
							build_type_enum = BuildingTypeEnum.textOf(housePriceJSON.getString("house_use"));//用途
						} catch (Exception e) {
							buildingStatus = BuildingStatusEnum.BUILDING_TYPE_FORMAT_ERROR;
							logger.warn("房屋类型解析异常,类型:{},楼盘第三方ID:{},建筑第三方ID:{}",housePriceJSON.getString("house_use"),community.get("third_record_id"),buildingId);
						}
						//有些已售的房屋没有单价，不计入平均价格
						if(housePriceJSON.containsKey("unit_price")) {
							double unit_price = housePriceJSON.containsKey("unit_price")?housePriceJSON.getDouble("unit_price"):0.0;//单价
							//计算均价
							build_total_price+= unit_price;
							total_house++;
							//最高价
							build_max_price = build_max_price > unit_price ? build_max_price : unit_price;
							//min初始化
							if(build_min_price == 0) {
								build_min_price = unit_price;
							}
							//最低价
							build_min_price = build_min_price < unit_price ? build_min_price : unit_price;
							//TODO:save house price
						}
					}
				}
				build_avg_price = build_total_price/total_house;
				//价格审批日期
				Date approve_date = buildingPrice.getDate("approve_date");
				building.setApproveDate(approve_date);
				//关联预售许可证拿到楼栋号
                //FIXME:看看有没有更好的方式关联到预售许可证
				Query num_query = new Query();  
				num_query.addCriteria(Criteria.where("sales_no").is(sales_num));
				JSONObject salesNumJSON = mongoTemplate.findOne(num_query,JSONObject.class, NUM_COLLECTION);
				String buildNum = null;
				if(salesNumJSON != null) {
					//由更不可能填写的楼号向前拿，楼号
					buildNum = salesNumJSON.containsKey("other_build_no")?salesNumJSON.getString("other_build_no"):null;
					buildNum = salesNumJSON.containsKey("public_build_no")?salesNumJSON.getString("public_build_no"):null;
					buildNum = salesNumJSON.containsKey("shop_build_no")?salesNumJSON.getString("shop_build_no"):null;
					buildNum = salesNumJSON.containsKey("dwelling_build_no")?salesNumJSON.getString("dwelling_build_no"):null;
					building.setBuildingNum(buildNum);
					building.setSalesNum(sales_num);
				}else {
					buildingStatus = BuildingStatusEnum.SALES_NUM_NOT_FOUND;
					logger.warn("未找到【预售许可信息】,许可证号{},楼盘第三方ID:{},建筑第三方ID:{}",sales_num,community.get("third_record_id"),buildingId);
				}
			}else {
				String remark = String.format("未取到售价信息,开发商:%s,楼盘:%s,地址:%s,楼盘第三方ID:%s,建筑第三方ID:%s",company,community.get("program_describe"),build_location,community.get("third_record_id"),buildingId);
				building.setRemark(remark);
				buildingStatus = BuildingStatusEnum.PRICE_INFO_NOT_FOUND;
				logger.warn("未取到｛售价信息｝,开发商:{},楼盘:{},地址:{},楼盘第三方ID:{},建筑第三方ID:{}",company,community.get("program_describe"),build_location,community.get("third_record_id"),buildingId);
			}
			building.setCommunityId(record.getId());
			building.setThirdBuildId(buildingId);
			building.setBuildingLocaltion(buildJson.getString("build_location"));
			if(topTier > 0 ) {
				building.setTopTier(topTier);
			}
			//建筑类型（可以售价详情的house_use来确定）
			building.setBuildingType(build_type_enum);
			//建筑工艺（可以通过一梯几户来确定）
//					building.setBuildingTech(topTier);
			if(build_avg_price > 0 ) {
				building.setAvgPrice(new BigDecimal(Double.toString(build_avg_price)));
			}
			if(build_max_price > 0 ) {
				building.setMaxPrice(new BigDecimal(Double.toString(build_max_price)));
			}
			if(build_min_price > 0 ) {
				building.setMinPrice(new BigDecimal(Double.toString(build_min_price)));
			}
			building.setBuildingStatus(buildingStatus);
			this.saveBuilding(building);
		 }
	}

	/**
	 * NOT TODO根据洗到mysql的build信息生成houses信息.
	 * 由于house数据太多了,只能通过是否清洗标识来标识是否清洗完成,减少数据量
	 * 与清洗mongo的house逻辑是一致的,只不过一个存储到mysql一个存储到mongo
	 */
	public void saveHouse() {
		Query buildingQuery = new Query();
		buildingQuery.addCriteria(Criteria.where("gen_mongo_house").ne(1));
		List<JSONObject> buidingList = mongoTemplate.find(buildingQuery,JSONObject.class, "syfc_building");
		for (JSONObject build : buidingList) {
			Integer building_id = build.getInteger("building_id");
			Integer community_id = build.getInteger("community_id");
			try {
				//通过building_id查找syfc_new_build_house 采集的house信息
				Query houseQuery = new Query();
				houseQuery.addCriteria(Criteria.where("third_record_id").is(String.valueOf(building_id)));
				JSONObject buildingHouses = mongoTemplate.findOne(houseQuery,JSONObject.class, "syfc_new_build_house");
				if(buildingHouses != null && buildingHouses.containsKey("house_detail_list")) {
					JSONArray houseList = buildingHouses.getJSONArray("house_detail_list");
					//查找售价信息
					Query price_query = new Query();
					price_query.addCriteria(Criteria.where("collect_state").is(1).and("third_record_id").is(building_id));
					Map<Integer,JSONObject> priceMap = new HashMap<>();
					JSONObject buildingPrice = mongoTemplate.findOne(price_query,JSONObject.class, "syfc_sales_price_detail");
					if(buildingPrice != null) {
						JSONArray jsonArray = buildingPrice.getJSONArray("sales_price_detail_list");
						//每一楼
						for (Object houseTierPirce : jsonArray) {
							JSONArray housePriceListJson = (JSONArray)houseTierPirce;
							for (Object housePirce : housePriceListJson) {
								//每个房间
								JSONObject housePriceJSON = (JSONObject)housePirce;
								//可售才有售价和id
								if(HouseStateEnum.textOf(housePriceJSON.getString("house_state")).code() == HouseStateEnum.CAN_SALE.code()) {
									if(housePriceJSON.containsKey("third_record_id")) {
										priceMap.put(housePriceJSON.getInteger("third_record_id"), housePriceJSON);
									}else {
										logger.warn("房屋可售但未取到售价{}",housePriceJSON.toJSONString());
									}
								}
							}
						}
					}
					for (Object houseTier : houseList) {
						JSONArray housePriceListJson = (JSONArray)houseTier;
						for (Object house : housePriceListJson) {
							JSONObject houseJSON = (JSONObject)house;
							HouseStateEnum houseState = HouseStateEnum.codeOf(houseJSON.getInteger("sales_state_enum"));
							Integer houseId = houseJSON.getInteger("third_record_id");
							SYFCHouse houseEntity = new SYFCHouse();
							houseEntity.setThirdHouseId(houseId);
							//这个应该是mysql里的buildingID
							SYFCBuildingExample example = new SYFCBuildingExample();
							example.createCriteria().andThirdBuildIdEqualTo(building_id);
							List<SYFCBuilding> selectByExample = buildingMapper.selectByExample(example);
							if(selectByExample !=null && selectByExample.size()>0) {
								Integer mysqlBuildingId = selectByExample.get(0).getId();
								houseEntity.setBuildingId(mysqlBuildingId);
								houseEntity.setHouseStatus(houseState);
								//只有可售才有售价
								if(houseState.code() == HouseStateEnum.CAN_SALE.code()) {
									if(priceMap.containsKey(houseId)) {
										JSONObject housePriceJSON = priceMap.get(houseId);
										houseEntity.setUnitPrice(housePriceJSON.getBigDecimal("unit_price"));
										houseEntity.setTotalPrice(housePriceJSON.getBigDecimal("total_price"));
										houseEntity.setHouseStructure(housePriceJSON.getString("house_structure"));
										houseEntity.setHouseType(housePriceJSON.getString("house_use"));
									}else {
										logger.warn("房屋可售但未取到售价,房屋id{},buildid{}",houseId,building_id);
									}
								}
								houseEntity.setHouseNum(houseJSON.getString("house_no"));
								houseEntity.setHouseTier(houseJSON.getString("house_tier"));
								//面积还未采集
								//					houseEntity.setInsideArea(insideArea);
								//					houseEntity.setApportionArea(apportionArea);
								//					houseEntity.setBalconyArea(balconyArea);
								//					houseEntity.setSalesArea(salesArea);
								//					houseEntity.setBuildArea(buildArea);
								//					houseEntity.setApportionRatio(apportionRatio);
								//					houseEntity.setRemark(remark);
								this.saveHouse(houseEntity);
								//更新build同步状态
								this.updateBuildingInfo(building_id);
							}else {
								logger.warn("建筑信息未同步,第三方ID{}",building_id);
							}
						}
					}
				}else {
					logger.warn("{}未采集house,创建采集house任务",building_id);
					//未采集house,创建采集house任务
					Query updateQuery = new Query();
					updateQuery.addCriteria(Criteria.where("third_record_id").is(String.valueOf(building_id)));
					Update update = Update.update("collect_state", 0)
							.addToSet("parent_third_record_id",String.valueOf(community_id) )
							.addToSet("third_record_id", String.valueOf(building_id));
					mongoTemplate.updateFirst(updateQuery, update, JSONObject.class,"syfc_new_build_house");
				}
			} catch (Exception e) {
				logger.error("房屋可售但未取到售价,community_id{},buildid{}",building_id,community_id);
			}
		}
	}

	
	private void updateBuildingInfo(int buildingId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("building_id").is(buildingId));
		Update update = Update.update("gen_mongo_house", 1);
		mongoTemplate.upsert(query , update, JSONObject.class,"syfc_building");
	}
	
	@Override
	public void checkCommunity() {
		SYFCCommunityExample example = new SYFCCommunityExample();
		example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
		List<SYFCCommunity> transformList = communityMapper.selectByExample(example);
		Query query = new Query();  
		query.with(new Sort(new Order(Direction.DESC,"start_sales_date")));
		query.addCriteria(Criteria.where("collect_state").is(1));
		List<JSONObject> spiderList = mongoTemplate.find(query,JSONObject.class, BUILD_COLLECTION);
		if(transformList.size() > spiderList.size()) {
			logger.error("清洗楼盘大于采集楼盘，与可能有重复或被删除的数据。清洗楼盘:{},采集楼盘:{},",transformList.size(),spiderList.size());
		}else if(transformList.size() == spiderList.size()) {
			logger.info("同步已经完成。清洗楼盘:{},采集楼盘:{},",transformList.size(),spiderList.size());
		}else if(transformList.size() < spiderList.size()) {
			logger.info("还有{}条数据未清洗。清洗楼盘:{},采集楼盘:{},",(spiderList.size() - transformList.size()),transformList.size(),spiderList.size());
			List<SYFCCommunity> tempList = new ArrayList<SYFCCommunity>();
			for (JSONObject json : spiderList) {
				SYFCCommunity community = new SYFCCommunity();
				community.setThirdRecordId(json.getInteger("third_record_id"));
				tempList.add(community);
			}
			logger.info("已清洗楼盘总量{}",transformList.size());
			logger.info("采集楼盘总量{}",spiderList.size());
			//取差集
			tempList.removeAll(transformList);
			logger.info("未采集楼盘总量{}",tempList.size());
			for (SYFCCommunity syfcCommunity : tempList) {
				logger.info("楼盘未清洗，唯一标识:{}",syfcCommunity.getThirdRecordId());
			};
		}
	}

	@Override
	public void checkBuilding() {
		SYFCBuildingExample example = new SYFCBuildingExample();
		example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
		List<SYFCBuilding> transformList = buildingMapper.selectByExample(example);
		Query query = new Query();
		query.with(new Sort(new Order(Direction.DESC,"start_sales_date")));
		query.addCriteria(Criteria.where("collect_state").is(1));
		List<JSONObject> spiderList = mongoTemplate.find(query,JSONObject.class, BUILD_COLLECTION);
		List<JSONObject> allBuildList = new ArrayList<>();
		for (Iterator<JSONObject> iterator = spiderList.iterator(); iterator.hasNext(); ) {
			JSONObject next =  iterator.next();
			JSONArray buildList = next.getJSONArray("build_detail_list");
			for (Iterator<Object> objectIterator = buildList.iterator(); objectIterator.hasNext(); ) {
				JSONObject o =  (JSONObject)objectIterator.next();
				allBuildList.add(o);
			}
		}
		logger.info("已清洗建筑总量{}",transformList.size());
		logger.info("采集建筑总量{}",allBuildList.size());
		List<SYFCBuilding> tempList = new ArrayList<SYFCBuilding>();
		for (JSONObject json : allBuildList) {
			SYFCBuilding building = new SYFCBuilding();
            //转换成纯数字
            try {
                json.getInteger("third_record_id");
            } catch (Exception e) {
                //只保留数字
                String building_id = json.getString("third_record_id");
                String regEx="[^0-9]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(building_id);
                json.put("third_record_id",m.replaceAll(""));
            }
			building.setThirdBuildId(json.getInteger("third_record_id"));
			tempList.add(building);
		}
		if(transformList.size() > allBuildList.size()) {
			logger.error("清洗建筑大于采集建筑，与可能有重复或被删除的数据。清洗建筑:{},采集建筑:{},",transformList.size(),allBuildList.size());
			//取差集
			transformList.removeAll(tempList);
			logger.info("多清洗的建筑总量{}",transformList.size());
			for (SYFCBuilding syfcBuilding : transformList) {
				logger.info("多清洗的，唯一标识:{}",syfcBuilding.getThirdBuildId());
			};//取差集
		}else if(transformList.size() == allBuildList.size()) {
			logger.info("同步已经完成。清洗建筑:{},采集建筑:{},",transformList.size(),allBuildList.size());
		}else if(transformList.size() < allBuildList.size()) {
			logger.info("还有{}条数据未清洗。清洗建筑:{},采集建筑:{},",(allBuildList.size() - transformList.size()),transformList.size(),allBuildList.size());
			tempList.removeAll(transformList);
			logger.info("未采集建筑总量{}",tempList.size());
			for (SYFCBuilding syfcBuilding : tempList) {
				logger.info("建筑未清洗，唯一标识:{}",syfcBuilding.getThirdBuildId());
			};
		}

	}

	/**
	 * 
	 * @param record
	 * @return
	 */
	private int saveCommunity(SYFCCommunity record) {
		SYFCCommunityExample example = new SYFCCommunityExample();
		example.createCriteria().andThirdRecordIdEqualTo(record.getThirdRecordId()).andDataStatusEqualTo(DataStatus.NORMAL);
		List<SYFCCommunity> selectByExample = communityMapper.selectByExample(example);
		if(selectByExample.size()>0) {
			SYFCCommunity syfcCommunity = selectByExample.get(0);
			record.setId(syfcCommunity.getId());
			record.setUpdateUserId(1);
			record.setUpdateTime(new Date());
			communityMapper.updateByPrimaryKeySelective(record);
		}else {
			record.setCreateUserId(1);
			record.setUpdateUserId(1);
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			record.setDataStatus(DataStatus.NORMAL);
			communityMapper.insertSelective(record);
		}
		return record.getId();
	}
	
	private int saveBuilding(SYFCBuilding record) {
		SYFCBuildingExample example = new SYFCBuildingExample();
		example.createCriteria().andThirdBuildIdEqualTo(record.getThirdBuildId()).andDataStatusEqualTo(DataStatus.NORMAL);;
		List<SYFCBuilding> selectByExample = buildingMapper.selectByExample(example);
		if(selectByExample.size()>0) {
			SYFCBuilding building = selectByExample.get(0);
			record.setId(building.getId());
			record.setUpdateUserId(1);
			record.setUpdateTime(new Date());
			buildingMapper.updateByPrimaryKeySelective(record);
		}else {
			record.setCreateUserId(1);
			record.setUpdateUserId(1);
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			record.setDataStatus(DataStatus.NORMAL);
			buildingMapper.insertSelective(record);
		}
		return record.getId();
	}
	
	private int saveHouse(SYFCHouse record) {
		SYFCHouseExample example = new SYFCHouseExample();
		example.createCriteria().andBuildingIdEqualTo(record.getBuildingId()).andHouseNumEqualTo(record.getHouseNum()).andDataStatusEqualTo(DataStatus.NORMAL);;
		List<SYFCHouse> selectByExample = houseMapper.selectByExample(example);
		if(selectByExample.size()>0) {
			SYFCHouse house = selectByExample.get(0);
			record.setUpdateUserId(1);
			record.setUpdateTime(new Date());
			record.setId(house.getId());
			houseMapper.updateByPrimaryKeySelective(record);
		}else {
			record.setCreateUserId(1);
			record.setUpdateUserId(1);
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			record.setDataStatus(DataStatus.NORMAL);
			houseMapper.insertSelective(record);
		}
		return record.getId();
	}
}