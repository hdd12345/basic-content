package com.hdd.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hdd.entity.News;
import com.hdd.util.DButil;

public class NewsService {
	public static Connection conn;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public final static int MAX_SIZE=6;//每页最大条数
	
	/**
	 * 获取总页数
	 */
	
	public static int countPage(){
		int countPage=0;
		int total=0;
		List<News> list=allNews();
		total=list.size();
		countPage=total%MAX_SIZE==0?total/MAX_SIZE:total/MAX_SIZE+1;
		if(countPage!=0){
			return countPage;
		}
		return 1;//没有第0页
		
	}
	
	/**
	 * 查询每页指定条数
	 * @throws SQLException 
	 */
	public static List<News> selectCurrent(int currentPage) throws SQLException{
		conn=DButil.Dbutil();
	  	String sql="select * from news limit ?,?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,(currentPage-1)*MAX_SIZE);
		pstmt.setInt(2,MAX_SIZE);
	  	rs=pstmt.executeQuery();
	  	List<News> list=new ArrayList<News>();
	  	while(rs.next()){
	  		News news=new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getDate("newstime"));
	  		list.add(news);
	  	}
	  	return list;
	}
	
	/**
	 * 查询所有新闻
	 * @return
	 */
	public static List<News> allNews(){
		List<News> list=new ArrayList<News>();
		String sql="select * from news";
		try {
			conn=DButil.Dbutil();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				News news=new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getDate("newstime"));
		  		list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseAll();
		return list;
	}
	
	/**
	 * 通过id查询新闻
	 * @param id
	 * @return
	 */
	public static News selectById(int id){
		News news=new News();
		String sql="select * from news where id=?";
		try {
			conn=DButil.Dbutil();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setDate(rs.getDate("newstime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		CloseAll();
		return news;
	}
	
	/**
	 * 添加新闻
	 * @param title
	 * @param content
	 * @return
	 */
	public static boolean addNews(String title,String content){
		String sql="insert into news (title,content,newstime)values (?,?,?)";
		conn=DButil.Dbutil();
		int flag=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setDate(3,new Date(System.currentTimeMillis()));
			flag=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseAll();
		if(flag>0)return false;
		else return true;
	}
	
	/**
	 * 删除新闻
	 * @param id
	 * @return
	 */
	public static boolean deleteNews(int id){
		String sql="delete from news where id=?";
		conn=DButil.Dbutil();
		int flag=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			flag=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseAll();
		if(flag>0)return true;
		else return false;
	}
	
	/**
	 * 修改新闻
	 * @param title
	 * @param content
	 * @param id
	 * @return
	 */
	public static boolean updateNews(String title,String content, int id){
		String sql="update news set title=?,content=? where id=?";
		conn=DButil.Dbutil();
		int flag=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setInt(3,id);
			flag=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag>0)return true;
		else return false;
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
