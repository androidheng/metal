package com.metal.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import com.metal.mapper.TbWarehouseMapper;
import com.metal.pojo.TbWarehouse;
import com.metal.pojo.TbWarehouseExample;
import com.metal.pojo.TbWarehouseExample.Criteria;
import com.metal.service.WarehouseService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private TbWarehouseMapper warehouseMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbWarehouse> findAll() {
		return warehouseMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbWarehouse> page=   (Page<TbWarehouse>) warehouseMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbWarehouse warehouse) {
		warehouseMapper.insert(warehouse);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbWarehouse warehouse){
		warehouseMapper.updateByPrimaryKeySelective(warehouse);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbWarehouse findOne(Integer id){
		return warehouseMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		warehouseMapper.deleteByPrimaryKey(id);
				
	}
	
	
		@Override
	public PageResult findPage(TbWarehouse warehouse, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbWarehouseExample example=new TbWarehouseExample();
		Criteria criteria = example.createCriteria();
		
		if(warehouse!=null){			
				
			if(!StringUtils.isEmpty("")) {
				
			}
		}
		
		Page<TbWarehouse> page= (Page<TbWarehouse>)warehouseMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
