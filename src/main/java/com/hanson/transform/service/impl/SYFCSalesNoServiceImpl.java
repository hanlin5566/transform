package com.hanson.transform.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hanson.base.enums.DataStatus;
import com.hanson.base.mybatis.pagination.entity.PageInfo;
import com.hanson.transform.dao.gen.entity.SYFCSalesNo;
import com.hanson.transform.dao.gen.entity.SYFCSalesNoExample;
import com.hanson.transform.dao.gen.mapper.SYFCSalesNoMapper;
import com.hanson.transform.service.SYFCSalesNoService;
import com.hanson.base.util.BeanUtils;

/**
 * Create by hanlin on 2019年1月30日
 **/
@Service
public class SYFCSalesNoServiceImpl implements SYFCSalesNoService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SYFCSalesNoMapper mapper;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Integer insert(SYFCSalesNo sYFCSalesNo) {
		return mapper.insertSelective(sYFCSalesNo);
	}
	@Override
	public Integer delete(Integer id) {
		SYFCSalesNo sYFCSalesNo = new SYFCSalesNo();
		sYFCSalesNo.setId(id);
		sYFCSalesNo.setDataStatus(DataStatus.DELETED);
		return mapper.updateByPrimaryKeySelective(sYFCSalesNo);
	}
	@Override
	public Integer update(SYFCSalesNo sYFCSalesNo) {
		return mapper.updateByPrimaryKeySelective(sYFCSalesNo);
	}
	
	@Override
	public SYFCSalesNo get(Integer id) {
		SYFCSalesNoExample example = new SYFCSalesNoExample();
		example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL).andIdEqualTo(id);
		List<SYFCSalesNo> selectByExample = mapper.selectByExample(example);
		return selectByExample.size() > 0 ? selectByExample.get(0) : null;
	}
	
	@Override
	public List<SYFCSalesNo> search(SYFCSalesNo sYFCSalesNo, PageInfo page) {
		SYFCSalesNoExample example = BeanUtils.example(sYFCSalesNo,SYFCSalesNoExample.class);
		example.setOrderByClause("id desc");
		List<SYFCSalesNo> selectByExample = mapper.selectByExampleWithRowbounds(example, page);
		return selectByExample;
	}
	
	//记录采集内容
	private final String taskCollectionName = "syfc_sales_num_task";
	//记录每一页的内容
	private final String salesNoListCollectionName = "syfc_sales_num_list";
//	//销售许可详情
	private final String salesNumberRecordCollectionName = "syfc_sales_num_detail";
//	//销售价格列表
	private final String salesPriceListRecordCollectionName = "syfc_sales_price_list";
