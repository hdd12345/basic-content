package com.hdd.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hdd.entity.User;
import com.hdd.util.DButil;

public class UserService {
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	/**
	 * µÇÂ¼
	 * @param user
	 * @return
	 */
	public static boolean login(User user){
		boolean flag=true;
		String sql="select * from user where userNo=? and password=?";
		conn=DButil.Dbutil();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserNo());
			pstmt.setString(2,user.getPassword());
			rs=pstmt.executeQuery();
			if(!rs.next()){
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll();
		return flag;
	}
	
	public static void CloseAll() {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
