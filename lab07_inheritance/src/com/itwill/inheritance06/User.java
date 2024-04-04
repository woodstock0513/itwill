package com.itwill.inheritance06;

import java.util.Objects;

public class User {
	//field 
	private String id;
	private String passWord;
	
	//constructor
	
	public User () {}
	
	public User(String id, String passWord) {
		this.id = id;
		this.passWord = passWord;
	}
	
	//method
	//toString() override. - id, pw를 화면에 출력
	@Override
	public String toString() {
		return "id = "+this.id +"  password = "+ this.passWord;
	}

	

	
	
//	equals 재정의 - id가 같으면 같은 객체, 그렇지 않으면 다른 객체
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(id, other.id));
//	}
//	만들어준건데 구려..
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof User && this.id != null) {
			User user = (User) obj;
			result = this.id.equals(user.id);
		}
		return result;
	}
	
	
	//hashcode 재정의 - id가 같은User객체는 같은 정수값이 리턴되도록
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
