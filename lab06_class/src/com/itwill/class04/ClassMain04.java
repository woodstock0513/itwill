package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// 기본 생성자를 Rectangle 타입의 객체 생성, 메서드 호출.
		Rectangle rec1 = new Rectangle(); //rec 지역변수
		rec1.height = 15.2;
		rec1.width = 4.8;
		System.out.println(rec1);
		System.out.println("둘레 : "+rec1.round());
		System.out.println("넓이 : "+rec1.square());
		
		// 생성자를 Rectangle 타입의 객체 생성, 메서드 호출.
		
		Rectangle rec2 = new Rectangle(12.3,8.4);
		System.out.println(rec2); //참조타입의정수패키지, 클래스, @ , ~
// 16ㅈ;ㄴ스
		System.out.println("둘레 : "+ rec2.round());
		System.out.println("넓이 : "+ rec2.square());
		// @ = at 이랑 같은 의미
	}

}
