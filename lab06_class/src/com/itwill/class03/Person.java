package com.itwill.class03; //main 없이 .

public class Person { ///person이라는 객체를 만드는 클래스
	//이름과 나이를 저장하고, 기능은 내 이름과 나이를 소개하는 메서드를 가진다
	
	// field
	String name;
	int age;
	
	// constructor 생성자
	// 아무것도 없어도 기본을 자도으로 만들어줌.
	//기본생성자만 있는 경우. 번거로움
	//기본ㄷ값 먼저 하고 그 다음에 초기화 하고 어쩌고
	//객체 생성하고 바로 초기화 하면 얼마나 편해!
	// 생성자 이름은 클래스 이름이랑 같음
	
	//기본 생성자
	public Person() {} //중괄호는 필수. 안에 코드는 없어도 되지마 ㄴ괄호는 반듯기 있어야함.
	
	//아규먼트ㅡ를 갖는 생성자
	public Person(String name , int age) {
		this.name = name;
		this.age = age;
	}

	
	
	//method 객체 생성 후 호출.
	public void introduce () { //자기가 가지고있는 필드 소개 - 파라미터 필요 XX
		System.out.println("안녕하세요 저는 "+name+"입니다.");
		System.out.println("제 나이는 "+age+"입니다.");
		//필요한 데이터 객체가 가지고 있음
		//함수 지향형 - 데이터와 메서드 분리. 메서드한테 자료를 넘겨줘야함 -> 파라미터 필요
		//객체지향 - 자료를 객체가 가지고 있음. 바로 쓰면 됨. -> 파라미터 필요 X
		//물론 필드에 값이 없음녀 파라미터 필요
	}
	
}
