package com.itwill.movie.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.movie.model.Movie;

import oracle.jdbc.OracleDriver;

import static com.itwill.movie.OracleJdbc.*;
import static com.itwill.movie.model.Movie.Entity.*;

public class MovieDao {
	//싱클턴
	private static MovieDao instance = null;
	
	private MovieDao() {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static MovieDao getInstance() {
		if (instance == null) {
			instance = new MovieDao();
		}
		return instance;
	}
	
	//싱클턴
	
	
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
	
	private Movie makeMovieFromResultSet(ResultSet rs) throws SQLException {
		String mname = rs.getString(COL_MNAME);
		LocalDateTime mdate = rs.getTimestamp(COL_MDATE).toLocalDateTime();
		
		Movie movie = new Movie(mname, mdate);
		return movie;
		
		
	}
	
	private Movie makeMovieInfoFromResultSet(ResultSet rs) throws SQLException {
		String movinfo = rs.getString(COL_MOVINFO);
		
		Movie movie = new Movie(movinfo);
		return movie;
		
		
	}
	
	
	//전체 상영시간을 READ하는 메서드 만들기
	private static final String SQL_SELECT = String.format("select %s, %s from %s order by %s",COL_MNAME, COL_MDATE, TBL_TIMES, COL_MDATE);
	
	
	public List<Movie> read(){
		List<Movie> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = makeMovieFromResultSet(rs);
				result.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return result;
		
	}
	
	//영화 하나의 모든시간을 읽는 메서드
	public static final String SQL_SELECT_ONE = String.format("select %s.%s, %s.%s from %s, %s "//공백주의
			+ "where %s.%s = %s.%s and %s.%s = ? order by %s",
			TBL_TIMES,COL_MNAME,TBL_TIMES, COL_MDATE,TBL_TIMES, TBL_MOVIES,
			TBL_TIMES,COL_MNAME,TBL_MOVIES,COL_MNAME, TBL_MOVIES, COL_MOVNO,COL_MDATE );
	
	
	public List<Movie> readOne(int index){
		
		List<Movie> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_ONE);
			stmt.setInt(1, index+1);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = makeMovieFromResultSet(rs);
				result.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return result;
		
	}
	
	//영화 하나의 기본 정보를 읽는 메서드
	public static final String SQL_INFO = String.format("select %s from %s where %s = ?", COL_MOVINFO, TBL_MOVIES, COL_MOVNO);
	
	public String readOneInfo(int index) {
		String info = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_INFO);
			stmt.setInt(1, index+1);
			rs = stmt.executeQuery();
			while (rs.next()) {
			Movie movie = makeMovieInfoFromResultSet(rs);
			info = movie.getMovinfo(); // movie를 위로 올리고 얠 while 밖으로 빼도 되긴 할듯
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return info;
		
	}
	
	//선택된 시간의 영화 이름과 시간 읽기
	public static final String SQL_CHOOSE = String.format("select %s, %s from %s where %s = ?",
			COL_MNAME, COL_MDATE, TBL_TIMES, COL_TNUM );
	
	public Movie readOneNameAndDate(int index) {
		Movie movie = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_CHOOSE);
			stmt.setInt(1, index);
			rs = stmt.executeQuery();
			while (rs.next()) {
				movie = makeMovieFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return movie;
	}
	
	//선택된 영화의 tnum 찾기
	public static final String SQL_FIND_TNUM = String.format("select %s from %s where %s = ? and %s = ?",
			COL_TNUM, TBL_TIMES, COL_MNAME, COL_MDATE);
	
	
	public int findTnum(String mname, LocalDateTime mdate) {
		int tnum = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_FIND_TNUM);
			stmt.setString(1, mname);
			stmt.setTimestamp(2, Timestamp.valueOf(mdate));
			rs = stmt.executeQuery();
			while(rs.next()) {
				tnum = rs.getInt("TIMENUM");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return tnum;
		
	}
	
	
	

}
