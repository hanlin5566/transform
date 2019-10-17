package com.hanson.transform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aspectj.lang.annotation.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanson.transform.TransformBootStarp;
import com.hanson.transform.dao.gen.mapper.SYFCBuildingMapper;
import com.hanson.transform.dao.gen.mapper.SYFCHouseMapper;

/**
 * @author Hanson
 * create on 2019年3月25日
 */

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes = TransformBootStarp.class)
@WebAppConfiguration  
@Ignore
public class InitHouseServiceImplTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    MockMvc mock;
  
    @Autowired  
    WebApplicationContext webApplicationConnect;
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Autowired  
    SYFCHouseMapper houseMapper;
    
    @Autowired  
    SYFCBuildingMapper buildMapper;
    
    @Before(value = "")  
    public void setUp() throws JsonProcessingException {  
    	mock = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();  
    }  

	@Test
	@Ignore
	public void initHouse() {
	}
	
	@Test
	@Ignore
	public void checkBuilding() {
		long org_monggo_building_count = 0;
		long mysql_building_count = 0;
		long transform_mongo_building_count = 0;
		//列表采集
		List<JSONObject> org_build_mongo_list = mongoTemplate.findAll(JSONObject.class, "syfc_new_build_detail");
		ArrayList<Integer> org_building_id_list = new ArrayList<>();
		for (JSONObject jsonObject : org_build_mongo_list) {
			JSONArray jsonArray = jsonObject.getJSONArray("build_detail_list");
			org_monggo_building_count+=jsonArray.size();
			for (Object building : jsonArray) {
				JSONObject buildingJSON = (JSONObject)building;
				try {
					buildingJSON.getInteger("third_record_id");
				} catch (Exception e) {
					//只保留数字
					String building_id = buildingJSON.getString("third_record_id");
					String regEx="[^0-9]";  
					Pattern p = Pattern.compile(regEx);  
					Matcher m = p.matcher(building_id);  
					buildingJSON.put("third_record_id",m.replaceAll(""));
				}
				Integer id = buildingJSON.getInteger("third_record_id");
				org_building_id_list.add(id);
			}	
		}
		//mongo清洗
		List<JSONObject> build_mongo_list = mongoTemplate.findAll(JSONObject.class, "syfc_building");
		ArrayList<Integer> syfc_building_id_list = new ArrayList<>();
		transform_mongo_building_count = build_mongo_list.size();
		for (JSONObject jsonObject : build_mongo_list) {
			Integer id = jsonObject.getInteger("building_id");
			syfc_building_id_list.add(id);
		}
		
		
		//mysql清洗
//		SYFCBuildingExample example = new SYFCBuildingExample();
//		example.createCriteria().andDataStatusEqualTo(DataStatus.NORMAL);
//		List<SYFCHouse> mysqlTransFormList = syfcHouseMapper.selectByExample(example);
		ArrayList<Integer> mysql_id_list = new ArrayList<>();
//		mysql_building_count = mysqlTransFormList.size();
//		for (SYFCHouse syfcBuilding : mysqlTransFormList) {
//			Integer thirdBuildId = syfcBuilding.getBuildingId();
//			mysql_id_list.add(thirdBuildId);
//		}
		logger.info("org_monggo_building_count size:{}",org_monggo_building_count);
		logger.info("transform_mongo_building_count size:{}",transform_mongo_building_count);
		logger.info("mysql_building_count size:{}",mysql_building_count);
		//比对
		//清洗少了
		if(org_monggo_building_count > transform_mongo_building_count) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(org_building_id_list);
			temp.removeAll(syfc_building_id_list);
			for (Integer integer : temp) {
				logger.info("未清洗到Mongo的主键{}",integer);
			}
		}
		
		if(org_monggo_building_count > mysql_building_count) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(org_building_id_list);
			temp.removeAll(mysql_id_list);
			for (Integer integer : temp) {
				logger.info("未清洗到mysql的主键{}",integer);
			}
		}
		
		//清洗多了
		if(transform_mongo_building_count > org_monggo_building_count) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(syfc_building_id_list);
			temp.removeAll(org_building_id_list);
			for (Integer integer : temp) {
				logger.info("Mongo多余的主键{}",integer);
			}
		}
		
		if(mysql_building_count > org_monggo_building_count) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(mysql_id_list);
			temp.removeAll(org_building_id_list);
			for (Integer integer : temp) {
				logger.info("mysql多余的主键{}",integer);
			}
		}
		
	}
}

