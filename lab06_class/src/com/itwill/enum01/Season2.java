package com.itwill.enum01;

public class Season2 {
	
	public static final Season2 SPRING = new Season2("봄");
	public static final Season2 SUMMER = new Season2("여름");
	public static final Season2 FALL = new Season2("가을");
	public static final Season2 WINTER =new Season2("겨울");
	//0123 저장하는 거랑 비슷한데, 객체 타입이니까 객체의 주소?를 저장하는 것이다.
	
	private String name;
	
	//(아무것도 없으면 ) 기본 생성자(퍼블릭)만 있음.
	private Season2(String name) { //이케 하면 Main 에서 기본 생성자 호출할 수 없움!
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	//이걸 다 줄여서 이넘 타입으로 만든건가방
	//-> 이넘도 클래스인것! 생성자도 다 가지고 있음.

}
