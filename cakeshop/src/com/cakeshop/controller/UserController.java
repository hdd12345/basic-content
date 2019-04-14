package com.cakeshop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.entity.User;
import com.cakeshop.service.UserService;
import com.cakeshop.util.MD5Utils;
import com.cakeshop.util.ValidateCodeUtil;

@RequestMapping(value = "/user")
@Controller
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public int register(@RequestBody User user) throws Exception {
		return userService.insertUser(user);
	}

	/**
	 * 激活账号
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/active", method = RequestMethod.POST)
	public int active(@RequestParam String activeCode) throws Exception {
		return userService.updateState(activeCode);
	}
	
	/**
	 * 登录
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public int login(@RequestBody User user, HttpServletRequest request) throws Exception {
		User u = userService.selectUser(user);
		if (u != null) {
			request.getSession().setAttribute("user", u);
			return 1;
		}
		return 0;
	}

	/**
	 * 退出登录：清空session
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView logout(HttpSession session,HttpServletResponse response) throws IOException {
		session.invalidate();
		response.sendRedirect("http://localhost:8080/cakeshop/index.jsp");
		return null;
	}

	/**
	 * 获取验证码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/validateCode.jpg", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView createValidateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ValidateCodeUtil.createCode(request, response);
		return null;
	}

	/**
	 * 验证码验证
	 * @param request
	 * @param word
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/validate", method = { RequestMethod.GET, RequestMethod.POST })
	public int validate(HttpServletRequest request, @RequestParam String word) {
		String real = (String) request.getSession().getAttribute("checkcode_session");
		if (word.equals(real)) {
			return 1;
		}
		return 0;
	}

	/**
	 * 忘记密码，发送验证邮件
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/forgetPassword", method = { RequestMethod.POST, RequestMethod.GET })
	public int forgetPassword(String username) throws Exception {
		return userService.selectUserNameLogin(username);
	}

	/**
	 * 重置密码为123456
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/resetPassword", method = { RequestMethod.POST, RequestMethod.GET })
	public int resetPassword(String code) throws Exception {
		return userService.resetPassword(code);
	}

	/**
	 * 检查用户名是否存在
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/checkUsername", method = { RequestMethod.POST, RequestMethod.GET })
	public int checkUsername(@RequestParam String username) throws Exception {
		return userService.selectUserName(username);
	}

	/**
	 * 更新用户信息（不修改密码）
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public int updateUser(@RequestBody User user, HttpServletRequest request) throws Exception {
		User oldUser = (User) request.getSession().getAttribute("user");
		if(oldUser!=null){
			String oldUId = oldUser.getUser_id();
			user.setUser_id(oldUId);
			return userService.updateUser(user);
		}
		//userService.updateUser(user);
		return -1;
	}

	/**
	 * 更新用户信息（包括修改密码）
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public int updatePassword(@RequestBody User user, HttpSession session) throws Exception {
		User oldUser = (User) session.getAttribute("user");
		String oldUId = oldUser.getUser_id();
		
		user.setUser_id(oldUId);
		String oldPwd = oldUser.getPassword();
		String newPwd = user.getPassword();
		if (!oldPwd.equals(newPwd)) {
			if (userService.updateUser(user) == 1) {
				session.invalidate();
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @param oldpassword
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/jiami", method = RequestMethod.POST)
	public int validateOldpassword(@RequestParam String oldpassword,HttpServletRequest request) throws Exception{
		User user = (User)request.getSession().getAttribute("user");
		if(user.getPassword().equals(MD5Utils.md5(oldpassword))){
			return 1;
		}
		return 0;
	}

}
