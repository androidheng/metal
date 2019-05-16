package com.metal.controller;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metal.pojo.TbBase;
import com.metal.pojo.TbData;
import com.metal.pojo.TbMine;
import com.metal.pojo.TbUser;
import com.metal.pojo.TbWarehouse;
import com.metal.service.DataService;
import com.metal.service.MineService;
import com.metal.service.WarehouseService;
import com.metal.utils.DateUtils;
import com.metal.utils.ExcelBean;
import com.metal.utils.ExcelUtil;

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
		 if(StringUtils.isEmpty(type)) {
			 type="0";
		 }
		 if(StringUtils.isEmpty(date)) {
			 date=DateUtils.getCurrentDay();
		 }
		 
		 return dataService.findYun(type,date, page, limit);		
	 }
	 @ResponseBody
	 @RequestMapping(value="/exportYun",produces = "application/json;charset=UTF-8")
	 public void exportYun(String type,String date,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
			 if(StringUtils.isEmpty(type)) {
				 type="0";
			 }
			 if(StringUtils.isEmpty(date)) {
				 date=DateUtils.getCurrentDay();
			 }
		 	String dates=DateUtils.getName();
			TbUser user=(TbUser) session.getAttribute("user");
			user=new TbUser();
			user.setUsertype(1);
			if(user!=null){ 
					PageResult result=findYun(type,date,1,10000);
					Map<String, Object> resultMap=new HashMap<String, Object>();
					List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
					List<TbData> list=result.getData();
					for(TbData d:list){
						Map<String, Object> map1=new HashMap<>();
						map1.put("carno", d.getCarno());
						map1.put("minename", d.getMinename());
						map1.put("warename", d.getWarename());
						map1.put("tonnage", d.getTonnage());
						map1.put("nums", d.getNums());
						resultList.add(map1);
					}
			
				List<ExcelBean> excel = new ArrayList<>();
				Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
				//设置标题栏
				excel.add(new ExcelBean("车辆编号","carno",0));
				excel.add(new ExcelBean("矿山名","minename",0));
				excel.add(new ExcelBean("仓库名","warename",0));
				excel.add(new ExcelBean("运载总吨数","tonnage",0));
				excel.add(new ExcelBean("车辆总趟数","nums",0));
				map.put(0,excel);
				String sheetName = dates+"数据信息";
				//调用ExcelUtil方法
				XSSFWorkbook xssfWorkbook = null;
				try {
					xssfWorkbook = ExcelUtil.createExcelFile(TbBase.class, resultList, map, sheetName);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				System.out.println(xssfWorkbook);
				
				
				try {  	
				response.reset(); //清除buffer缓存  
				// 指定下载的文件名  
				response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
				String name=System.currentTimeMillis()+"";
				response.setHeader("Content-Disposition","attachment;filename="+new String((name+".xlsx").getBytes(),"iso-8859-1"));
				//导出Excel对象  
				XSSFWorkbook workbook = xssfWorkbook;
				OutputStream output = response.getOutputStream();  
					BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
					bufferedOutput.flush();  
					workbook.write(bufferedOutput);  
					bufferedOutput.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}
			}   
	 }
	 @ResponseBody
	 @RequestMapping("/statistical")
	 public PageResult statistical(String type,String date,Integer mid,Integer wid, int page, int limit  ){
		 if(StringUtils.isEmpty(type)) {
			 type="0";
		 }
		 if(StringUtils.isEmpty(date)) {
			 date=DateUtils.getCurrentDay();
		 }
		 return dataService.statistical(type,mid,wid,date, page, limit);		
	 }
	
	 @ResponseBody
	 @RequestMapping(value="/exportstatistical",produces = "application/json;charset=UTF-8")
	 public void exportstatistical(String type,String date,Integer mid,Integer wid,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
			 if(StringUtils.isEmpty(type)) {
				 type="0";
			 }
			 if(StringUtils.isEmpty(date)) {
				 date=DateUtils.getCurrentDay();
			 }
		 	String dates=DateUtils.getName();
			TbUser user=(TbUser) session.getAttribute("user");
			user=new TbUser();
			user.setUsertype(1);
			if(user!=null){ 
					PageResult result=statistical(type,date,mid,wid,1,10000);
					Map<String, Object> resultMap=new HashMap<String, Object>();
					List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
					List<TbData> list=result.getData();
					for(TbData d:list){
						Map<String, Object> map1=new HashMap<>();
						map1.put("carno", d.getCarno());
						map1.put("minename", d.getMinename());
						map1.put("warename", d.getWarename());
						map1.put("tonnage", d.getTonnage());
						map1.put("nums", d.getNums());
						resultList.add(map1);
					}
			
				List<ExcelBean> excel = new ArrayList<>();
				Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
				//设置标题栏
				excel.add(new ExcelBean("车辆编号","carno",0));
				excel.add(new ExcelBean("矿山名","minename",0));
				excel.add(new ExcelBean("仓库名","warename",0));
				excel.add(new ExcelBean("运载总吨数","tonnage",0));
				excel.add(new ExcelBean("车辆总趟数","nums",0));
				map.put(0,excel);
				String sheetName = dates+"数据信息";
				//调用ExcelUtil方法
				XSSFWorkbook xssfWorkbook = null;
				try {
					xssfWorkbook = ExcelUtil.createExcelFile(TbBase.class, resultList, map, sheetName);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				System.out.println(xssfWorkbook);
				
				
				try {  	
				response.reset(); //清除buffer缓存  
				// 指定下载的文件名  
				response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
				String name=System.currentTimeMillis()+"";
				response.setHeader("Content-Disposition","attachment;filename="+new String((name+".xlsx").getBytes(),"iso-8859-1"));
				//导出Excel对象  
				XSSFWorkbook workbook = xssfWorkbook;
				OutputStream output = response.getOutputStream();  
					BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
					bufferedOutput.flush();  
					workbook.write(bufferedOutput);  
					bufferedOutput.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}
			}   
	 }
	
}
