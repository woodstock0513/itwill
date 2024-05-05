package com.itwill.movie.model;

import java.time.LocalDateTime;

public class Movie {
	
	
	public static final class Entity{
		
		public static final String TBL_MOVIES = "MOVIES";
		public static final String TBL_TIMES = "TIMES";
		public static final String TBL_SEAT = "SEATS";
		public static final String TBL_RESERVATIONS = "RESERVATIONS";
		
		public static final String COL_MOVIE_NO = "MOVIE_NO";
		public static final String COL_MOVIE_INFO = "MOVIE_INFO";
		public static final String COL_MOVIE_NAME = "MOVIE_NAME";
		public static final String COL_MOVIE_DATE = "MOVIE_DATE";
		public static final String COL_TIME_NO = "TIME_NO";
		public static final String COL_STATE = "STATE";
		public static final String COL_SEAT_ID = "SEAT_ID";
		public static final String COL_SEAT_NO = "SEAT_NO"; 
		public static final String COL_RESERVATION_NO = "RESERVATION_NO";
		public static final String COL_MEMBER_NO = "MEMBER_NO";
		public static final String COL_RESERVATION_TIME = "RESERVATION_TIME";
		
	}
	
	private String movieName;
	private LocalDateTime movieDate;
	private String movieInfo;
	
	private int memberNo;
	private int seatNo;
	private LocalDateTime reservtime;
	private int reservationNo;
	
	public Movie( String mname, LocalDateTime reservtime, int seatNo,LocalDateTime mdate, int reservationNo) {
		this.movieName = mname;
		this.reservtime = reservtime;
		this.movieDate = mdate;
		this.seatNo = seatNo;
		this.reservationNo = reservationNo;
	}
	
	public int getReservationNo() {
		return reservationNo;
	}
	
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public LocalDateTime getReservtime() {
		return reservtime;
	}

	public void setReservtime(LocalDateTime reservtime) {
		this.reservtime = reservtime;
	}

	public int getMemno() {
		return memberNo;
	}

	public void setMemno(int memno) {
		this.memberNo = memno;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	//info를 저장하는 생성자
	public Movie(String movinfo) {
		this.movieInfo = movinfo;
	}

	public String getMovinfo() {
		return movieInfo;
	}

	public void setMovinfo(String movinfo) {
		this.movieInfo = movinfo;
	}


	public Movie(String mname, LocalDateTime mdate) {
		this.movieName = mname;
		this.movieDate = mdate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMname(String mname) {
		this.movieName = mname;
	}
	public LocalDateTime getMovieDate() {
		return movieDate;
	}
	public void setMdate(LocalDateTime mdate) {
		this.movieDate = mdate;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", movieDate=" + movieDate + "]";
	}
	

	
}
