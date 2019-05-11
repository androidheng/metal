package com.metal.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import com.metal.mapper.TbMineMapper;
import com.metal.pojo.TbMine;
import com.metal.pojo.TbMineExample;
import com.metal.pojo.TbMineExample.Criteria;
import com.metal.service.MineService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class MineServiceImpl implements MineService {

	@Autowired
	private TbMineMapper mineMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbMine> findAll() {
		return mineMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbMine> page=   (Page<TbMine>) mineMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbMine mine) {
		mineMapper.insert(mine);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbMine mine){
		mineMapper.updateByPrimaryKeySelective(mine);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbMine findOne(Integer id){
		return mineMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		mineMapper.deleteByPrimaryKey(id);
				
	}
	
	
		@Override
	public PageResult findPage(TbMine mine, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbMineExample example=new TbMineExample();
		Criteria criteria = example.createCriteria();
		
		if(mine!=null){			
				
			if(!StringUtils.isEmpty("")) {
				
			}
		}
		
		Page<TbMine> page= (Page<TbMine>)mineMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
