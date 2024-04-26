package com.itwill.jdbc01;

/*
jdbc (java data connectivity)
자바 프로그램에서 데이터 베이스를 연결하고 , SQL 문장들을 실행해서 그 결과를 처리

1. 오라클 JDBC 라이브러리를 다운로드하고 이클립스 프로젝트의 빌드패스에 추가
 (1) https://central.sonatype.com/ (메이븐 중앙 저장소)에 들어가서 OJDBC 11 검색.
   -> com.oracle.database.jdbc/ojdbc11@23.3.0.23.09 (버전은 달라질 수 있음)
   그룹 아이디 아티팩트 아이디 등등 정보가 잇듬.
   -> ojdbc11-23.3.0.23.09 .jar 다운로드.
   
 (2) 이클립스 프로젝트에 lib 폴더를 만들고, jar 파일 복사
 (3) jar 파일 우클릭 -> build path -> Add to build path

2. 데이터베이스에 접속하기 위한 정보(URL, USER, PASSWORD, ... ) (저 세개는 필수.) 들을 상수로 정의한다.

3. 프로그램에서 오라클 JDBC 라이브러리를 메모리에 로딩(등록). (코드 한 줄 컷)

4. 오라클 데이터베이스에 접속. (코드 한 줄 컷)

5. statement 타입의 객체 생성 - DB에서 실행할 SQL 문장을 작성하고 실행할 수 있는 객체

6. Statement 타입 인스턴스에서 메서드를 호출해서 SQL 문장을 실행
  (1) executeQuery() : DQL(select 문장)을 호출
  (2) executeUpdate() : DML(insert, update, delete) 을 호출

7. 메서드 실행 결과(리턴값)을 처리

8. 사용했었던 모든 리소스들을 해제 (close 메서드 호출)

 */


import static com.itwill.jdbc.OracleJdbc.*;
import static com.itwill.jdbc.model.Blog.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver;

public class JdbcMain01 {

	public static void main(String[] args) throws SQLException {
		// select 문장 실행, 결과 출력

		// 3. 오라클 JDBC 라이브러리를 사용할 수 있도록 등록.
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("oracle 드라이버 등록 성공");
		
		// 4. 오라클 데이터베이스에 저장(오라클 세션 생성)
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); 
		System.out.println("오라클 접속 성공");
		
		
		// 5. statement 타입 개체 생성
		final String sql = "select * from blogs order by id desc"; //최신 글이 먼저 보이게
		// statement 객체에서 사용하는 sql 문장은 세미콜론을 사용하지 않음!!!
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		// 6-7. sql 문장 실행 & 결과 처리
		ResultSet rs = stmt.executeQuery(); //실행하겟다! 쿼리로! select 문장이면 쿼리로 실행!!
		while (rs.next()) { //행이 있으면 T, 없으면 F. 다음행이 있는지 확인 
			//ResultSet(테이블)에서 행(row)이 있는지 검사. -> 그 행의 컬럼들에 있는 값을 읽음.
			int id = rs.getInt(COL_ID); //id 컬럼의 값을 읽음
			String title = rs.getString(COL_TITLE);  //테이블의 타이틀 컬럼 값을 읽음
			String content = rs.getString(COL_CONTENT);
			String writer = rs.getString(COL_WRITER);
			LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
			LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();
			Blog blog = new Blog(id, title, content, writer, createdTime, modifiedTime);
			System.out.println(blog);
		}
		
		// 8. 오라클 db관련 리소스 해제. (connection statement resultset)
		// 리소스를 해제할 때는 리소스가 생성된 순거의 반대로!
		rs.close();
		stmt.close();	
		conn.close(); //오라클 접속 끊기
		System.out.println("오라클 접속 해제");
		
	}

}
