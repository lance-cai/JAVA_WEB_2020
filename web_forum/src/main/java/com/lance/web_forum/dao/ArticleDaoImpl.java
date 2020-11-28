package com.lance.web_forum.dao;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.lance.web_forum.connection.*;
import com.lance.web_forum.bean.*;

public class ArticleDaoImpl implements ArticleDao {
	private static String pattern = "yyyy-MM-dd hh:mm:ss";
	
	public static String buildDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	} 
	
	@Override
	public List<Comment> getAllCommentsOn(String articleId) {
		String sql = "SELECT C.* FROM ARTICLE A "
				+ "INNER JOIN COMMENTS C "
				+ "ON A.ARTICLE_ID = C.ARTICLE_ID "
				+ "WHERE A.ARTICLE_ID = ?";
		List<Comment> result = new ArrayList<Comment>();
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, articleId);
			ResultSet rs = stmt.executeQuery(sql);
 			while(rs.next()) {
 				Comment comment = new Comment();
 				Calendar calendar = Calendar.getInstance();
				comment.setId(rs.getNString("COMMENT_ID"));
				comment.setArticleId(rs.getNString("ARTICLE_ID"));
				comment.setMemberId(rs.getNString("MEMBER_ID"));
				comment.setContents(rs.getNString("CONTENTS"));
				comment.setLikes(rs.getInt("LIKES"));
				calendar.setTime(rs.getDate("POST_DATE"));
				comment.setDate(calendar);
				result.add(comment);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Member getAuthorOf(String articleId) {
		Member member = new Member();
		String sql = "SELECT M.* FROM ARTICLE A "
				+ "INNER JOIN MEMBERS M "
				+ "ON A.MEMBER_ID = M.MEMBER_ID "
				+ "WHERE A.ARTICLE_ID = ?";	
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, articleId);
			ResultSet rs = stmt.executeQuery(sql);
 			rs.next();
			member.setId(rs.getNString("MEMBER_ID"));
			member.setName(rs.getNString("MEMBERS_NAME"));
			member.setPwd(rs.getNString("MEMBERS_PASSWORD"));
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	@Override
	public List<Article> queryAll() {
		String sql = "SELECT * FROM ARTICLE";
		List<Article> result = new ArrayList<Article>();
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery(sql);
 			while(rs.next()) {

 				Article article = new Article();
 				Calendar calendar = Calendar.getInstance();
				article.setId(rs.getNString("ARTICLE_ID"));
				article.setMemberId(rs.getNString("MEMBER_ID"));
				article.setTitle(rs.getNString("TITLE"));
				article.setContents(rs.getNString("CONTENTS"));
				article.setViews(rs.getInt("VIEWS"));
				article.setLikes(rs.getInt("LIKES"));
				calendar.setTime(rs.getDate("POST_DATE"));
				article.setDate(calendar);
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
				article.setId(rs.getNString("ARTICLE_ID"));
				article.setMemberId(rs.getNString("MEMBER_ID"));
				article.setTitle(rs.getNString("TITLE"));
				article.setContents(rs.getNString("CONTENTS"));
				article.setViews(rs.getInt("VIEWS"));
				article.setLikes(rs.getInt("LIKES"));
				calendar.setTime(rs.getDate("POST_DATE"));
				article.setDate(calendar);
				result.add(article);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int editContents(String articleId, String editedContents) {
		ArticleDao dao = new ArticleDaoImpl();
		Article article = dao.queryWith("ARTICLE_ID", articleId).get(0);
		article.setContents(editedContents);
		return dao.update(article);
	}
	
	@Override
	public int refreshLikesAndVisits(String articleId, int likes, int views) {
		ArticleDao dao = new ArticleDaoImpl();
		Article article = dao.queryWith("ARTICLE_ID", articleId).get(0);
		article.setLikes(likes);
		article.setViews(views);
		return dao.update(article);
	}
	
	@Override
	public int update(Article article) {
		int success_count;
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){
			conn.setAutoCommit(false);
			String updateSQL = "UPDATE ARTICLE SET"
					+ " MEMBER_ID = ?"
					+ ", TITLE = ?"
					+ ", CONTENTS = ?"
					+ ", VIEWS = ?"
					+ ", LIKES = ?"
					+ ", POST_DATE = ?"
					+ " WHERE ARTICLE_ID = ?";
			try (PreparedStatement stmt = conn.prepareStatement(updateSQL)){
				stmt.setString(1, article.getMemberId());
				stmt.setString(2, article.getTitle());
				stmt.setString(3, article.getContents());
				stmt.setInt(4, article.getViews());
				stmt.setInt(5, article.getLikes());
				stmt.setTimestamp(6, new Timestamp(0L), article.getDate());
				stmt.setString(7, article.getId());
				success_count = stmt.executeUpdate();
				
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}			
		} catch (SQLException e) {
			success_count = -1;
			e.printStackTrace();
		}
		
		return success_count;
		
	}

	@Override
	public int create(Article article) {
		String sql = "INSERT INTO article (ARTICLE_ID, MEMBER_ID, TITLE, CONTENTS) "
				+ "VALUES(SEQ_ARTICLE.nextval, ?, ?, ?);";
		int success_count = -1;
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, article.getMemberId());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getContents());
//			pstmt.setString(7, buildDateString(article.getDate()));
//			pstmt.setTimestamp(7, new Timestamp(0L), article.getDate());
			success_count = pstmt.executeUpdate();
 			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success_count;
	}

	@Override
	public int delete(Article article) {
		// Step1:取得Connection
		int success_count = -1;
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){
			// 設置交易不自動提交
			conn.setAutoCommit(false);
			// DELETE SQL
			String deleteSql = "DELETE FROM ARTICLE WHERE Id = ?";			
			// Step2:Create prepareStatement For SQL			
			try (PreparedStatement stmt = conn.prepareStatement(deleteSql)){
				// Step3:將"資料欄位編號"、"資料值"作為引數傳入
				stmt.setString(1, article.getId());
				// Step4:Execute SQL
				success_count = stmt.executeUpdate();
				// Step5:交易提交
				conn.commit();
			} catch (SQLException e) {
				// 若發生錯誤則資料 rollback(回滾)
				conn.rollback();
				throw e;
			}
		} catch (SQLException e) {
			success_count = -1;
			e.printStackTrace();
		}
		return success_count;
	}
	

}
