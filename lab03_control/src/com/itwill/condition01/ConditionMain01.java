package com.itwill.condition01;

public class ConditionMain01 {

	public static void main(String[] args) {
		//조건문 (conditional statement)
		int num = 20;
		//1. if구문
		if (num>10) {
			//조건식을 만족하는 경우에 실행할 코드 블록
			System.out.println("num은 10보다 크다.\n");
		}
		//2. if else 구문
		num = 1231234;
		if (num % 2 ==0) {
			//조건식을 만족하는 경우 실행
			System.out.println("짝수입니다.\n");
		} else {
			//조건식을 만족하지 않는 경우 실행
			System.out.println("홀수입니다.\n");
		}
		
		System.out.println("=== END ===");
		
	
	}

}
