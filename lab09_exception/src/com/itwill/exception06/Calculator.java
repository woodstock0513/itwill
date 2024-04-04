package com.itwill.exception06;

public class Calculator {

	public int divide(int x, int y) throws Exception { //디바이드는 Exception을 던진다!(throws)
		if (y != 0) {
			return x / y; // int를 리턴해야하는데,,y가 0이면 우째ㅜㅜ
		}
		
		throw new Exception("y는0이될수없음."); //Exception을 던져라!! (throw)

	}

}
