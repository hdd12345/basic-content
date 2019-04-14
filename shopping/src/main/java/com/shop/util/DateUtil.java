package com.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 日期格式化，传入参数为日期返回的格式
	 * @param format
	 * @return
	 */
	public static String dateFormat(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
	
	public static void main(String [] args) {
		System.out.println(DateUtil.dateFormat("YYYYMMdd"));
	}
}
