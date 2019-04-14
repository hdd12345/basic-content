package com.time.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.time.entity.TimeLog;

public class JsonUtil {
	 
	
	public static void main(String[] args) {
		String data = "[{'tlId':1,'uId':1,'start':1528273318000,'expire':1526828594000,'achieve':1,'failtime':1526828594000}]";
		List<TimeLog> t = new ArrayList<TimeLog>();
		TimeLog timeLog = new TimeLog();
		timeLog.setAchieve(1);
		timeLog.setExpire(new Date(1528273318000L));
		t.add(timeLog);
		TimeLog timeLog2 = new TimeLog();
		timeLog2.setAchieve(1);
		timeLog2.setExpire(new Date(1528273315000L));
		t.add(timeLog2);
		
		String json = JSONObject.toJSONString(t);
		System.out.println(json);
		
		
		List<TimeLog> timeLogs = JSON.parseArray(json, TimeLog.class);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeLogs.get(0).getExpire()));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeLogs.get(1).getExpire()));
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1498457677473L)));	
		}
	}
