package com.metal.service;
import java.util.List;
import com.metal.pojo.TbYearplan;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface YearplanService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbYearplan> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbYearplan yearplan);
	
	
	/**
	 * 修改
	 */
	public void update(TbYearplan yearplan);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbYearplan findOne(Integer id);
	
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer  id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbYearplan yearplan, int pageNum,int pageSize);
	
}
