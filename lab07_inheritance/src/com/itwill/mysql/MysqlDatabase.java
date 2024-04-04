package com.itwill.mysql;

import com.itwill.database.Database;

public class MysqlDatabase implements Database{
	public static final int VERSION = 1;
	
	public int select() { // public 빼면 package 범위 됨 -> 인터페이스보다 범위 좁아짐. 따라서 안됨
		System.out.println("My SQL select");
		return 2;
	}
	//이것도 오버라이드.
	public int insert() {
		System.out.println("My SQL insert");
		return 0;
	}

}
