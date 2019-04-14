package com.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ShopUtil {
	/**
	 * 获取n位随机数
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
}
