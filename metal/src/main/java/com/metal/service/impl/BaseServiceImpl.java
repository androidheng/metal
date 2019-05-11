package com.metal.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import com.metal.mapper.TbBaseMapper;
import com.metal.pojo.TbBase;
import com.metal.pojo.TbBaseExample;
import com.metal.pojo.TbBaseExample.Criteria;
import com.metal.service.BaseService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class BaseServiceImpl implements BaseService {

	@Autowired
	private TbBaseMapper baseMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbBase> findAll() {
		return baseMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbBase> page=   (Page<TbBase>) baseMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbBase base) {
		baseMapper.insert(base);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbBase base){
		baseMapper.updateByPrimaryKeySelective(base);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbBase findOne(Integer id){
		return baseMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		baseMapper.deleteByPrimaryKey(id);
				
	}
	
	
		@Override
	public PageResult findPage(TbBase base, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbBaseExample example=new TbBaseExample();
		Criteria criteria = example.createCriteria();
		
		if(base!=null){			
				
			if(!StringUtils.isEmpty("")) {
				
			}
		}
		
		Page<TbBase> page= (Page<TbBase>)baseMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
