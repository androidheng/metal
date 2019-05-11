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
import com.metal.service.BaseService;
import com.metal.service.MineService;
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
@RequestMapping("/base")
public class BaseController {

	@Autowired
	private MineService mineService;
	@Autowired
	private BaseService baseService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbBase> findAll(){			
		return baseService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return baseService.findPage(page, rows);
	}
	
	/**
	 * 添加或者修改
	 * @param base
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbBase base){
		if(StringUtils.isEmpty(base.getId())) {
			try {
				TbMine tbMine = mineService.findOne(base.getMid());
				base.setMinename(tbMine.getMinename());
			baseService.add(base);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
		}else{
			try {
			baseService.update(base);
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
	public TbBase findOne(Integer id){
		return baseService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(Integer id){
		try {
			baseService.delete(id);
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
	@RequestMapping(value="/search",produces = "application/json;charset=UTF-8")
	public PageResult search(String key, int page, int limit  ){
		TbBase base=new TbBase();
		if(!StringUtils.isEmpty(key)) {
			base.setMid(Integer.parseInt(key));
		}
		return baseService.findPage(base, page, limit);		
	}
	 @ResponseBody
	 @RequestMapping(value="/findZheData",produces = "application/json;charset=UTF-8")
	 public Object 	historysearch(Integer mid,String date) {
		 List<TbBase> datas=baseService.findHistoryData(mid,date);
			Map<String, Object> resultMap=new HashMap<String, Object>();
			List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
			List<String> xAxisData=new ArrayList<String>();
			List<String> legendData=new ArrayList<String>();
			Map<String, Object> mp1=new HashMap<String, Object>();
			mp1.put("name", "实际土方量");
			mp1.put("type", "line");
			List<String> quantityList=new ArrayList<String>();
			Map<String, Object> mp2=new HashMap<String, Object>();
			mp2.put("name", "实际货物产量");
			mp2.put("type", "line");
			List<String> goodsweightList=new ArrayList<String>();
			for(TbBase d:datas){
				xAxisData.add(d.getCreatetime());
				quantityList.add(d.getQuantity());
				goodsweightList.add(d.getGoodsweight());
			}
			mp1.put("data", quantityList);
			mp2.put("data", goodsweightList);
				resultList.add(mp1);
				resultList.add(mp2);
			resultMap.put("data", xAxisData);
			resultMap.put("series", resultList);
			return resultMap;		
	 }
	 	@ResponseBody
		@RequestMapping(value="/findZhuData",produces = "application/json;charset=UTF-8")
		public Object findZhuData(Integer mid,String date,HttpSession session) {
			TbUser user=(TbUser) session.getAttribute("user");
			user=new TbUser();
			user.setUsertype(1);
			if(user!=null){
				List<Object> series=new ArrayList<>();
				List<String> data1=new ArrayList<>();
				List<String> data2=new ArrayList<>();
				List<TbBase> datas=baseService.findHistoryData(mid,date);
				Map<String, Object> resultMap=new HashMap<String, Object>();
				List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
				List<String> xDatas=new ArrayList<>(); 
				List<String> mDatas=new ArrayList<>();
				for(TbBase d:datas){
					xDatas.add(d.getCreatetime());
					data1.add(d.getQuantity());
					data2.add(d.getGoodsweight());
				}
				series.add(data1);
				series.add(data2);
				resultMap.put("data", series);
				resultMap.put("xdata", xDatas);
				return resultMap;		
			}
			return "no login";
		}
	 @ResponseBody
	 @RequestMapping(value="/exporthistory",produces = "application/json;charset=UTF-8")
	 public void 	exporthistory(Integer mid,String date,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		 String dates=DateUtils.getName();
			TbUser user=(TbUser) session.getAttribute("user");
			user=new TbUser();
			user.setUsertype(1);
			String searchId;
			if(user!=null){ 
				List<TbBase> datas=baseService.findHistoryData(mid,date);
					Map<String, Object> resultMap=new HashMap<String, Object>();
					List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
					for(TbBase d:datas){
						Map<String, Object> map1=new HashMap<>();
						map1.put("createtime", d.getCreatetime());
						map1.put("quantity", d.getQuantity());
						map1.put("goodsweight", d.getGoodsweight());
						resultList.add(map1);
					}
			
				List<ExcelBean> excel = new ArrayList<>();
				Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
				//设置标题栏
				excel.add(new ExcelBean("日期","createtime",0));
				excel.add(new ExcelBean("实际土方量数据(单位:吨)","quantity",0));
				excel.add(new ExcelBean("实际货物产量数据(单位:吨)","goodsweight",0));
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
				//Map<String,Object> map=new HashMap<String,Object>();  
				// 指定下载的文件名  
				response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
				String name=System.currentTimeMillis()+"";
				response.setHeader("Content-Disposition","attachment;filename="+new String((name+".xlsx").getBytes(),"iso-8859-1"));
				//导出Excel对象  
				XSSFWorkbook workbook = xssfWorkbook;
				OutputStream output;  
			
					output = response.getOutputStream();  
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
