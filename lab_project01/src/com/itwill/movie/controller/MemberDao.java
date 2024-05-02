package com.itwill.movie.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import oracle.jdbc.OracleDriver;
import static com.itwill.movie.OracleJdbc.*;
import static com.itwill.movie.model.Member.Entity.*;

public class MemberDao {
	//싱글턴
	private static MemberDao instance = null;
	
	private MemberDao () {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}
	
	//id 중복확인
	public static final String SQL_MULTIPLE_ID = String.format("select %s from %s where LOWER(%s) = ?", COL_MEMBER_NO, TBL_MEMBERS, COL_MEMBER_ID);
	
	public String isThereSameId(String id) {
		String result = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_MULTIPLE_ID);
			stmt.setString(1, id.toLowerCase());
			rs = stmt.executeQuery();
			while (rs.next()) {
				result = rs.getString(COL_MEMBER_NO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return result;
	}
	
	// 회원 정보를 members table에 insert
	public static final String SQL_INSERT_INFO = String.format("insert into %s (%s, %s, %s, %s, %s) values (?, ?, ?, ?, ?)",
			TBL_MEMBERS, COL_MEMBER_NAME, COL_MEMBER_ID, COL_MEMBER_PW, COL_MEMBER_BIRTH, COL_MEMBER_PHONE);
	
	
	public int createNewAccount(String name, String id, String password, String birthdate, String phone) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		try {
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_INSERT_INFO);
			stmt.setString(1, name);
			stmt.setString(2, id);
			stmt.setString(3, password);
			stmt.setString(4, birthdate);
			stmt.setString(5, phone);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}
	
	
	//id, 비번 모두 일치하는 계정이 있는 지 확인 
	public static final String SQL_LOGIN = String.format("select %s from %s where LOWER(%s) = ? and %s = ?",
			COL_MEMBER_NO, TBL_MEMBERS, COL_MEMBER_ID, COL_MEMBER_PW);
	
	public int findAccount(String id, String pw) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int memno = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_LOGIN);
			stmt.setString(1, id.toLowerCase());
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			while (rs.next()) {
				memno = rs.getInt(COL_MEMBER_NO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return memno;
	}
	
	//memberno를 받았을 때 member name을 리턴하는 메서드
	public static final String SQL_MEMBER_ID = String.format("select %s from %s where %s = ?",
			COL_MEMBER_NAME, TBL_MEMBERS, COL_MEMBER_NO);
	
	public String findName(int memberNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String memberName = "";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_MEMBER_ID);
			stmt.setInt(1, memberNo);
			rs = stmt.executeQuery();
			while (rs.next()) {
				memberName = rs.getString(COL_MEMBER_NAME);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return memberName;
	}
	
	
	
	
	
}
