package com.hanson.transform.controller;


import com.hanson.transform.service.SYFCSalesBuildMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanson.transform.service.SYFCSalesBuildService;
import com.hanson.base.response.ResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Create by hanlin on 2019年1月28日
 **/
@RestController()
@RequestMapping(value = "/trans")
@Api("新建建筑-清洗数据")
public class SYFCSalesBuildController {
	@Autowired
	SYFCSalesBuildService salesBuildService;

	@Autowired
	SYFCSalesBuildMongoService salesBuildMongoService;
	
	
	@ApiOperation(value = "抽取楼盘到Mysql")
	@PostMapping("/community")
	public ResponseData transformCommunity() {
		salesBuildService.saveCommunity();
		return ResponseData.ok();
	}
	
	@ApiOperation(value = "抽取楼栋到Mysql")
	@PostMapping("/builds")
	public ResponseData transformBuilds() {
		salesBuildService.saveBuilds();
		return ResponseData.ok();
	}
	
	@ApiOperation(value = "抽取房屋信息到Mysql")
	@PostMapping("/houses")
	public ResponseData transformHouse() {
		salesBuildService.saveHouse();
		return ResponseData.ok();
	}


	@ApiOperation(value = "抽取楼盘到Mongo")
	@PostMapping("/mongo/community")
	public ResponseData transformMongoCommunity() {
		salesBuildMongoService.saveCommunity();
		return ResponseData.ok();
	}

	@ApiOperation(value = "抽取楼栋到Mongo")
	@PostMapping("/mongo/builds")
	public ResponseData transformMongoBuilds() {
		salesBuildMongoService.saveBuilds();
		return ResponseData.ok();
	}

	@ApiOperation(value = "抽取房屋信息到Mongo")
	@PostMapping("/mongo/houses")
	public ResponseData transformMongoHouse() {
		salesBuildMongoService.saveHouse();
		return ResponseData.ok();
	}
}
