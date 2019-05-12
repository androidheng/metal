package com.metal.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import com.metal.mapper.TbDataMapper;
import com.metal.pojo.TbData;
import com.metal.pojo.TbDataExample;
import com.metal.pojo.TbDataExample.Criteria;
import com.metal.service.DataService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private TbDataMapper dataMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbData> findAll() {
		return dataMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbData> page=   (Page<TbData>) dataMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbData data) {
		dataMapper.insert(data);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbData data){
		dataMapper.updateByPrimaryKeySelective(data);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbData findOne(Integer id){
		return dataMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		dataMapper.deleteByPrimaryKey(id);
				
	}
	
	
		@Override
	public PageResult findPage(TbData data, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbDataExample example=new TbDataExample();
		Criteria criteria = example.createCriteria();
		
		if(data!=null){			
				
			if(!StringUtils.isEmpty(data.getMid())) {
				criteria.andMidEqualTo(data.getMid());
			}
			if(!StringUtils.isEmpty(data.getWid())) {
				criteria.andWidEqualTo(data.getWid());
			}
		}
		Page<TbData> page= (Page<TbData>)dataMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbData> findHistoryData(Integer mid,String date) {
			return null;
		}

		@Override
		public PageResult findPage2(TbData data, int pageNum, int pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			
			Page<TbData> page= (Page<TbData>)dataMapper.findPeiData(data.getMid(), data.getWid());		
			return new PageResult(0,"",page.getTotal(), page.getResult());
		}

		@Override
		public PageResult findYun(String type, String date, int pageNum, int pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			if(type.equals("0")) {
				Page<TbData> page= (Page<TbData>)dataMapper.findYunDay(date);		
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}else if(type.equals("1")) {
				Page<TbData> page= (Page<TbData>)dataMapper.findYunMonth(date);		
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}else {
				Page<TbData> page= (Page<TbData>)dataMapper.findYunYear(date);		
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}
			
		}

		@Override
		public PageResult statistical(String type, Integer mid, Integer wid, String date, int pageNum, int pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			if(type.equals("0")) {
				Page<TbData> page= (Page<TbData>)dataMapper.findDay(date, mid, wid);		
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}else if(type.equals("1")) {
				Page<TbData> page= (Page<TbData>)dataMapper.findMonth(date, mid, wid);		
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}else {
				Page<TbData> page= (Page<TbData>)dataMapper.findYear(date, mid, wid);		
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}
		}
	
}
