package com.itwill.class04;

public class Rectangle { //넓이, 둘레 구하는 기능!
	// field
	double width; // 직ㄱ사각형의 가로 길이를 저장하는 필드
	double height; //직사각형의 새로 길이
	
	
	// 생성자
	// (1) 기본 생성자
	public Rectangle () {} // 필드 기본값으로 초기화 
	
	// (2) 가로, 세로 길이를 아규먼트로 전달받아서 초기화하는 생성자
	public Rectangle (double width , double height ) {
		this.width = width; //갈색 윋스 하잇 - 지역변수. 파라미터
		this.height = height; // 필드에 저장하겠다. this 필수. 구분해야함.
	}
	
	// 메서드
	// (1) 넓이를 리턴
	public double square () { //직사각형 만들고 나서 작동하는 메서드. 가로세로가 초기화 되어있을것.
//-> 파라미터 필요하지 않음!! 인스턴스(객체)가 가지고 있는 값 사용
		return width * height; //this 생략 가능. 파라미터 없으니까 헷갈릴 이유 X
//		return this.height * this.width; 로도 표현 가능. this! - 인스턴스의~
	}
	
//	 (2) 둘레 길이를 리턴
	public double round () {
		return 2.0 * (width + height); // 곱하기 2 해도 상관X 
	}

}
