package com.hdd.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdd.entity.User;
import com.hdd.service.UserService;
@RequestMapping(value="/user")
//@Controller
@RestController
public class UserController {
	@Resource(name="userServiceImpl")
	private UserService userServiceImpl;
	
//	private ThreadLocal<UserService> tl = new ThreadLocal<>();
//	UserService usi = tl.get();
	
//	@Autowired
//	private User user;
	
//	@RequestMapping(value="/{hhh}/login",method={RequestMethod.POST,RequestMethod.GET})
//	public User login(@PathVariable(value="hhh") String hhh){
//		System.out.println(hhh);
//		return null;
//	}
	
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	public User login(@RequestParam(value="idi",required=true) int id,
			HttpServletRequest request) throws Exception {
		System.out.println(userServiceImpl.findUser(id));
		System.out.println(request.getHeader("content-type"));
		return userServiceImpl.findUser(id);
	}

}
