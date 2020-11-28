package com.lance.web_forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.lance.web_forum.bean.Comment;
import com.lance.web_forum.connection.DBConnectionFactory;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> queryAll() {
		String sql = "SELECT * FROM COMMENTS";
		List<Comment> result = new ArrayList<Comment>();
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
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
	public List<Comment> queryWith(String attribute, String value) {
		String sql = "SELECT * FROM COMMENTS WHERE ? = ?";
		List<Comment> result = new ArrayList<Comment>();
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, attribute);
			stmt.setString(2, value);
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
	public int editContents(String commentId, String editedContents) {
		CommentDaoImpl dao = new CommentDaoImpl();
		Comment comment = dao.queryWith("COMMENT_ID", commentId).get(0);
		comment.setContents(editedContents);
		return dao.update(comment);
	}	
	
	@Override
	public int update(Comment comment) {
		int success_count;
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){

			conn.setAutoCommit(false);

			String updateSQL = "UPDATE COMMENTS SET "
					+ "ARTICLE_ID = ?, MEMBER_ID = ?, CONTENTS = ?"
					+ ", LIKES = ?, POST_DATE = ?"
					+ "WHERE COMMENT_ID = ?";
			try (PreparedStatement stmt = conn.prepareStatement(updateSQL)){
				stmt.setString(1, comment.getArticleId());
				stmt.setString(2, comment.getMemberId());
				stmt.setString(3, comment.getContents());
				stmt.setInt(4, comment.getLikes());
				stmt.setTimestamp(5, new Timestamp(0L), comment.getDate());
				stmt.setString(6, comment.getId());
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
	public int create(Comment comment) {
		String sql = "INSERT INTO COMMENTS VALUES("
				+ "?, ?, ?, ?, ?, ?)";
		int success_count = -1;
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setString(1, comment.getId());
			pstmt.setString(2, comment.getArticleId());
			pstmt.setString(3, comment.getMemberId());
			pstmt.setString(4, comment.getContents());
			pstmt.setInt(5, comment.getLikes());
			pstmt.setTimestamp(6, new Timestamp(0L), comment.getDate());
			success_count = pstmt.executeUpdate();
 			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success_count;
	}

	@Override
	public int delete(Comment comment) {
		int success_count = -1;
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){
			conn.setAutoCommit(false);
			String deleteSql = "DELETE FROM COMMENTS WHERE Id = ?";			
			try (PreparedStatement stmt = conn.prepareStatement(deleteSql)){
				stmt.setString(1, comment.getId());
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

}
