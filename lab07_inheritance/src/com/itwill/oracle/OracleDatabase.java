package com.itwill.oracle;

import com.itwill.database.Database;

public class OracleDatabase implements Database {
//	public static final int VERSION = 1;
	
	public int select() {
		System.out.println("Oracle select");
		return 4;
	}
	//둘 중 하나라도 없으면 에러남.
	//둘다 Database의 추상 메서드를 override 한 것
	
	public int insert() {
		System.out.println("Oracle insert");
		return 1;
	}

}
