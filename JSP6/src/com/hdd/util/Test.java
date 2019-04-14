package com.hdd.util;

import java.sql.*;

import com.hdd.entity.User;
import com.hdd.service.NewsService;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String sql="select * from user where username=?";
//		Connection conn=DButil.Dbutil();
//		try {
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1,"tom");
//			ResultSet rs=pstmt.executeQuery();
//			if(rs.next()){
//				User user=new User();
//				user.setId(rs.getInt("id"));
//				user.setUsername(rs.getString("username"));
//				user.setPassword(rs.getString("password"));
//				user.setUserno(rs.getString("userno"));
//				System.out.println(user.getUsername());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(DButil.login("tom", "123"));
		System.out.println(NewsService.selectById(1));
	}

}
