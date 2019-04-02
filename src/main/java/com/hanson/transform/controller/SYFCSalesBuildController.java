package com.hanson.transform.controller;


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
@RequestMapping(value = "/salesBuild")
@Api("新建建筑-清洗数据")
public class SYFCSalesBuildController {
	@Autowired
	SYFCSalesBuildService salesBuildService;
	
	
	@ApiOperation(value = "抽取楼盘详情到Mysql")
	@PostMapping("/detail")
	public ResponseData transformSalesNoDetail() {
		salesBuildService.transform();
		return ResponseData.ok();
	}
}
