package com.itwill.method01;

import java.util.Random;

public class MethodMain01 {

	
	//main method 함수랑은 쫌 다름.. 메서드는 함수의 일종
	//main method : 프로그램의 시작과 끝.
	public static void main(String[] args) {
		
		
		
		/*
		 * 메서드(method) : class 안에서 작성하는 함수(function) 기능
		 * - 프로그램에서 반복적으로 사용되는 기능들을 코드 블록으로 작성 - 기능이 필요한 곳에서 불러서(호출해서) 사용하기 위한 코드
		 * java언어는 class 안에서만 함수를 작성할 수 있음. → 자바는 메서드만 작성할 수 있다.
		 * 어떤 언어는 class 밖에서 만들 수도 있음 ex) 자바 스크립트 따라서 메서드와 함수가 구분이 됨!
		 * argument(아규먼트, 인수) : 메서드를 호출하는 곳에서 메서드에게 **전달**하는 **”값”**.
		 * parameter(파라미터, 매개변수, 인자) : 아규먼트를 저장하기 위해서 선언하는 **”변수”**.
		 * return value(반환값) : 메서드가 기능을 모두 수행한 후 메서드를 호출한 곳으로 반환하는 값
		 * - 메서드에 따라서 반환값이 있을 수도 있고 없을 수도 있다.
		 */
		
		
		
		
		
		
		System.out.println("hello");
		// 가장 마지막에 있는게 메서드 이름
		// println 메서드를 호출. 
		// println을 호출할 때 전달한 값. "hello" -> argument.
		// println 메서드에서 argument를 저장하기 위해 선언한 변수 -> parameter
		// println은 return 값이 없는 메서드. -> 변수에 저장할 수 없음
		
		Random random = new Random(); // 메서드는 아님 ㅎ
		
		int x = random.nextInt(10); // 괄호 생략 불가!!!
		// nextInt 메서드를 호출. 아규먼트 10을 전달.
		// nextInt는 반환값이 있는 메서드. 
		
	
	}

}
