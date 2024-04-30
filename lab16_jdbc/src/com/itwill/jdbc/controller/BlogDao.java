package com.itwill.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;
import static com.itwill.jdbc.model.Blog.Entity.*;

//MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO (Data Access Object)
// CRUD (Create, Read, Update, Delete) 기능 담당. SQL로 치면 insert select update delete

public class BlogDao {
	
	// -->  singletone
	private static BlogDao instance = null;
	
	private BlogDao() {
		try {
			//Oracle Driver(라이브러리) 등록. (1번만 하면 됨)
			//-> 그래서 생성자 안에 넣음. 생성자도 한 번만 실행되니까.
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static BlogDao getInstance() {
		if (instance == null) {
			instance = new BlogDao();
		}
		return instance;
	}
	
	// <-- singleton
	/**
	 * CRUD 메서드에서 사용했던 리소스들을 해제
	 * select 사용 시 
	 * @param conn DB접속을 담당하는 Connection 객체
	 * @param stmt Statement 객체
	 * @param rs ResultSet 객체 (select에서만 있음)
	 */
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * CRUD 메서드에서 사용했던 리소스들을 해제
	 * select 제외 다른 명령문들에서 사용
	 * @param conn DB접속을 담당하는 Connection 객체
	 * @param stmt Statement 객체
	 */
	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}
	
	//resultset에서 각 컬럼의 값들을 읽어서 blog 타입 객체를 생성하고 리턴.
	private Blog makeBlogFromResultSet(ResultSet rs) throws SQLException { //read가 이미 try문 사용 중이라 던져도 됨
		int id = rs.getInt(COL_ID);
		String title = rs.getString(COL_TITLE);
		String content = rs.getString(COL_CONTENT);
		String writer = rs.getString(COL_WRITER);
		LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
		LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();

		Blog blog = new Blog(id, title, content, writer, createdTime, modifiedTime);
		return blog;

	}
	
	
	//read() 메서드에서 사용할 SQL 문장 : select * from blogs order by id desc
	private static final String SQL_SEL_ALL = String.format("select * from %s order by %s desc", TBL_BLOGS, COL_ID);
	
	/**
	 * 데이터 베이스 테이블 BLOGS 테이블에서 모든 레코드(행)을 검색해서
	 * ID(고유키)의 내림차순으로 정렬된 리스트를 반환
	 * 테이블에 행이 없는 겨우 빈 리스트를 리턴
	 * @return Blog를 원소로 갖는 ArrayList
	 */
	public List<Blog> read(){
		List<Blog> result = new ArrayList<>();
		Connection conn  = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			//DB 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 실행할 sql 문장을 갖고 있는 preparedstatement 객체를 생성
			stmt = conn.prepareStatement(SQL_SEL_ALL);
			// SQL 문장을 db에 전송해서 실행
			rs = stmt.executeQuery();
			// 결과 처리
			while (rs.next()) {
				Blog blog = makeBlogFromResultSet(rs);
				result.add(blog);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return result;
	}
	// create(Blog blog) 메서드에서 사용할 SQL
	// created time은 디폴트 값 넣어줘서 ㄱㅊ
	// insert into blogs (title, content, writer) values (?, ?, ?)
	private static final String SQL_INSERT = String.format("insert into %s (%s, %s, %s) values(?, ?, ?)", TBL_BLOGS, COL_TITLE,COL_CONTENT,COL_WRITER);
	
	/**
	 * 데이터베이스의 blogs 테이블에 행을 삽입
	 * @param blog 테이블에 삽일할 제목, 내용, 작성자 정보를 가지고 있는 객체
	 * @return 테이블에 삽입된 행의 개수
	 */
	public int create(Blog blog) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD); //db접속
			stmt = conn.prepareStatement(SQL_INSERT);//statement 객체 생성
			stmt.setString(1,blog.getTitle());
			stmt.setString(2,blog.getContent());
			stmt.setString(3,blog.getWriter());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}
	
	//delete에서 사용할 sql : delete from blogs where id = ?
	private static final String SQL_DELETE = String.format("delete from %s where %s = ?", TBL_BLOGS, COL_ID);
	/**
	 * 테이블 blogs에서 고유키에 해당하는 레코드 삭제
	 * @param id 삭제하려는 테이블의 고유키
	 * @return 테이블에서 삭제된 행의 개수
	 */
	public int deleteBlog(int id) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}
	
	// 제목에 검색 키워드가 포함된 검색 결과
	//select * from blogs where lower(title) like ? order by id desc;
	private static final String SQL_SELECT_BY_TITLE = String.format(
		"select * from %s where lower(%s) like ? order by %s desc", TBL_BLOGS, COL_TITLE, COL_ID);
	
	// 내용에 검색 키워드가 포함된 검색 결과
	//select * from blogs where lower(content) like ? order by id desc;
	private static final String SQL_SELECT_BY_CONTENT = String.format(
		"select * from %s where lower(%s) like ? order by %s desc", TBL_BLOGS, COL_CONTENT, COL_ID);
	
	// 제목 또는 내용에 검색 키워드가 포함된 검색 결과 -> where 절 내용이 두개
	//select * from blogs where lower(title) like ? or lower(content) like ? order by id desc;
	private static final String SQL_SELECT_BY_TITLE_OR_CONTENT = String.format(
		"select * from %s where lower(%s) like ? or lower(%s) like ? order by %s desc",
		TBL_BLOGS, COL_TITLE,COL_CONTENT, COL_ID);
	
	// 작성자에 검색 키워드가 포함된 검색 결과 : 
	//select * from blogs where lower(title) like ? order by id desc;
	private static final String SQL_SELECT_BY_WRITER = String.format(
		"select * from %s where lower(%s) like ? order by %s desc", TBL_BLOGS, COL_WRITER, COL_ID);
	/**
	 * 	제목, 내용, 제목 또는 내용, 작성자로 검색하기.
	 * 검색 타입과 검색어를 전달받아서, 해당하는 SQL 문장을 실행하고 그 결과를 리턴.
	 * @param type 0 - 제목 검색. 1 - 내용 검색. 2 - 제목 또는 내용 검색. 3 - 작성자 검색
	 * @param keyword 검색 문자열
	 * @return 검색 결과 리스트. 결과가 없으면 빈 리스트 리턴.
	 */
	public List<Blog> search(int type, String keyword){
		List<Blog> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//like 검색 시 % 주의!!!!
		String searchKeyword = "%"+keyword.toLowerCase()+"%"; //like하려면 앞뒤로 % 쓰니가. 포함! 쓰려면.
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			switch (type) {
			case 0:
				stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
				stmt.setString(1, searchKeyword);
				break;
			case 1:
				stmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
				stmt.setString(1, searchKeyword);
				break;
			case 2:
				stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
				stmt.setString(1, searchKeyword);
				stmt.setString(2, searchKeyword);
				break;
			case 3:
				stmt = conn.prepareStatement(SQL_SELECT_BY_WRITER);
				stmt.setString(1, searchKeyword);
				break;
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				Blog blog = makeBlogFromResultSet(rs);
				result.add(blog);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
	
		return result;
	}
	
	
	
	
	

}
