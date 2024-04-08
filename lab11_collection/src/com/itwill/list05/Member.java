package com.itwill.list05;

import java.util.Objects;

public class Member {
	private String id;
	private String pw;
	
	public Member (String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { //id가 같으면 트루가 나오도록..
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
