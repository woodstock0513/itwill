package com.itwill.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*; //static 없으면 안됨!!!!!!

public class JdbcMain02 {

	public static void main(String[] args) {
		// insert 문장 실행 & 결과 처리
		// try catch 도 쓰기!
		
		Scanner scanner = new Scanner(System.in); // 콘솔 입력
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 오라클 드라이버(라이브러리) 등록 - 제일 먼저 할 일!!!
			DriverManager.registerDriver(new OracleDriver());
			
			// 오라클 db 접속 
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// statement 객체 생성
			final String sql = "insert into Blogs (title, content, writer) values (?,?,?)"; //?의 의미 : 실행할때마다 값이 바뀐다.
			stmt = conn.prepareStatement(sql);
			
			System.out.print("제목을 입력하세요. ");
			String title = scanner.nextLine();
			System.out.print("내용을 입력하세요. ");
			String content = scanner.nextLine();
			System.out.print("작성자를 입력하세요. ");
			String writer = scanner.nextLine();
			
			//Prepared Statement 객체의 SQL에서 ? 부분을 입력받은 내용으로 채워주기
			stmt.setString(1, title); // 첫번째 ?에 title 변수의 값을 문자열로 채움
			stmt.setString(2, content); // 두번째 ? 에 ..
			stmt.setString(3, writer); // 세번째 ?에 ...
			// 인덱스 1부터 시작인 것 주의!!!!
			
			//SQL 문장을 DB로 보내서 실행 & 결과 처리
			int result = stmt.executeUpdate(); //insert니까 쿼리가 아니라 업데이트!!!!
			
			System.out.println(result + "행이 삽입되었습니다.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제 - 파일이랑 비슷~
			try {
				stmt.close(); //얘네도 try-catch 로 묶어줘야함
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		

	}

}
