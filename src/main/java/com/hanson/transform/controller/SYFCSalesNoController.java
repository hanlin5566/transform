package com.hanson.transform.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanson.transform.service.SYFCSalesNoService;
import com.hanson.base.response.ResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Create by hanlin on 2019年1月28日
 **/
@RestController()
@RequestMapping(value = "/salesNo")
@Api("预售许可详情-清洗数据")
public class SYFCSalesNoController {
	@Autowired
	SYFCSalesNoService salesNoService;
	
	
	@ApiOperation(value = "抽取预售许可证详情到Mysql")
	@PostMapping("/detail")
	public ResponseData transformSalesNoDetail() {
		salesNoService.transformSalesNoDetail();
		return ResponseData.ok();
	}
	
	
	@ApiOperation(value = "增量收取预售许可证详情")
	@PostMapping("/increment")
	public ResponseData transformIncrementSalesNoDetail() {
		salesNoService.transformIncrementSalesNoDetail();
		return ResponseData.ok();
	}
}
