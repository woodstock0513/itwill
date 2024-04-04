package com.itwill.modifier03;

public class Member { // 회원에 대한 정보 저장. id,pw
	// field
	private String memberId; // 읽기 전용 필드
	private String memberPw; // 읽기,쓰기 필드

	// constructor
	public Member(String memberId, String memberPw) { // public인 이유. 어디서든 호출을 해야하니까
		if (memberId != null && memberPw != null) { // 무결성
			this.memberId = memberId;
			this.memberPw = memberPw;
		} else {
			throw new IllegalArgumentException(); // 강제로 에러나게 하는것. 원래는 null해도 문법적으로 맞지만. 안되게 하려고.
			// lang 안에 있는거라 import 안해도 됨
		}
	}

	// method
	// getter method. 읽기만. 작명 : get+변수이름
	public String getMemberId() {
		return this.memberId;
	}

	public String getMemberPw() {
		return this.memberPw;
	}

	// setter method
	// 무결성 똑같이 사용 가능.
	public void setMemberPw(String password) {
		if (password != null) {
			this.memberPw = password;
		} else {
			throw new IllegalArgumentException();
		}
	}

}