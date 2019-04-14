package com.cakeshop.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;

public class CommonUtil {
	/**
	 * ���ڸ�ʽ�����������Ϊ���ڷ��صĸ�ʽ
	 * @param format
	 * @return
	 */
	public static String dateFormat(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
	
	/**
	 * ��ȡnλ�����
	 * @return
	 */
	public static String getRandomNum(int n) {
		StringBuilder sb = new StringBuilder("");
		Random random = new Random();
		for(int i=0;i<n;i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
	

	public static void mapToObject(Map<String,String> map, Object obj) {  
	        try {  
	
	        	DateTimeConverter dtConverter = new DateTimeConverter();
	
	        	ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
	
	        	convertUtilsBean.deregister(Date.class);
	
	        	convertUtilsBean.register(dtConverter, Date.class);
	
	        	BeanUtilsBean beanUtilsBean = new BeanUtilsBean(convertUtilsBean,
	
	        		new PropertyUtilsBean());
	
	        	beanUtilsBean.populate(obj, map);
	        } catch (Exception e) {  
	        }  
	        return;  
	 } 
}
