package com.itwill.switch02;

import java.util.Random;

public class SwitchMain02 {

	public static void main(String[] args) {
		// random 타입의 변수를 선언하고 초기화
		Random rand = new Random();
		
		//정수 타입의 변수에 1부터 4까지의 정수 난수 1개를 저장.
		int code = rand.nextInt(1,5);
		
		System.out.println(code);
		
		switch (code) {
		case 1: 
			System.out.println("man");
			break;
		case 2: 
			System.out.println("woman");
			break;
		case 3 : 
			System.out.println("man");
			break;
		default :
			System.out.println("woman");
		}
		
		
		
		//또다른 방법
		switch (code) {
		case 1:
		case 3:
			System.out.println("man");
			break;
		case 2:
		case 4:
			System.out.println("woman");
		}
		
	}
}