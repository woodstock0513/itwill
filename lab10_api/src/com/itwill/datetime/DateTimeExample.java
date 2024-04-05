package com.itwill.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeExample {

	public static void main(String[] args) {
		// Java 8 버전부터 생긴 java.time 패키지의 시간, 날짜 관련 클래스(한10년됨 ㅋㅋ)

		LocalDate today = LocalDate.now(); // static 메서드(클래스이름.으로 호출)

		System.out.println(today); // 주소가 나오지 않는 이유는, toString이 override 되어잇어서
		System.out.println(today.getYear());
		System.out.println(today.getMonth()); // enum. switch case 쓰면 좋을 듯
		System.out.println(today.getMonthValue()); // 숫자
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfWeek());

		System.out.println(today.plusDays(52));
		System.out.println(today.minusWeeks(5));

		LocalDate birthday = LocalDate.of(2002, 05, 13); // Month.DECEMBER
		System.out.println(birthday);

		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		System.out.println(now.getHour());
		System.out.println(now.of(2024, 03, 14, 9, 30));
		
		//Timestamp: 1970-01-01 00:00:00를 기준으로 해서 1/1000초(밀리초) 마다
		//1씩 증가하는 정수(long 타입)을 기반으로 날짜와 시간 정보를 저장하는 클래스()타입.
		
		//LocalDateTime --> Timestamp 변환
		
		Timestamp ts = Timestamp.valueOf(now);
		System.out.println(ts.getTime());
		
		//Timestamp --> LocalDateTime 변환
		LocalDateTime dt = ts.toLocalDateTime();
		System.out.println(dt);
		

	}

}
