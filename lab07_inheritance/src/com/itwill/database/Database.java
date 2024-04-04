package com.itwill.database;

public interface Database {
	//field
	
	int DB_VERSION = 1; //public static final 생략
	
	/**
	 * 데이터베이스의 테이블에서 자료를 검색하고 정수 리턴
	 * @return 검색된 자료 개수
	 */
	int select(); //추상 메서드.  public abstract 생략
//class의 경우 생략하면 패키지 범위.
	
	/**
	 * 데이터 베이스의 테이블에 자료를 추가하고 성공이면 1, 실패이면 0 리턴
	 * @return  성공이면 1, 실패이면 0
	 */
	int insert();
}
