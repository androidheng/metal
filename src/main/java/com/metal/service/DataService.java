package com.metal.service;
import java.util.List;
import com.metal.pojo.TbData;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface DataService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbData> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbData data);
	
	
	/**
	 * 修改
	 */
	public void update(TbData data);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbData findOne(Integer id);
	
	
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
	public PageResult findPage(TbData data, int pageNum,int pageSize);
	
	/**
	 * 折线图所需要的数据
	 * @return
	 */
	public List<TbData> findHistoryData(Integer mid,String date);


	public PageResult findPage2(TbData data, int page, int limit);


	public PageResult findYun(String type, String date, int page, int limit);


	public PageResult statistical(String type, Integer mid, Integer wid, String date, int page, int limit);
	
	
}
