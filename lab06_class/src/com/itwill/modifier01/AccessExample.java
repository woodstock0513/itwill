package com.itwill.modifier01;

public class AccessExample {
	//field
	
	private int a;
	int b; //같은패키지안에서 접근가능
	protected int c;
	public int d;//같은 프로젝트 안에서
	
	public AccessExample (int a, int b, int c , int d) {
		this.a = a;
		this.b=b;
		this.c=c;
		this.d=d;
	}
	
	//method
	public void info() { // 이케 하면 a 값 다른 클래스에서 확인 가능. public이라
		System.out.printf("a=%d, b=%d, c=%d, d=%d\n",a,b,c,d);
	}
}
