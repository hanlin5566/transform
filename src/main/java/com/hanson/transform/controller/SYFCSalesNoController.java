package com.hanson.transform.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanson.base.mybatis.pagination.entity.PageInfo;
import com.hanson.transform.dao.gen.entity.SYFCSalesNo;
import com.hanson.transform.service.SYFCSalesNoService;
import com.hzcf.base.exception.ControllerException;
//TODO:需要换成自己的responseCode
import com.hzcf.base.response.ResponseCode;
import com.hzcf.base.response.ResponseData;

/**
 * Create by hanlin on 2019年1月28日
 **/
@RestController()
@RequestMapping(value = "/sYFCSalesNos")
public class SYFCSalesNoController {
	@Autowired
	SYFCSalesNoService sYFCSalesNoService;
	/**
	 * 根据ID查找用户
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseData get(@PathVariable Integer id){
		SYFCSalesNo sYFCSalesNo = sYFCSalesNoService.get(id);
		if(sYFCSalesNo == null){
			return ResponseData.fail(ResponseCode.RESOURCE_NOT_FOUND);
		}
		return ResponseData.ok(sYFCSalesNo);
	}
	/**
	 * 复杂条件查询 查询条件为body中的json
	 * @param sYFCSalesNo
	 * @return
	 */
	@GetMapping()
	public ResponseData search(@RequestBody SYFCSalesNo sYFCSalesNo,PageInfo page){
		List<SYFCSalesNo> list = sYFCSalesNoService.search(sYFCSalesNo,page);
		if(list == null){
			return ResponseData.fail(ResponseCode.RESOURCE_NOT_FOUND);
		}
		return ResponseData.ok(list).appendPageInfo(page);
	}
	/**
	 * 新增
	 * @param sYFCSalesNo
	 * @return
	 */
	@PostMapping()
	public ResponseData add(@RequestBody SYFCSalesNo sYFCSalesNo){
		Integer id = sYFCSalesNoService.insert(sYFCSalesNo);
		return ResponseData.ok(id);
	}
	/**
	 * 修改信息
	 * @param sYFCSalesNo
	 * @return
	 */
	@PutMapping()
	public ResponseData update(@RequestBody SYFCSalesNo sYFCSalesNo){
		Integer id = sYFCSalesNo.getId();
		if(id == null || id < 0) {
			throw new ControllerException(ResponseCode.ERROR_PARAM);
		}
		Integer count = sYFCSalesNoService.update(sYFCSalesNo);
		return ResponseData.ok(count);
	}
	
	/**
	 * 删除信息
	 * @param sYFCSalesNo
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseData delete(@PathVariable Integer id){
		Integer count = sYFCSalesNoService.delete(id);
		return ResponseData.ok(count);
	}
}
