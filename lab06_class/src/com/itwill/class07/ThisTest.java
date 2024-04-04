package com.itwill.class07;

public class ThisTest {
	//field 
	int x;
	int y;
	int z;
	
	//constructor
	public ThisTest() {}
	
	public ThisTest (int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
//		-> this : ThisTest 타입으로 생성된 객체(인스턴스)
	}
	
	public ThisTest(int x) {
//		this.x = x;
//		y,z는 기본값 0 으로 초기화
		this (x,0,0); //-> this(...) : ThisTest class(같은 클래스)의 다른 생성자 호출 (이 경우는 위의 아규먼트 3개짜리 생성자.)
		//(주의) this(...) 생성자를 호출하는 코드는 다른 실행문들보다 먼저 실행되어야 함. 반드시!!!!!!!!!!!!!
		// 아규먼트 전달하는 느낌 메서드처럼.
	}
	
	public ThisTest (int x, int y) {
		this(); //x,y,z=0. 현재 클래스의 다른 생성자를 호출하는 문장 (이 경우는 기본 생성자)
		//이름(This Test) 이렇게 부르면 안굄. 
		this.x=x;
		this.y=y;
		
	}
	
	public void info() {
		System.out.printf("x=%d,y=%d,z=%d\n",x,y,z);
		
		
		
	}
	

}
