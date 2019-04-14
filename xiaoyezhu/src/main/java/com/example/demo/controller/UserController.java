package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@RestController(value="userController")
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/getUser",method=RequestMethod.POST)
	public User getUser(@RequestBody User user) throws Exception {
		return userMapper.selectUser(user);
	}
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public Object hello() {
		return "hello";
	}
}
