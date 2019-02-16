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
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hanson.base.enums.DataStatus;
import com.hanson.base.mybatis.pagination.entity.PageInfo;
import com.hanson.transform.dao.gen.entity.SYFCSalesNo;
import com.hanson.transform.dao.gen.entity.SYFCSalesNoExample;
import com.hanson.transform.dao.gen.mapper.SYFCSalesNoMapper;
import com.hanson.transform.service.SYFCSalesNoService;
import com.hzcf.base.util.BeanUtils;

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
	private final String eachSalesCollectionName = "syfc_sales_num";
//	//销售许可详情
//	private final String salesNumberRecordCollectionName = "syfc_sales_num_detail";
//	//销售价格列表
	private final String salesPriceListRecordCollectionName = "syfc_sales_price_list";

	@Override
	public void transform(String taskId) {
		//根据taskID查询任务
		//按照ID读取任务
		Query query = new Query();
		query.addCriteria(Criteria.where("taskId").is(taskId));
		List<JSONObject> salesNumList = mongoTemplate.find(query, JSONObject.class, eachSalesCollectionName);
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
		JSONArray status = salesNumTask.getJSONArray("status");
		for (int i = 0; i < status.size(); i++) {
			int state_int = Integer.parseInt(status.get(i).toString());
			if(state_int != 1) {
				logger.error("未取到数据，状态为{}, NO:{}",state_int,i);
			}
			if(state_int == 1) {
				if(!saleNumMap.containsKey(i)) {
					logger.error("未取到数据，数据状态不一致 NO:{}",i);
					continue;
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
					try {
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
					} catch (Exception e) {
						logger.error("保存异常预售许可证发生，NO:{},ID:",syfcSalesNo.getThirdNo(),syfcSalesNo.getThirdRecordId(),e);
					}
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
		
	}
	
	@Override
	public void transformSalesPrice(String taskId) {
		//根据taskID查询任务
		//按照ID读取任务
		Query query = new Query();
		query.addCriteria(Criteria.where("taskId").is(taskId));
		List<JSONObject> salesNumList = mongoTemplate.find(query, JSONObject.class, eachSalesCollectionName);
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
		JSONArray status = salesNumTask.getJSONArray("status");
		for (int i = 0; i < status.size(); i++) {
			int state_int = Integer.parseInt(status.get(i).toString());
			if(state_int != 1) {
				logger.error("未取到数据，状态为{}, NO:{}",state_int,i);
			}
			if(state_int == 1) {
				if(!saleNumMap.containsKey(i)) {
					logger.error("未取到数据，数据状态不一致 NO:{}",i);
					continue;
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
					//洗到mongo
					try {
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
		}
		
	}
}