package com.itwill.ver01;

//연락처 데이터를 표현하는 클래스
//입력 출력 안하겠다!! 그래서 밑에서 프린트 안함. 
public class Contact {
	// 필드
	private String name;
	private String phone;
	private String email;

	// 생성자
	public Contact() {
	}

	public Contact(String name, String phone, String email) {
		this.email = email;
		this.name = name;
		this.phone = phone; // this = 생성된 객체. this();라고 쓰면 다른 생성자를 호출.
	}

	// 메서드
	// getter & setter
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// 연락처 정보 (이름, 전화번호, 이메일)을 문자열로 리턴하는 메소드
	@Override
	public String toString() {
		return "Contact (name = " + this.name + " / phone = " + this.phone + " / email = " + this.email + ")"; // concat
	}

}