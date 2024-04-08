package com.itwill.set03;

import java.util.Objects;

public class Score {
	
	private int java;
	private int sql;
	private int html;
	
	public Score () {}
	

	public Score (int java, int sql, int html) {
	this.html = html;
	this.java = java;
	this.sql = sql;
	}

	public int getJava() {
		return java;
	}


	public void setJava(int java) {
		this.java = java;
	}


	public int getSql() {
		return sql;
	}


	public void setSql(int sql) {
		this.sql = sql;
	}


	public int getHtml() {
		return html;
	}


	public void setHtml(int html) {
		this.html = html;
	}
	
	@Override
	public String toString() {
		
		return "Score(java : "+java+", sql : "+sql+", html : "+html+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (this != null && obj instanceof Score) { //this = 이 메서드를 호출한 객체
			Score other = (Score) obj;
			result = (this.java == other.java)&&(this.html == other.html)&&(this.sql == other.sql);
		}
		return result;
	}
	
	@Override
	public int hashCode() { //equals가 true면 hashcode도 같아야함
//		return java + sql + html;
		return Objects.hash(java,sql,html); //이케도 가능.
	}

}
