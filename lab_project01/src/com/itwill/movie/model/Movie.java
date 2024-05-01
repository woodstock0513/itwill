package com.itwill.movie.model;

import java.time.LocalDateTime;

public class Movie {
	
	
	public static final class Entity{
		
		public static final String TBL_MOVIES = "MOVIES";
		public static final String TBL_TIMES = "TIMES";
		public static final String TBL_SEAT = "SEAT";
		public static final String TBL_RESERVATIONS = "RESERVATIONS";
		
		public static final String COL_MOVNO = "MOVNO";
		public static final String COL_MOVINFO = "MOVINFO";
		public static final String COL_MNAME = "MNAME";
		public static final String COL_MDATE = "MDATE";
		public static final String COL_TNUM = "TIMENUM";
		public static final String COL_STATE = "STATE";
		public static final String COL_KEY = "KEY";
		public static final String COL_SEATNO = "SEATNO";
		public static final String COL_RESERVNO = "RESERVNO";
		public static final String COL_MEMNO = "MEMNO";
		public static final String COL_RESERVTIME = "RESERVTIME";
		
	}
	
	private String mname;
	private LocalDateTime mdate;
	private String movinfo;
	
	private int memno;
	private int seatNo;
	private LocalDateTime reservtime;
	
	public Movie( String mname, LocalDateTime reservtime, int seatNo,LocalDateTime mdate) {
		this.mname = mname;
		this.reservtime = reservtime;
		this.mdate = mdate;
		this.seatNo = seatNo;
	}

	public LocalDateTime getReservtime() {
		return reservtime;
	}

	public void setReservtime(LocalDateTime reservtime) {
		this.reservtime = reservtime;
	}

	public int getMemno() {
		return memno;
	}

	public void setMemno(int memno) {
		this.memno = memno;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	//info를 저장하는 생성자
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
