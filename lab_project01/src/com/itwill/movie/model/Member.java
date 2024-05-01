package com.itwill.movie.model;

import java.time.LocalDateTime;

public class Member {
	
	public static final class Entity{
		
		public static final String TBL_MEMBERS = "MEMBERS";
		
		public static final String COL_MEMID = "MEMID";
		public static final String COL_MEMNAME= "MEMNAME";
		public static final String COL_MEMPW = "MEMPW";
		public static final String COL_MEMNO = "MEMNO";
		public static final String COL_MEMBIRTH = "MEMBIRTH";
		public static final String COL_MEMPHONE = "MEMPHONE";
		
	}
	
	
//	private int memno; //이걸.. 이용을 하나? 일단 냅두고 ㄱㄱ
	private String name;
	private String id;
	private String password;
	private LocalDateTime birthdate; // 이건 타입 고민 좀 더 해보기
	private String phone;
	
	public Member(String name, String id, String password, LocalDateTime birthdate, String phone) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.birthdate = birthdate;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	} 
	
	
	

}
