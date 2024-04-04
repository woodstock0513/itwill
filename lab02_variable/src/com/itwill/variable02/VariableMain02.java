package com.itwill.variable02;

public class VariableMain02 {

	public static void main(String[] args) {
		//정수를 저장하는 변수 x를 선언하고 값을 저장
		int x = 513;
		//정수를 저장하는 변수 y를 선언하고 값을 저장.
		int y=427;
		//두 변수 x와 y의 사칙연산(+,-,*,/)결과를 각각 출력
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		System.out.println("x+y="+(x+y));
		System.out.println("x+y="+x+y);
		System.out.println("x-y="+(x-y));
		System.out.println("x/y="+x/y);
		System.out.printf("%d/%d=%d\n",x,y,x/y);
		System.out.println("나눈 나머지 = "+x%y);
		//나누기 연산자(/)
		// 1. 정수 / 정수 = 몫만 나옴
		// 2. 실수 / 실수 & 정수 / 실수 & 실수 / 정수 = 소수점까지 계산
		//나머지 연산자(%) - 정수간 계산에서만 의미 O
		
		double num1 = 513.0;
		double num2 = 427.0;
		System.out.println(num1/num2);
	}

}