//	//销售价格列表
	private final String syfcSalesNumDetailNewCollectionName = "syfc_sales_num_detail_new";

	@Override
	public void transform(String taskId) {
		//根据taskID查询任务
		//按照ID读取任务
		Query query = new Query();
		query.addCriteria(Criteria.where("taskId").is(taskId));
		List<JSONObject> salesNumList = mongoTemplate.find(query, JSONObject.class, salesNoListCollectionName);
		//查找task
		Query salesNumTaskQuery = new Query();
		salesNumTaskQuery.addCriteria(Criteria.where("uuid").is(taskId));
		JSONObject salesNumTask = mongoTemplate.findOne(salesNumTaskQuery, JSONObject.class, taskCollectionName);
		//check
		HashMap<Integer, JSONObject> saleNumMap = new HashMap<Integer, JSONObject>();
		for (JSONObject saleNum : salesNumList) {
			Integer no = saleNum.getInteger("no");
			saleNumMap.put(no, saleNum);
		}
//		模拟采集数据
		JSONArray status = salesNumTask.getJSONArray("status");
		for (int i = 0; i < status.size(); i++) {
			int state_int = Integer.parseInt(status.get(i).toString());
			if(state_int != 1) {
				logger.error("未取到数据，状态为{}, NO:{}",state_int,i);
			}
			/**
			 * "no" : 23,
			    "sales_no_list" : [ 
			        {
			            "date" : "2018-07-18",
			            "no" : "576",
			            "program_localtion" : "浑南区高深东路7号",
			            "deltail_uri" : "/work/ysxk/ysxkzinfo.jsp?id=22242468",
			            "sales_no" : "18349",
			            "company" : "沈阳中海嘉业房地产开发有限公司",
			            "href" : "/work/ysxk/ysxkzinfo.jsp?id=22242468",
			            "third_record_id" : "22242468"
			        }, 
			 */
			JSONObject jsonObject = saleNumMap.get(i);
			JSONArray salesNoList = jsonObject.getJSONArray("sales_no_list");
			//保存预售许可证
			for (Object salesNoObj : salesNoList) {
				SYFCSalesNo syfcSalesNo = new SYFCSalesNo();
				JSONObject salesNum = (JSONObject)salesNoObj;
				try {
					Date approveDate = salesNum.getDate("date");//审核日期
					String programLocaltion = salesNum.getString("program_localtion");//项目地址
					Integer thirdNo = salesNum.getInteger("no");//编号
					String salesNo = salesNum.getString("sales_no");//预售许可证号
					String company = salesNum.getString("company");//公司
					String thirdRecordId = salesNum.getString("third_record_id");//第三方主键
					syfcSalesNo.setApproveDate(approveDate);
					syfcSalesNo.setProgramLocaltion(programLocaltion);
					syfcSalesNo.setThirdNo(thirdNo);
					syfcSalesNo.setCompany(company);
					syfcSalesNo.setThirdRecordId(thirdRecordId);
					syfcSalesNo.setSalesNo(salesNo);
					syfcSalesNo.setCreateUid(200);
					syfcSalesNo.setUpdateUid(200);
				} catch (Exception e) {
					logger.error("解析爬取数据发生异常，NO:{},ID:",syfcSalesNo,e);
					continue;
				}
				//洗到mysql 只有第三方ID才是惟一标识
//					try {
//						SYFCSalesNoExample example = new SYFCSalesNoExample();
//						example.createCriteria().andThirdRecordIdEqualTo(syfcSalesNo.getThirdRecordId());
//						example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
//						List<SYFCSalesNo> selectByExample = mapper.selectByExample(example);
//						if(selectByExample.size()>0) {
//							//update
//							SYFCSalesNo syfcSalesNoUpdate = selectByExample.get(0);
//							syfcSalesNo.setId(syfcSalesNoUpdate.getId());
//							mapper.updateByPrimaryKeySelective(syfcSalesNo);
//						}else {
//							//insert
//							mapper.insertSelective(syfcSalesNo);
//						}
//					} catch (Exception e) {
//						logger.error("保存异常预售许可证发生，NO:{},ID:",syfcSalesNo.getThirdNo(),syfcSalesNo.getThirdRecordId(),e);
//					}
				//洗到mongo
//					try {
//						Query sales_number_record = new Query();
//						sales_number_record.addCriteria(Criteria.where("third_record_id").is(syfcSalesNo.getThirdRecordId()));
//						JSONObject salesNumRecord = mongoTemplate.findOne(sales_number_record, JSONObject.class, "sales_number_record");
//						if(salesNumRecord != null ) {
//							//update
//							Update update = Update.update("approve_date", syfcSalesNo.getApproveDate())
//							.set("program_localtion", syfcSalesNo.getProgramLocaltion())
//							.set("third_no", syfcSalesNo.getThirdNo())
//							.set("company", syfcSalesNo.getCompany())
//							.set("sales_no", syfcSalesNo.getSalesNo());
//							mongoTemplate.updateFirst(salesNumTaskQuery, update, salesNumberRecordCollectionName);
//						}else {
//							//insert
//							SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//							salesNum.put("collect_time", sdf.format(new Date()));
//							mongoTemplate.insert(salesNum,salesNumberRecordCollectionName);
//						}
//					} catch (Exception e) {
//						logger.error("保存异常预售许可证发生，NO:{},ID:",syfcSalesNo.getThirdNo(),syfcSalesNo.getThirdRecordId(),e);
//					}
			}
		}
		
	}
	
	@Override
	public void transformSalesPrice() {
		//拿到detail的预售许可证号
		Query query = new Query();
		List<JSONObject> salesNumList = mongoTemplate.find(query, JSONObject.class, salesNumberRecordCollectionName);
		//保存预售许可证
		for (Object salesNoObj : salesNumList) {
			SYFCSalesNo syfcSalesNo = new SYFCSalesNo();
			JSONObject salesNum = (JSONObject)salesNoObj;
			try {
				Date approveDate = salesNum.getDate("date");//审核日期
				String programLocaltion = salesNum.getString("program_localtion");//项目地址
				Integer thirdNo = salesNum.getInteger("no");//编号
				String salesNo = salesNum.getString("sales_no");//预售许可证号
				String company = salesNum.getString("company");//公司
				String thirdRecordId = salesNum.getString("third_record_id");//第三方主键
				syfcSalesNo.setApproveDate(approveDate);
				syfcSalesNo.setProgramLocaltion(programLocaltion);
				syfcSalesNo.setThirdNo(thirdNo);
				syfcSalesNo.setCompany(company);
				syfcSalesNo.setThirdRecordId(thirdRecordId);
				syfcSalesNo.setSalesNo(salesNo);
				syfcSalesNo.setCreateUid(200);
				syfcSalesNo.setUpdateUid(200);
			} catch (Exception e) {
				logger.error("解析爬取数据发生异常，NO:{},ID:",syfcSalesNo,e);
				continue;
			}
			//洗到mongo
			try {
				//TODO:没补全update判断
				//insert
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				JSONObject insertJson = new JSONObject();
				insertJson.put("collect_time", sdf.format(new Date()));
				insertJson.put("collect_state", "0");
				insertJson.put("sales_no", syfcSalesNo.getSalesNo());
				insertJson.put("no", syfcSalesNo.getThirdNo());
				mongoTemplate.insert(insertJson,salesPriceListRecordCollectionName);
			} catch (Exception e) {
				logger.error("保存异常预售许可证发生，NO:{},ID:",syfcSalesNo.getThirdNo(),syfcSalesNo.getThirdRecordId(),e);
			}
		}
	}
	
	
	@Override
	public void transformSalesNoDetail() {
		//读取已经采集到的
		Query query = new Query();
		//未转换的并且是已采集的
		query.addCriteria(Criteria.where("transform_state").ne(1).and("collect_state").is(1));
		List<JSONObject> salesNoDetailList = mongoTemplate.find(query, JSONObject.class, salesNumberRecordCollectionName);
//		List<JSONObject> salesNoDetailList = mongoTemplate.findAll(JSONObject.class, salesNumberRecordCollectionName);
		for (JSONObject salesNoDetail : salesNoDetailList) {
			//保存预售许可证
			SYFCSalesNo syfcSalesNo = new SYFCSalesNo();
			try {
				Date approveDate = salesNoDetail.getDate("date");//审核日期
				if(approveDate == null) { 
					salesNoDetail.getDate("approve_date");//审核日期
				}
				syfcSalesNo.setApproveDate(approveDate);
				syfcSalesNo.setProgramLocaltion(salesNoDetail.getString("program_localtion"));
				String remark = salesNoDetail.getString("remark");
				JSONObject remarkException = new JSONObject();
				//TODO:字段无法映射，导致不能用反射，先写死吧。
				//no
				try {
					syfcSalesNo.setThirdNo(salesNoDetail.getInteger("no"));
				} catch (Exception e) {
					logger.error("异常序号，NO:{},ID:{}",salesNoDetail.get("no"),salesNoDetail.getString("third_record_id"));
					remarkException.put("no", salesNoDetail.get("no"));
				}
				syfcSalesNo.setSalesNo(salesNoDetail.getString("sales_no"));
				syfcSalesNo.setCompany(salesNoDetail.getString("company"));
				syfcSalesNo.setThirdRecordId(salesNoDetail.getString("third_record_id"));
				//build_count
				try {
					syfcSalesNo.setBuildCount(salesNoDetail.getInteger("build_count"));
				} catch (Exception e) {
					logger.error("异常建筑栋数，NO:{},ID:{}",salesNoDetail.get("build_count"),salesNoDetail.getString("third_record_id"));
					remarkException.put("build_count", salesNoDetail.get("build_count"));
				}
				//total_build_area
				try {
					syfcSalesNo.setTotalBuildArea(salesNoDetail.getFloat("total_build_area"));
				} catch (Exception e) {
					logger.error("异常建筑面积，NO:{},ID:{}",salesNoDetail.get("total_build_area"),salesNoDetail.getString("third_record_id"));
					remarkException.put("total_build_area", salesNoDetail.get("total_build_area"));
				}
				//sales_area
				try {
					syfcSalesNo.setSalesArea(salesNoDetail.getFloat("sales_area"));
				} catch (Exception e) {
					logger.error("异常建筑面积，NO:{},ID:{}",salesNoDetail.get("sales_area"),salesNoDetail.getString("third_record_id"));
					remarkException.put("sales_area", salesNoDetail.get("sales_area"));
				}
				//dwelling_area
				try {
					syfcSalesNo.setDwellingArea(salesNoDetail.getFloat("dwelling_area"));
				} catch (Exception e) {
					logger.error("异常房屋面积，NO:{},ID:{}",salesNoDetail.get("dwelling_area"),salesNoDetail.getString("third_record_id"));
					remarkException.put("dwelling_area", salesNoDetail.get("dwelling_area"));
				}
				//shop_area
				try {
					syfcSalesNo.setShopArea(salesNoDetail.getFloat("shop_area"));
				} catch (Exception e) {
					logger.error("异常shop_area，NO:{},ID:{}",salesNoDetail.get("shop_area"),salesNoDetail.getString("third_record_id"));
					remarkException.put("shop_area", salesNoDetail.get("shop_area"));
				}
				//public_area
				try {
					syfcSalesNo.setPublicArea(salesNoDetail.getFloat("public_area"));
				} catch (Exception e) {
					logger.error("异常public_area，NO:{},ID:{}",salesNoDetail.get("public_area"),salesNoDetail.getString("third_record_id"));
					remarkException.put("public_area", salesNoDetail.get("public_area"));
				}
				//other_area
				try {
					syfcSalesNo.setOtherArea(salesNoDetail.getFloat("other_area"));
				} catch (Exception e) {
					logger.error("异常other_area，NO:{},ID:{}",salesNoDetail.get("other_area"),salesNoDetail.getString("third_record_id"));
					remarkException.put("other_area", salesNoDetail.get("other_area"));
				}
				//过长截断
				if(salesNoDetail.containsKey("dwelling_build_no") && salesNoDetail.getString("dwelling_build_no").length() > 100) {
					remarkException.put("dwelling_build_no_too_long", salesNoDetail.getString("dwelling_build_no"));
				}else {
					syfcSalesNo.setDwellingBuildNo(salesNoDetail.getString("dwelling_build_no"));
				}
				syfcSalesNo.setShopBuildNo(salesNoDetail.getString("shop_build_no"));
				syfcSalesNo.setPublicBuildNo(salesNoDetail.getString("public_build_no"));
				syfcSalesNo.setOtherBuildNo(salesNoDetail.getString("other_build_no"));
				//dwelling_build_count
				try {
					syfcSalesNo.setDwellingBuildCount(salesNoDetail.getInteger("dwelling_build_count"));
				} catch (Exception e) {
					logger.error("异常dwelling_build_count，NO:{},ID:{}",salesNoDetail.get("dwelling_build_count"),salesNoDetail.getString("third_record_id"));
					remarkException.put("dwelling_build_count", salesNoDetail.get("dwelling_build_count"));
				}
				//shop_build_count
				try {
					syfcSalesNo.setShopBuildCount(salesNoDetail.getInteger("shop_build_count"));
				} catch (Exception e) {
					logger.error("异常shop_build_count，NO:{},ID:{}",salesNoDetail.get("shop_build_count"),salesNoDetail.getString("third_record_id"));
					remarkException.put("shop_build_count", salesNoDetail.get("shop_build_count"));
				}
				//public_build_count
				try {
					syfcSalesNo.setPublicBuildCount(salesNoDetail.getInteger("public_build_count"));
				} catch (Exception e) {
					logger.error("异常public_build_count，NO:{},ID:{}",salesNoDetail.get("public_build_count"),salesNoDetail.getString("third_record_id"));
					remarkException.put("public_build_count", salesNoDetail.get("public_build_count"));
				}
				//other_build_count
				try {
					syfcSalesNo.setOtherBuildCount(salesNoDetail.getInteger("other_build_count"));
				} catch (Exception e) {
					logger.error("异常other_build_count，NO:{},ID:{}",salesNoDetail.get("other_build_count"),salesNoDetail.getString("third_record_id"));
					remarkException.put("other_build_count", salesNoDetail.get("other_build_count"));
				}
				if(!remarkException.isEmpty()) {
					remark += remarkException.toJSONString();
				}
				syfcSalesNo.setRemark(remark);
				syfcSalesNo.setCreateUid(200);
				syfcSalesNo.setUpdateUid(200);
				syfcSalesNo.setDataStatus(DataStatus.NORMAL);
				//洗到mysql 只有第三方ID才是惟一标识
				SYFCSalesNoExample example = new SYFCSalesNoExample();
				example.createCriteria().andThirdRecordIdEqualTo(syfcSalesNo.getThirdRecordId());
				example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
				List<SYFCSalesNo> selectByExample = mapper.selectByExample(example);
				if(selectByExample.size()>0) {
					//update
					SYFCSalesNo syfcSalesNoUpdate = selectByExample.get(0);
					syfcSalesNo.setId(syfcSalesNoUpdate.getId());
					mapper.updateByPrimaryKeySelective(syfcSalesNo);
				}else {
					//insert
					mapper.insertSelective(syfcSalesNo);
				}
				Query updateQuery = new Query();
				//变更转换状态为已转换
				updateQuery.addCriteria(Criteria.where("third_record_id").is(syfcSalesNo.getThirdRecordId()));
				Update update = Update.update("transform_state",1);
				mongoTemplate.updateFirst(updateQuery, update, salesNumberRecordCollectionName);
			}catch (Exception e) {
				logger.error("保存异常预售许可证发生，NO:{},ID:{}",syfcSalesNo.getThirdNo(),syfcSalesNo.getThirdRecordId(),e);
			}
		}
	}
	
	@Override
	public void transformIncrementSalesNoDetail() {
		//新增的采集预售许可详情数据
		List<JSONObject> salesNoDetailList = mongoTemplate.findAll(JSONObject.class, syfcSalesNumDetailNewCollectionName);
		for (JSONObject salesNoDetai : salesNoDetailList) {
			//按照第三方记录updateinsert，如果没有则插入，有则更新。
			Query query = new Query();
			query.addCriteria(Criteria.where("third_record_id").is(salesNoDetai.get("third_record_id")));
			Update update = Update.update("date", salesNoDetai.get("date"))
					.set("no", salesNoDetai.get("no"))
					.set("program_localtion", salesNoDetai.get("program_localtion"))
					.set("deltail_uri", salesNoDetai.get("deltail_uri"))
					.set("sales_no", salesNoDetai.get("sales_no"))
					.set("company", salesNoDetai.get("company"))
					.set("href", salesNoDetai.get("href"))
					.set("collect_time", salesNoDetai.get("collect_time"))
					.set("third_record_id", salesNoDetai.get("third_record_id"))
					;
			mongoTemplate.upsert(query, update, salesNoDetai.getClass(), salesNumberRecordCollectionName);
			//移除新采集数据
			mongoTemplate.remove(query, syfcSalesNumDetailNewCollectionName);
		}
		//修正列表的no
//		Query updateQuery = new Query();
//		Update update = new Update();
//	    update.inc("no", size);
//		mongoTemplate.updateMulti(updateQuery, update, salesNumberRecordCollectionName);
		
	}
}