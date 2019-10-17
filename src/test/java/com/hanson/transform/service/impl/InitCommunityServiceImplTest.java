package com.hanson.transform.service.impl;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanson.transform.TransformBootStarp;

/**
 * @author Hanson
 * create on 2019年3月25日
 */

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes = TransformBootStarp.class)
@WebAppConfiguration  
@Ignore
public class InitCommunityServiceImplTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    MockMvc mock;
  
    @Autowired  
    WebApplicationContext webApplicationConnect;
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Before(value = "")  
    public void setUp() throws JsonProcessingException {  
    	mock = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();  
    }  

	@Test
	public void initCommunity() {
		List<JSONObject> communityList = mongoTemplate.findAll(JSONObject.class, "syfc_new_build_detail");
		for (JSONObject community : communityList) {
			Query query = new Query();
			query.addCriteria(Criteria.where("community_id").is(community.getInteger("third_record_id")));
			Update update = Update.update("program_describe", community.get("program_describe"))
			.set("district", community.get("district"))
			.set("approve_date", community.get("start_sales_date"))
			.set("subordinate_district", community.get("subordinate_district"))
			.set("company", community.get("company"))
			.set("build_count", community.getInteger("build_count"))
			.set("community_id", community.getInteger("third_record_id"))
			.set("update_time", community.get("update_time"));
			mongoTemplate.upsert(query , update, JSONObject.class,"syfc_community");
		}
	}
}

