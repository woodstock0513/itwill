package com.itwill.movie.model;

import java.time.LocalDateTime;

public class Movie {
	
	
	public static final class Entity{
		
		public static final String TBL_MOVIES = "MOVIES";
		public static final String TBL_TIMES = "TIMES";
		
		public static final String COL_MOVNO = "MOVNO";
		public static final String COL_MOVINFO = "MOVINFO";
		public static final String COL_MNAME = "MNAME";
		public static final String COL_MDATE = "MDATE";
		public static final String COL_TNUM = "TIMENUM";
		
	}
	
	private String mname;
	private LocalDateTime mdate;
	private String movinfo;
	
	public Movie(String movinfo) {
		this.movinfo = movinfo;
	}

	public String getMovinfo() {
		return movinfo;
	}

	public void setMovinfo(String movinfo) {
		this.movinfo = movinfo;
	}


	public Movie(String mname, LocalDateTime mdate) {
		this.mname = mname;
		this.mdate = mdate;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public LocalDateTime getMdate() {
		return mdate;
	}
	public void setMdate(LocalDateTime mdate) {
		this.mdate = mdate;
	}
	

}
