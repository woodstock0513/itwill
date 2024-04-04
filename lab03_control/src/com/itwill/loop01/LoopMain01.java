package com.itwill.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//반복문
		System.out.println("Java 1");
		System.out.println("Java 2");
		System.out.println("Java 3");
		System.out.println("Java 4");
		System.out.println("Java 5");
		
		System.out.println("--------------------------");
		
		for (int i = 1; i<=5; i++) {
			System.out.println("Java "+i);
		}

	
		// 지역 변수 (local variable) : 메서드 안에서 선언한 변수
		// 지역 변수는 선언된 순간부터 변수가 포함된 블럭(해당 중괄호) 안에서만 사용 가능.
		// for 문장의 초기식에서 선언된 지역변수는 for 블럭 안에서만 사용가능 !!
		
		// 증감 연산자 : ++(1 증가) , --(1 감소)
		// 변수 이름 앞 또는 이름 뒤에서 사용 가능. i++, ++i 의미는 좀 다름 ㅋㅋ
		// ++i 먼저. i++ 나중.
		// y = x++ + 1 + ++x
		// 1+1 -> x=2 -> x=3 -> 2+3 => 결과 : 5
		int x = 1;
		int y = x++ + 1; // 더하기 먼저 하고 x++
		// y= x+1; x++;으로 나누면.. 편함
		
		System.out.println("x = "+x+"  y = "+y);
		
		x = 1;
		y = ++x + 1; //++x 먼저 하고 더하기 나중에 
		// x++; y=x+1; 하면 됨.
		
		System.out.println("x = "+x+"  y = "+y);
		
	}

}
