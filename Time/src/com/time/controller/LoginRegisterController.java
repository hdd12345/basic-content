package com.time.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.time.entity.Manager;
import com.time.entity.User;
import com.time.service.ManagerService;
import com.time.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/loginRegister")
@Controller
public class LoginRegisterController extends BaseController {
	@Resource(name = "userServiceImpl")
	private UserService userServiceImpl;
	@Resource(name = "managerServiceImpl")
	private ManagerService managerServiceImpl;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	@ResponseBody
	public int insertUser(@RequestBody User user) {
		if(userServiceImpl.selectByUserName(user.getuName()) != null)
			return 0;
		return userServiceImpl.insert(user);
	}

	/**
	 * 二维码登录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/loginByQR/{id}", method = RequestMethod.POST)
	@ResponseBody
	public User loginByQR(@PathVariable("id") Long id, HttpServletRequest request) {
		User user = userServiceImpl.selectByPrimaryKey(id);
		if (user == null)
			return null;
		request.getSession().setAttribute("user", user);
		return user;
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	@ResponseBody
//	public User loginUser(@RequestParam(name = "uName", required = true) String uName,
//			@RequestParam(name = "uPwd", required = true) String uPwd, HttpServletRequest request) {
//		System.out.println(uName);
//		User record = userServiceImpl.selectSelective(new User(uName, uPwd));
//		if (record == null)
//			return null;
//		request.getSession().setAttribute("user", record);
//		return record;
//	}
	public User loginUser(@RequestBody User user, HttpServletRequest request) {
		System.out.println(user.getuName());
		User record = userServiceImpl.selectSelective(user);
		if (record == null)
			return null;
		request.getSession().setAttribute("user", record);
		return record;
	}	
	/**
	 * 管理员登录
	 * 
	 * @param manager
	 * @return
	 */
	@RequestMapping(value = "/loginManager", method = RequestMethod.POST)
	@ResponseBody
	public Manager loginManager(@RequestBody Manager manager, HttpServletRequest request) {
		System.out.println(manager.getmName());
		Manager record = managerServiceImpl.selectSelective(manager);
		if (record == null)
			return null;
		request.getSession().setAttribute("manager", manager);
		return record;

	}
}
