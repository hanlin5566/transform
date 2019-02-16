package com.hanson.transform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanson.transform.dao.gen.entity.SYFCSalesNo;
import com.hanson.transform.service.SYFCSalesNoService;
import com.hzcf.base.response.ResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Hanson
 * create on 2019年2月8日
 */
@RestController()
@RequestMapping(value = "/syfcTransform")
@Api("沈阳房产清洗数据")
public class SYFCTransformController {
	@Autowired
	SYFCSalesNoService salesNoService;
	
	/**
	 * 新增
	 * @param sYFCSalesNo
	 * @return
	 */
	@PostMapping()
	public ResponseData add(@RequestBody SYFCSalesNo sYFCSalesNo){
		Integer id = salesNoService.insert(sYFCSalesNo);
		return ResponseData.ok(id);
	}
	
	@ApiOperation(value = "继续爬取沈阳房产预售证", notes = "根据传入的参数，地址，返回爬取内容")
	@PostMapping("/{taskId}")
	public ResponseData continueExecute(@PathVariable String taskId) {
		salesNoService.transform(taskId);
		return ResponseData.ok();
	}
	
	@ApiOperation(value = "根据预售许可证列表清晰需要采集的预售价格", notes = "根据传入的参数，地址，返回爬取内容")
	@PostMapping("/salesPrice/{taskId}")
	public ResponseData transformSalesPrice(@PathVariable String taskId) {
		salesNoService.transformSalesPrice(taskId);
		return ResponseData.ok();
	}
}

