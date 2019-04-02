package com.hanson.transform.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hanson.base.enums.DataStatus;
import com.hanson.base.util.DateUtils;
import com.hanson.transform.dao.gen.entity.SYFCBuilding;
import com.hanson.transform.dao.gen.entity.SYFCBuildingExample;
import com.hanson.transform.dao.gen.entity.SYFCCommunity;
import com.hanson.transform.dao.gen.entity.SYFCCommunityExample;
import com.hanson.transform.dao.gen.mapper.SYFCBuildingMapper;
import com.hanson.transform.dao.gen.mapper.SYFCCommunityMapper;
import com.hanson.transform.enums.BuildingStatusEnum;
import com.hanson.transform.enums.BuildingTypeEnum;
import com.hanson.transform.enums.DistrictEnum;
import com.hanson.transform.service.SYFCSalesBuildService;

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
	
	@Override
	public void transform() {
		//销售日期倒序,已经采集完详情的
		Query query = new Query();  
		query.with(new Sort(new Order(Direction.DESC,"start_sales_date")));
		query.addCriteria(Criteria.where("collect_state").is(1));
		List<JSONObject> communitylist = mongoTemplate.find(query,JSONObject.class, BUILD_COLLECTION);
		
		
//		//可以通过buildingId关联售价
//		Query price_query = new Query(); 
//		price_query.with(new Sort(new Order(Direction.DESC,"approve_date")));
//		price_query.addCriteria(Criteria.where("collect_state").is(1));
////		price_query.addCriteria(Criteria.where("company").is(company).and("sales_no").in(sales_num_list));
//		List<JSONObject> priceList = mongoTemplate.find(price_query,JSONObject.class, PRICE_COLLECTION);
//		Map<Integer,JSONObject> buildingId_priceInfo = new HashMap<Integer,JSONObject>();
//		//可以通过buuildId关联售价信息
//		for (JSONObject price : priceList) {
//			//楼栋的地址
//			int buildingId = price.getInteger("third_record_id");
//			buildingId_priceInfo.put(buildingId, price);
//		}
//		
//		//所有爬取的预售许可证，可以通过salesNo关联
//		Query num_query = new Query();  
//		num_query.with(new Sort(new Order(Direction.DESC,"date")));
////		num_query.addCriteria(Criteria.where("company").is(company).and("date").lt(start_sales_date));
//		List<JSONObject> numlist = mongoTemplate.find(num_query,JSONObject.class, NUM_COLLECTION);
//		//此公司拿到的销售许可证号
//		Map<String,JSONObject> salesNum_SalesNumInfo = new HashMap<String,JSONObject>();
//		for (JSONObject num : numlist ) {
//			String sales_no = num.getString("sales_no");
//			salesNum_SalesNumInfo.put(sales_no, num);
//		}
		
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
					logger.error("未解析到区域,主内容{},唯一标识:{}",district,community.get("third_record_id"));
					try {
						districtEnum = DistrictEnum.textOf(subordinate_district);
					} catch (Exception e2) {
						logger.error("未解析到区域,副内容{},唯一标识:{}",district,community.get("third_record_id"));
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
				saveBuilds(community,record);
			} catch (Exception e) {
				logger.error("转换楼盘错误,唯一标识:{}",community.get("third_record_id"),e);
			}
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
			
			//存储房屋信息
			Query house_query = new Query(); 
			house_query.addCriteria(Criteria.where("collect_state").is(1).and("third_record_id").is(buildingId));
			mongoTemplate.findOne(house_query, JSONObject.class,HOUSE_COLLECTION);
			
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
						sales_num = housePriceJSON.getString("sales_no");//预售许可证
//								String house_tier = housePriceJSON.getString("house_tier");//房屋楼层
//								String house_state = housePriceJSON.getString("house_state");//房屋状态
//								double house_build_area = housePriceJSON.containsKey("house_build_area")?housePriceJSON.getDouble("house_build_area"):0.0;;//建筑面积
//								String total_price = housePriceJSON.getString("total_price");//总价
						try {
							build_type_enum = BuildingTypeEnum.textOf(housePriceJSON.getString("house_use"));//用途
						} catch (Exception e) {
							buildingStatus = BuildingStatusEnum.BUILDING_TYPE_FORMAT_ERROR;
							logger.error("房屋类型解析异常,类型:{},楼盘第三方ID:{},建筑第三方ID:{}",housePriceJSON.getString("house_use"),community.get("third_record_id"),buildingId);
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
					logger.error("未找到预售许可信息,许可证号{},楼盘第三方ID:{},建筑第三方ID:{}",sales_num,community.get("third_record_id"),buildingId);
				}
			}else {
				String remark = String.format("未取到售价信息,开发商:%s,楼盘:%s,地址:%s,楼盘第三方ID:%s,建筑第三方ID:%s",company,community.get("program_describe"),build_location,community.get("third_record_id"),buildingId);
				building.setRemark(remark);
				buildingStatus = BuildingStatusEnum.PRICE_INFO_NOT_FOUND;
				logger.error("未取到售价信息,开发商:{},楼盘:{},地址:{},楼盘第三方ID:{},建筑第三方ID:{}",company,community.get("program_describe"),build_location,community.get("third_record_id"),buildingId);
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
			//取差集
			tempList.removeAll(transformList);
			for (SYFCCommunity syfcCommunity : tempList) {
				logger.info("楼盘未清洗，唯一标识:{}",syfcCommunity.getThirdRecordId());
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
		int communityId = 0;
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
		return communityId;
	}
}