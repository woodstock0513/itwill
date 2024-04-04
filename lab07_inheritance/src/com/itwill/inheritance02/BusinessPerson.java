package com.itwill.inheritance02;

// 회사원은 사람이다. (비즈니스 펄슨 IS A 펄슨)
public class BusinessPerson extends Person{

	//필드
	private String company;

	
	
	//생성자
//	상위(부모)타입 객체가 먼저 생성되어야 하위(자식)타입의 객체를 생성할 수 있음.
//	생성자 호출 순서 : 상위 클래스 생성자 -> 하위 클래스 생성자 호출.
//	-> 각 클래스의 필드들 힙에 저장.
//	하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출하지 않으면.
//	상위 클래스의 "기본 생성자"가 자동으로 호출됨.
//	super(); 호출은 생략 가능!!
//	하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출할 때에는 suoer(~) 키워드를 사용
//	(주의) 상위 클래스의 아규먼트를 갖는 생성자는 자동으로 호출되지 않음.
//	상위클래스의 아규먼트를 갖는 생성자를 호출하려면 super(..);를 호출해야만! 함
//	생성자 코드 안에서 super(...) 호출은 가장 먼저!!! 작성되어야 함 
	
	
//	this의 의미:
//	(1) 생성된 객체(인스턴스)의 참조값 : this.field, this.method ...
//	(2) 오버로딩(overloading)된 생성자 : this(), this(...)
	
//	super의 의미 : 
//	(1) 생성된 상위 타입 객체의 참조값 : super.field, super.method ...
//	(2) 상위 클래스의 생성자 : super(), super(...)
	
	
	public BusinessPerson () { //모든필드 null
		super(); // 명시해도, 생략해도 결과는 same. 자동호출됨.
		System.out.println("BusinessPerson() 생성자");
	}
	
	public BusinessPerson(String company) {//아규먼트 하나, 컴패니
//		super(); //가 생략되어 있는 것임!! 모든 하위 클래스는 상위 클래스의 기본 생성자 호출이 자동으로 이루어짐.
		this.company = company;
		System.out.println("BusinessPerson (company) 생성자");
	}
	
	public BusinessPerson(String name, String company) {
		super(name);  //상위 클래스의 아규먼트가 1개인 생성자를 명시적으로 호출
		//1. 부모 클래스 인스턴스 - super.~  2.부모 클래스의 생성자를 명시적으로 부르는 것 - super(), super(name)
		this.company = company; //this() 같은 클래스의 다른 생성자.
		System.out.println("BusinessPerson name, company 생성자");
	}
	
	//메서드
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
