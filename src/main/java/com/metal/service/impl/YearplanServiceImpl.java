package com.metal.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import com.metal.mapper.TbYearplanMapper;
import com.metal.pojo.TbYearplan;
import com.metal.pojo.TbYearplanExample;
import com.metal.pojo.TbYearplanExample.Criteria;
import com.metal.service.YearplanService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class YearplanServiceImpl implements YearplanService {

	@Autowired
	private TbYearplanMapper yearplanMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbYearplan> findAll() {
		return yearplanMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbYearplan> page=   (Page<TbYearplan>) yearplanMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbYearplan yearplan) {
		yearplanMapper.insert(yearplan);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbYearplan yearplan){
		yearplanMapper.updateByPrimaryKeySelective(yearplan);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbYearplan findOne(Integer id){
		return yearplanMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		yearplanMapper.deleteByPrimaryKey(id);
				
	}
	
	
		@Override
	public PageResult findPage(TbYearplan yearplan, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbYearplanExample example=new TbYearplanExample();
		Criteria criteria = example.createCriteria();
		
		if(yearplan!=null){			
				
			if(!StringUtils.isEmpty(yearplan.getMid())) {
				criteria.andMidEqualTo(yearplan.getMid());
			}
		}
		
		Page<TbYearplan> page= (Page<TbYearplan>)yearplanMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbYearplan> findDataByMonth(String date,Integer mid) {
			return yearplanMapper.findEveryMonth(date,mid);
		}

		@Override
		public Map findZhuData(String year,String month, Integer mid) {
			System.err.println(year);
			System.err.println(month);
			System.err.println(mid);
			return yearplanMapper.findBaiFen(year, month, mid);
		}
	
}
