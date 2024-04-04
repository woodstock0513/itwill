package com.itwill.variable05;

public class VariableMain05 {

	public static void main(String[] args) {
		//boolean 타입 : 논리타입. true, false만을 저장할 수 있는 데이터 타입.
		//비교연산, 논리연산의 결과값이 boolean 타입이다.
		//비교연산자 : ==, !=, >,>=,<,<=
		//논리 연산자 : &&,||,! and or not
		// assignment operator 할당 연산자
		int x=2;
		int y=5;
		
		boolean b1=x!=y;  // 저장을 제일 마지막에 함 -> x!=y 먼저
		System.out.println(b1);
		
		boolean b2 = x>y;
		System.out.println(b2);
		
		boolean b3 = (x>0) && (x<10);
		System.out.println(b3);


		
	}	

}
