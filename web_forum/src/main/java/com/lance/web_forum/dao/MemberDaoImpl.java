package com.lance.web_forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lance.web_forum.bean.Member;
import com.lance.web_forum.connection.DBConnectionFactory;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> queryAll() {
		String sql = "SELECT * FROM MEMBERS";
		List<Member> result = new ArrayList<Member>();
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery(sql);
 			while(rs.next()) {

 				Member member = new Member();
				member.setId(rs.getNString("MEMBER_ID"));
				member.setName(rs.getNString("MEMBERS_NAME"));
				member.setPwd(rs.getNString("MEMBERS_PASSWORD"));
				result.add(member);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Member> queryWith(String attribute, String value) {
		String sql = "SELECT * FROM MEMBERS WHERE ? = ?";
		List<Member> result = new ArrayList<Member>();
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, attribute);
			stmt.setString(2, value);
			ResultSet rs = stmt.executeQuery(sql);
 			while(rs.next()) {

 				Member member = new Member();
				member.setId(rs.getNString("MEMBER_ID"));
				member.setName(rs.getNString("MEMBERS_NAME"));
				member.setPwd(rs.getNString("MEMBERS_PASSWORD"));
				result.add(member);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public int changeUserName(String memberId, String new_name) {
		MemberDaoImpl dao = new MemberDaoImpl();
		Member member = dao.queryWith("MEMBER_ID", memberId).get(0);
		member.setName(new_name);
		return update(member);
	}

	@Override
	public int changePwd(String memberId, String new_pwd) {
		MemberDaoImpl dao = new MemberDaoImpl();
		Member member = dao.queryWith("MEMBER_ID", memberId).get(0);
		member.setPwd(new_pwd);
		return update(member);
	}
	
	
	@Override
	public int update(Member member) {
		int success_count;
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){

			conn.setAutoCommit(false);

			String updateSQL = "UPDATE MEMBERS SET "
					+ "  MEMBERS_NAME = ?"
					+ ", MEMBERS_PASSWORD = ? "
					+ "WHERE MEMBER_ID = ?";
			try (PreparedStatement stmt = conn.prepareStatement(updateSQL)){
				stmt.setString(1, member.getName());
				stmt.setString(2, member.getPwd());
				stmt.setString(2, member.getId());
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
	public int create(Member member) {
		String sql = "INSERT INTO MEMBERS VALUES("
				+ "?, ?, ?)";
		int success_count = -1;
		try	(Connection connection = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPwd());
			success_count = pstmt.executeUpdate();
 			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success_count;
	}

	@Override
	public int deleteAccount(String memberId) {
		Member member = new Member();
		member.setId(memberId);
		return delete(member);
	}
	
	@Override
	public int delete(Member member) {
		// Step1:取得Connection
		int success_count = -1;
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){
			// 設置交易不自動提交
			conn.setAutoCommit(false);
			// DELETE SQL
			String deleteSql = "DELETE FROM MEMBERS WHERE Id = ?";			
			// Step2:Create prepareStatement For SQL			
			try (PreparedStatement stmt = conn.prepareStatement(deleteSql)){
				// Step3:將"資料欄位編號"、"資料值"作為引數傳入
				stmt.setString(1, member.getId());
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
