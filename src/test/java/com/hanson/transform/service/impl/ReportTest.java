package com.hanson.transform.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanson.base.util.DateUtils;
import com.hanson.transform.TransformBootStarp;
import com.hanson.transform.dao.gen.mapper.SYFCCommunityMapper;
import com.hanson.transform.service.SYFCSalesBuildService;

/**
 * @author Hanson
 * create on 2019年3月25日
 */

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes = TransformBootStarp.class)
@WebAppConfiguration  
public class ReportTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    MockMvc mock;
    
    @Autowired
    SYFCSalesBuildService buildService;
  
    @Autowired  
    WebApplicationContext webApplicationConnect;
    
    @Autowired
	SYFCCommunityMapper communityMapper;
    
    @Autowired
	MongoTemplate mongoTemplate;
    
    @Before(value = "")  
    public void setUp() throws JsonProcessingException {  
    	mock = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();  
    }  

	@Test
	public void report() {
		String buildingId = "482863";
		Query query = new Query();  
		query.with(new Sort(new Order(Direction.DESC,"start_sales_date")));
		query.addCriteria(Criteria.where("collect_state").is(1).and("build_detail_list").elemMatch(Criteria.where("third_record_id").is(buildingId)));
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.ISO_DATE);
		while(true) {
			String date = sdf.format(ca.getTime());
			JSONObject findOne = mongoTemplate.findOne(query, JSONObject.class,"syfc_new_build_detail_"+date);
			if(findOne == null) {
				break;
			}
			JSONArray jsonArray = findOne.getJSONArray("build_detail_list");
			for (Object object : jsonArray) {
				JSONObject json = (JSONObject)object;
				if(buildingId.equals(json.getString("third_record_id"))) {
					Integer integer = json.getInteger("saled_count");
					logger.info("日期:{},销售:{}",date,integer);
					ca.add(Calendar.DATE, -1);
					break;
				}
			}
		}
	}
}

