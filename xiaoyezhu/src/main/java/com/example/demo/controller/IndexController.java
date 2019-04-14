package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;

@Controller
@RequestMapping(value="/")
public class IndexController {
	
	@RequestMapping(value="/",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView Index(HttpServletRequest request) {
		List<User> userList = new ArrayList<>();
		userList.add(new User("user1","111"));
		userList.add(new User("user2","222"));
		userList.add(new User("user3","333"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",new User("abcd","1234"));
		mav.addObject("userList",userList);
		mav.addObject("utexttest","<span style='color:red'>hello<span/>");
		mav.setViewName("main");
		request.setAttribute("requestparam","request");
		request.getSession().setAttribute("myparam","wbu");
		int[] arr = {1,2};
		System.out.println(arr[2]);
		return mav;
	}
}
