package com.itwill.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;

public class JdbcMain03 {

	public static void main(String[] args) throws SQLException {
		// update 문장을 실행하고 결과 처리 (간단하게 쓰로우 써서 하기)
		
		//오라클 드라이버 등록
		DriverManager.registerDriver(new OracleDriver()); // 데이터베이스에 접속하는 역할
		
		// 오라클 db에 접속
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //드라이버가 접속해서! 연결해줌
		// 이부분들은 나중에 다오로 만들면 됨! (계속 반복되니까)
		
		// statement 객체 생성
		final String sql = "update blogs " //blogs(테이블이름) 뒤에 공백이 꼭!!! 있어야함. 없으면 걍 개긴 테이블 이름됨
				+ "set title = ?, content = ?, modified_time = systimestamp where id = ?"; //mod 시간은 굳이 입력하지 않아도 됨
		// 상수 사용 가능. (blog 클래스에서 만든 거)
		// 기능에 따라 시간을 입력받는 경우도 있을 수 있음.
		PreparedStatement stmt = conn.prepareStatement(sql);
		//prepared는 완성된 문장일수도, 비어있어서 좀더 채워야하는 문장일수도 있음.
		
		// 실행하기 전 PreparedStatements에서 ?를 실제 값으로 대체!
		stmt.setString(1, "update test");
		stmt.setString(2, "집에 가고 싶어요");
		stmt.setInt(3, 4); // 3번째 물음표에 정수 1을 채운다
		
		//sql 문장 실행 & 결과 처리
		int result = stmt.executeUpdate();
		System.out.println(result + "행이 업데이트 되었습니다.");
		
		//리소스 해제
		stmt.close();
		conn.close();
	}

}
