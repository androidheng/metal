package com.metal.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metal.pojo.TbBase;
import com.metal.pojo.TbMine;
import com.metal.pojo.TbWarehouse;
import com.metal.pojo.TbYearplan;
import com.metal.service.BaseService;
import com.metal.service.MineService;
import com.metal.service.YearplanService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/yearplan")
public class YearplanController {

	@Autowired
	private YearplanService yearplanService;
	@Autowired
	private BaseService baseService;
	@Autowired
	private MineService mineService;
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbYearplan> findAll(){			
		return yearplanService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return yearplanService.findPage(page, rows);
	}
	
	/**
	 * 添加或者修改
	 * @param yearplan
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbYearplan yearplan){
		if(StringUtils.isEmpty(yearplan.getId())) {
			try {
				TbMine tbMine = mineService.findOne(yearplan.getMid());
				yearplan.setMinename(tbMine.getMinename());
			yearplanService.add(yearplan);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
		}else{
			try {
			yearplanService.update(yearplan);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
		}
		
	}
	

	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findOne")
	public TbYearplan findOne(Integer id){
		return yearplanService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbYearplan yearplan){
		try {
			yearplanService.delete(yearplan.getId());
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param key
	 * @param page
	 * @param limit
	 * @return
	 */
	 @ResponseBody
	@RequestMapping("/search")
	public PageResult search(String key, int page, int limit  ){
		TbYearplan yearplan=new TbYearplan();
		if(!StringUtils.isEmpty(key)) {
			yearplan.setMid(Integer.parseInt(key));
		}
		return yearplanService.findPage(yearplan, page, limit);		
	}
	 @ResponseBody
	 @RequestMapping("/findData")
	 public Object findData(String date,Integer mid  ){
		 Map<String, Object> resultMap=new HashMap<>();
		 List<TbYearplan> list1=yearplanService.findDataByMonth(date.substring(0, 4),mid);
		 List<String> result1=new ArrayList<>();
		 for (TbYearplan yearplan : list1) {
			 result1.add(yearplan.getQuantity());
			 result1.add(yearplan.getGoodsweight());
			 result1.add(yearplan.getMachine1());
			 result1.add(yearplan.getMachine2());
			 result1.add(yearplan.getMaintenance());
			 result1.add(yearplan.getWage());
		}
		 resultMap.put("data1", result1);
		 List<TbBase> list2=baseService.findDataByMonth(date,mid);
		 List<String> result2=new ArrayList<>();
		 for (TbBase yearplan : list2) {
			 result2.add(yearplan.getQuantity());
			 result2.add(yearplan.getGoodsweight());
			 result2.add(yearplan.getMachine1());
			 result2.add(yearplan.getMachine2());
			 result2.add(yearplan.getMaintenance());
			 result2.add(yearplan.getWage());
		 }
		 resultMap.put("data2", result2);
		 return resultMap;		
	 }
	 @ResponseBody
	 @RequestMapping(value="/findZhu",produces = "application/json;charset=UTF-8")
	 public Object findZhu(String date,Integer mid  ){
		 List<Map<String, Object>> resultList=new ArrayList<>();
		 Map<String, Object> result=new HashMap<>();
		 Map map=yearplanService.findZhuData(date.substring(0, 4),date,mid);
		 List<String> result1=new ArrayList<>();
			 Map<String, Object> map1=new HashMap<>();
			 map1.put("name", "土方量完成率");
			 map1.put("value", map.get("quantity"));
			 resultList.add(map1);
			 Map<String, Object> map2=new HashMap<>();
			 map2.put("name", "货物产量完成率");
			 map2.put("value", map.get("goodsweight"));
			 resultList.add(map2);
			 result.put("data", resultList);
		 return result;		
	 }
	
}
