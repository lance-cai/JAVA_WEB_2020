package com.lance.web_forum.dao;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.lance.web_forum.connection.*;
import com.lance.web_forum.bean.*;

public class ArticleDao implements GenericBackendDao<Article> {
	private static String pattern = "yyyy-MM-dd hh:mm:ss";
	
	public static String buildDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	} 
	
	@Override
	public List<Article> queryAll() {
		// 1. 設定 sql 語句
		String sql = "SELECT * FROM ARTICLE";
		// 建立 bean 物件
		List<Article> result = new ArrayList<Article>();
		// 2. 取得連線 try with resouce
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery(sql);
			// 3. 迴圈將offset 移到下ㄧ個 rs 元素
 			while(rs.next()) {

 				Article article = new Article();
 				Calendar calendar = Calendar.getInstance();
				article.setArticle_id(rs.getNString("ARTICLE_ID"));
				article.setMember_id(rs.getNString("MEMBER_ID"));
				article.setTitle(rs.getNString("TITLE"));
				article.setContents(rs.getNString("CONTENTS"));
				article.setViews(rs.getInt("VIEWS"));
				article.setLikes(rs.getInt("LIKES"));
				calendar.setTime(rs.getDate("POST_DATE"));
				article.setDatetime(calendar);
				result.add(article);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Article> queryWith(String attribute, String value) {
		String sql = "SELECT * FROM ARTICLE WHERE " + attribute + " = ?";
		List<Article> result = new ArrayList<Article>();
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();
			// 3. 迴圈將offset 移到下ㄧ個 rs 元素
 			while(rs.next()) {

 				Article article = new Article();
 				Calendar calendar = Calendar.getInstance();
				article.setArticle_id(rs.getNString("ARTICLE_ID"));
				article.setMember_id(rs.getNString("MEMBER_ID"));
				article.setTitle(rs.getNString("TITLE"));
				article.setContents(rs.getNString("CONTENTS"));
				article.setViews(rs.getInt("VIEWS"));
				article.setLikes(rs.getInt("LIKES"));
				calendar.setTime(rs.getDate("POST_DATE"));
				article.setDatetime(calendar);
				result.add(article);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Article article) {
		String sql = "INSERT INTO ARTICLE VALUES("
				+ "?, ?, ?, ?, "
				+ "?, ?, ?)";
		int n_success_update = -1;
		List<Article> result = new ArrayList<Article>();
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, article.getArticle_id());
			pstmt.setString(2, article.getMember_id());
			pstmt.setString(3, article.getTitle());
			pstmt.setString(4, article.getContents());
			pstmt.setInt(5, article.getViews());
			pstmt.setInt(6, article.getLikes());
//			pstmt.setString(7, buildDateString(article.getDatetime()));
			pstmt.setTimestamp(7, new Timestamp(0L), article.getDatetime());
			n_success_update = pstmt.executeUpdate();
 			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n_success_update;
		
	}

	@Override
	public int create(Article object, String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
