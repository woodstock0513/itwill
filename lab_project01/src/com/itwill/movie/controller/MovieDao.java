package com.itwill.movie.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.movie.model.Movie;

import oracle.jdbc.OracleDriver;

//import static com.itwill.movie.MysqlJdbc.*;
import static com.itwill.movie.OracleJdbc.*;
import static com.itwill.movie.model.Movie.Entity.*;

public class MovieDao {
	//싱클턴
	private static MovieDao instance = null;
	
	private MovieDao() {
		try {
			DriverManager.registerDriver(new OracleDriver());
//			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
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
		String mname = rs.getString(COL_MOVIE_NAME);
		LocalDateTime mdate = rs.getTimestamp(COL_MOVIE_DATE).toLocalDateTime();
		
		Movie movie = new Movie(mname, mdate);
		return movie;
		
		
	}
	
	private Movie makeMovieInfoFromResultSet(ResultSet rs) throws SQLException {
		String movinfo = rs.getString(COL_MOVIE_INFO);
		
		Movie movie = new Movie(movinfo);
		return movie;
		
	}
	
	private Movie makeReservationFromResultSet(ResultSet rs) throws SQLException {
		int seatNo = rs.getInt(COL_SEAT_NO);
		String mname = rs.getString(COL_MOVIE_NAME);
		LocalDateTime mdate = rs.getTimestamp(COL_MOVIE_DATE).toLocalDateTime();
		LocalDateTime reservtime = rs.getTimestamp(COL_RESERVATION_TIME).toLocalDateTime();
		int reservationNo = rs.getInt(COL_RESERVATION_NO);
		Movie movie = new Movie(mname, reservtime, seatNo, mdate, reservationNo);
		return movie;
	}
	
	
	//전체 상영시간을 READ하는 메서드 만들기
	private static final String SQL_SELECT = String.format("select %s, %s from %s order by %s",COL_MOVIE_NAME, COL_MOVIE_DATE, TBL_TIMES, COL_MOVIE_DATE);
	
	
	public List<Movie> readAllTimes(){
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
			TBL_TIMES,COL_MOVIE_NAME,TBL_TIMES, COL_MOVIE_DATE,TBL_TIMES, TBL_MOVIES,
			TBL_TIMES,COL_MOVIE_NAME,TBL_MOVIES,COL_MOVIE_NAME, TBL_MOVIES, COL_MOVIE_NO,COL_MOVIE_DATE );
	
//	public static final String SQL_SELECT_ONE = String.format("select %s, %s from %s where %s = ? order by %s", 
//			COL_MOVIE_NAME, COL_MOVIE_DATE, TBL_TIMES, COL_MOVIE_NO, COL_MOVIE_DATE);
	
	
	public List<Movie> readOneTime(int index){
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
	public static final String SQL_INFO = String.format("select %s from %s where %s = ?", COL_MOVIE_INFO, TBL_MOVIES, COL_MOVIE_NO);
	
	public String readOneInfo(int movie_no) {
		String info = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_INFO);
			stmt.setInt(1, movie_no+1);
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
			COL_MOVIE_NAME, COL_MOVIE_DATE, TBL_TIMES, COL_TIME_NO );
	
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
	public static final String SQL_FIND_TIME_NO = String.format("select %s from %s where %s = ? and %s = ?",
			COL_TIME_NO, TBL_TIMES, COL_MOVIE_NAME, COL_MOVIE_DATE);
	
	
	public int findTimeNo(String mname, LocalDateTime mdate) {
		int tnum = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_FIND_TIME_NO);
			stmt.setString(1, mname);
			stmt.setTimestamp(2, Timestamp.valueOf(mdate));
			rs = stmt.executeQuery();
			while(rs.next()) {
				tnum = rs.getInt(COL_TIME_NO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return tnum;
		
	}
	
	
	
	//tnum으로 좌석 상태 확인 tnum이 아니라 key로 찾아야지 등신아 - seatId
	public static final String SQL_FIND_STATE = String.format("select %s from %s where %s = ?", COL_STATE, TBL_SEAT, COL_SEAT_ID);
	
	public String findState(int seatId) {
		String state = "unknown";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_FIND_STATE);
			stmt.setInt(1, seatId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				state = rs.getString(COL_STATE); //while 안에 넣어야할..걸?
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return state;
		
	}
	
	// key를 받아서 예약 확정
	public static final String SQL_UPDATE_STATE = String.format("update %s set %s = ?  where %s = ?",TBL_SEAT, COL_STATE, COL_SEAT_ID);
	
	public int updateStateToOff(int seatId) {
		int result=0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_UPDATE_STATE);
			stmt.setString(1, "OFF");
			stmt.setInt(2, seatId);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;
	}
	
	// key를 받아서 예약 취소
	public int updateStateToOn(int seatId) {
		int result=0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_UPDATE_STATE);
			stmt.setString(1, "ON");
			stmt.setInt(2, seatId);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;
	}
	
	//memno와 timenum, seatno을 이용해서 예약 테이블에 insert
	public static final String SQL_INSERT_RESERVATION = String.format("insert into %s (%s, %s, %s, %s) select ?, %s, %s, ? from %s where %s = ?",
			TBL_RESERVATIONS, COL_MEMBER_NO, COL_MOVIE_NAME, COL_MOVIE_DATE, COL_SEAT_NO, COL_MOVIE_NAME, COL_MOVIE_DATE, TBL_TIMES, COL_TIME_NO );
	
	//insert into reservations (memno,mname,mdate,seatno) select ?, mname, mdate, ? from times where timenum = ?
	public int reservation(int memno, int timenum, int seatno) {
		int result=0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_INSERT_RESERVATION);
			stmt.setInt(1, memno);
			stmt.setInt(2, seatno);
			stmt.setInt(3, timenum);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;
	}
	
	// MEMNO을 입력해서 MNAME, MDATE, SEATNO, RESERVTIME을 반환하는 메서드 +reservmo까지 그냥 받아
	public static final String SQL_MY_RESERVATION = String.format("select %s, %s, %s, %s, %s from %s where %s = ?",
			COL_MOVIE_NAME,COL_MOVIE_DATE,COL_SEAT_NO,COL_RESERVATION_TIME,COL_RESERVATION_NO,TBL_RESERVATIONS,COL_MEMBER_NO);
	
	public List<Movie> findMyReservations(int memno) {
		List<Movie> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_MY_RESERVATION);
			stmt.setInt(1, memno);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = makeReservationFromResultSet(rs);
				result.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return result;
		
	}
	
	//index를 입력해서 그 예약을 지우는 메서드
	//delete from res where resno = ?
	//근데 또 resno를 먼저.. 찾아야하는디.. 어케찾지
	// -> 위의 findMyReseration에서 reservno도 받자
	// resno를 입력해서 그 예약을 지우는 메서드!!!가 됨
	public static final String SQL_DELETE_RESERVATION = String.format("delete from %s where %s = ?",
			TBL_RESERVATIONS, COL_RESERVATION_NO);
	
	public int deleteReservation(int reservationNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELETE_RESERVATION);
			stmt.setInt(1, reservationNo);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}


}
