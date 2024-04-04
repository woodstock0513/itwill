package com.itwill.variable04;

public class VariableMain04 {

	public static void main(String[] args) {
		//문자(character) 타입 변수 char
		//char 타입 : 문자 한 개의 유니코드값(정수)를 저장. 문자 =/= 문자열
		//문자 - 작은 따옴표 'a' 문자 하나  문자열 - 큰 따옴표 사용 "asd","a"
		
		char a = 65;
		System.out.println(a);
		char b = 'e';
		System.out.println(b);
		System.out.println((int)b);
		
		//char는 문자의 유니코드를 저장하는 특별한 종류의 정수 타입
		//사칙연산, 크기 비교가 가능하다!
		char c = (char) (a-1);  //2는 int, a는 char -> a를 int로 자동으로 바꿔서 계산. 최종 결과 int -> 강제 타입 변환 시켜주기
		//타입 변환. casting
		System.out.println(c);
		boolean d = a>c;
		System.out.println(d);
	
		//1. 변수는 같은 타입의 값만 저장할 수 있다.
		//int x=2;, x=3.0; 불가
		//2. 큰 번위의 타입에는 작은 범위 타입의 값을 지정할 수 있다.
		//double x=1; 가능 굳이 double x = (double) 1; 안해도됨 
		//float x=1.0;은 안됨. 자바의 기본 실수는 더블(8바이트)라서! 그래서 f붙여야함 float x= 1.0f
		//3. 작은 범위의 타입에 큰 범위 값을 저장하려고 하면 에러가 발생.
		//정수는 예외. short s =123; ㄱㄴ. short 범위 내의 int는 ㄱㅊ
		//4. 정수 리터럴(literal, 상수)은 범위를 넘지 않으면 작은 타입(short, byte, char)에 저장 가능하다. (3의 예외) 변수는 안됨
		//강제 타입 변환(casting)은 변수의 타입을 강제로 바꿔준다. 큰값을 작은 범위에 넣을 때 주로 사용한다.
		
	}
	

}
	