package com.metal.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import com.metal.pojo.TbUser;
import com.metal.service.UserService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbUser> findAll(){			
		return userService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return userService.findPage(page, rows);
	}
	
	/**
	 * 添加或者修改
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbUser user){
		if(StringUtils.isEmpty(user.getId())) {
			try {
				user.setUsertype(0);
			userService.add(user);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
		}else{
			try {
			userService.update(user);
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
	public TbUser findOne(Integer id){
		return userService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbUser user){
		try {
			userService.delete(user.getId());
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
		TbUser user=new TbUser();
		if(!StringUtils.isEmpty(key)) {
			user.setUsername(key);
		}
		return userService.findPage(user, page, limit);		
	}
		@ResponseBody
		@RequestMapping("/login")
		public Result login(@RequestBody TbUser user,HttpSession session){
			try {
				TbUser loginUser=userService.login(user);
				if(loginUser!=null) {
					session.setAttribute("login", loginUser);
					return new Result(true, "登录成功");
				}
				return new Result(false, "登录失败");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "登录失败");
			}
		}
		@ResponseBody
		@RequestMapping("/updatePass")
		public Result updatePass(@RequestBody TbUser user,HttpSession session){
			TbUser loginUser=(TbUser) session.getAttribute("login");
			if(loginUser!=null) {
				try {  
					loginUser.setPassword(user.getPassword());
					userService.update(loginUser);
					return new Result(true, "修改成功");
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(false, "登录失败");
				}
			}else {
				return new Result(false, "请先登录");
			}
			
		}
		@ResponseBody
		@RequestMapping("/myInfo")
		public Result myInfo(@RequestBody TbUser user,HttpSession session){
			TbUser loginUser=(TbUser) session.getAttribute("login");
			if(loginUser!=null) {
				try {  
					userService.update(loginUser);
					return new Result(true, loginUser);
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(false, "登录失败");
				}
			}else {
				return new Result(false, "请先登录");
			}
			
		}
}
