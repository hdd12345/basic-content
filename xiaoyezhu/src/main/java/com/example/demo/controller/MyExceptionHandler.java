package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {
	public static final String ERROR_VIEW="error";
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView errorHandler(HttpServletRequest request,
			HttpServletResponse response,Exception e) throws Exception{
		e.printStackTrace();
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.addObject("url",request.getRequestURL());
		mav.setViewName(ERROR_VIEW);
		return mav;
	}
}