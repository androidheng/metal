package com.metal.service;
import java.util.List;
import com.metal.pojo.TbMine;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface MineService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbMine> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbMine mine);
	
	
	/**
	 * 修改
	 */
	public void update(TbMine mine);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbMine findOne(Integer id);
	
	
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
	public PageResult findPage(TbMine mine, int pageNum,int pageSize);
	
}
