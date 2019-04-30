package com.hanson.transform.service.impl;

import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanson.transform.TransformBootStarp;
import com.hanson.transform.dao.gen.entity.SYFCCommunity;
import com.hanson.transform.dao.gen.mapper.SYFCCommunityMapper;
import com.hanson.transform.enums.DistrictEnum;
import com.hanson.transform.service.SYFCSalesBuildService;

/**
 * @author Hanson
 * create on 2019年3月25日
 */

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes = TransformBootStarp.class)
@WebAppConfiguration
@Ignore
public class SYFCSalesBuildServiceImplTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    MockMvc mock;
    
    @Autowired
    SYFCSalesBuildService buildService;
  
    @Autowired  
    WebApplicationContext webApplicationConnect;
    
    @Autowired
	SYFCCommunityMapper communityMapper;
    
    @Before(value = "")  
    public void setUp() throws JsonProcessingException {  
    	mock = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();  
    }  

	@Test
	@Ignore
	public void saveCommunity() {
		buildService.saveCommunity();
	}
	
	@Test
	@Ignore
	public void testEnum() {
		SYFCCommunity record = new SYFCCommunity();
		record.setDistrict(DistrictEnum.DA_DONG);
		record.setThirdRecordId(100);
		record.setSalesDate(new Date());
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		record.setCreateUserId(1);
		record.setUpdateUserId(1);
		communityMapper.insertSelective(record );
	}
	@Test
	@Ignore
	public void testCheckCommunity() {
		buildService.checkCommunity();
	}
	@Test
	@Ignore
	public void testCheckBuilding() {
		buildService.checkBuilding();
	}
	@Test
	public void saveHouse() {
		buildService.saveHouse();
	}


}

