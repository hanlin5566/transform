package com.hanson.transform.service;

import java.util.List;

import com.hanson.base.mybatis.pagination.entity.PageInfo;
import com.hanson.transform.dao.gen.entity.SYFCSalesNo;

/**
 * Create by hanlin on 2019年1月28日
 **/
public interface SYFCSalesNoService {
	/**
	 * 新增一条数据
	 * @param {@link SYFCSalesNo} sYFCSalesNo
	 * @return
	 */
	public Integer insert(SYFCSalesNo sYFCSalesNo);
	/**
	 * 删除一条数据
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	/**
	 * 修改一条数据
	 * @param {@link SYFCSalesNo} sYFCSalesNo
	 * @return
	 */
	public Integer update(SYFCSalesNo sYFCSalesNo);
	/**
	 * 根据主键获取一条未被删除的数据
	 * @param id
	 * @return
	 */
	public SYFCSalesNo get(Integer id);
	/**
	 * 根据条件检索数据
	 * @param {@link User}
	 * @param {@link PageInfo}
	 * @return
	 */
	public List<SYFCSalesNo> search(SYFCSalesNo sYFCSalesNo,PageInfo page);
	
	/**
	 * 清洗预售许可证
	 * @param {@link User}
	 * @param {@link PageInfo}
	 * @return
	 */
	public void transform(String taskId);
	/**
	 * 清洗售价列表
	 * @param {@link User}
	 * @param {@link PageInfo}
	 * @return
	 */
	public void transformSalesPrice(String taskId);
	
	
	
}