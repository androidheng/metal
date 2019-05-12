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
import com.metal.pojo.TbData;
import com.metal.pojo.TbMine;
import com.metal.pojo.TbWarehouse;
import com.metal.service.DataService;
import com.metal.service.MineService;
import com.metal.service.WarehouseService;
import com.metal.utils.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/data")
public class DataController {

	@Autowired
	private DataService dataService;
	@Autowired
	private MineService mineService;
	@Autowired
	private WarehouseService warehouseService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbData> findAll(){			
		return dataService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return dataService.findPage(page, rows);
	}
	
	/**
	 * 添加或者修改
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbData data){
		if(StringUtils.isEmpty(data.getId())) {
			try {
				TbMine tbMine=mineService.findOne(data.getMid());
				TbWarehouse tbWarehouse=warehouseService.findOne(data.getWid());
			data.setMinename(tbMine.getMinename());
			data.setWarename(tbWarehouse.getWarename());
			dataService.add(data);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
		}else{
			try {
			dataService.update(data);
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
	public TbData findOne(Integer id){
		return dataService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbData data){
		try {
			dataService.delete(data.getId());
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
	public PageResult search(Integer mid,Integer wid, int page, int limit  ){
		TbData data=new TbData();
		if(!StringUtils.isEmpty(mid)) {
			data.setMid(mid);
		}
		if(!StringUtils.isEmpty(wid)) {
			data.setWid(wid);
		}
		return dataService.findPage(data, page, limit);		
	}
	 @ResponseBody
	 @RequestMapping("/search2")
	 public PageResult search2(Integer mid,Integer wid, int page, int limit  ){
		 TbData data=new TbData();
		 if(!StringUtils.isEmpty(mid)) {
			 data.setMid(mid);
		 }
		 if(!StringUtils.isEmpty(wid)) {
			 data.setWid(wid);
		 }
		 return dataService.findPage2(data, page, limit);		
	 }
	 @ResponseBody
	 @RequestMapping("/findYun")
	 public PageResult findYun(String type,String date, int page, int limit  ){
		 return dataService.findYun(type,date, page, limit);		
	 }
	 @ResponseBody
	 @RequestMapping("/statistical")
	 public PageResult statistical(String type,String date,Integer mid,Integer wid, int page, int limit  ){
		 return dataService.statistical(type,mid,wid,date, page, limit);		
	 }
	
	 
	
}
