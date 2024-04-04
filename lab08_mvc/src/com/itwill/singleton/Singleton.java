package com.itwill.singleton;

public enum Singleton {
	INSTANCE;  //public static final Singleton INSTANCE = new Singleton
	
	private String name;
	// enum 타입의 생성자는 private만 가능, 수식어는 생략가능.
	Singleton (){ //private
		this.name = "spiderman";
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
