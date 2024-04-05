package com.itwill.wrapper;

//Wrapper 클래스 : 자바의 기본 타입의 값을 하나만 저장하는(감싸는,포장하는) 클래스(타입).
//기본타입 : boolean, byte, short, int, long, char, float, double
//wrapper : Boolean, Byte, Short, Integer, Long, Character, Float, Double
//- java.lang 패키지에 있어서 import 문장이 필요하지 않음
// - 목적 : 
//  (1) 기본 타입의 값을 이용하는 메서드를 제공
//  (2)상속 / 다형성을 이용하기 위해서
//  (3) generic 클래스(List, Set, Map)들을 이용하기 위해서

public class WrapperEx {

	public static void main(String[] args) {
		// Integer type의 객체. int 값을 전달받아서 Integer 객체 생성
		Integer number1 = Integer.valueOf(1); //리턴타입은 인티저!!!! 아규먼트는 인트!!!! 인티저는 객체!!!
		System.out.println(number1);

		// String 객테를 전달받아서 Integer 객체 생성. 객체!!!
		Integer number2 = Integer.valueOf("4135");
		System.out.println(number2);
		
		//String을 int로 변환하는 정적 메서드.
		int number3 = Integer.parseInt("123");
		
		// auto-boxing : int타입 값을 자동으로 Integer 객체로 생성.
		Integer number4 = 4; //가능.
		System.out.println(number4);
		
		//auto-unboxing : Integer 타입 객체에서 객체가 가지고 있는 int 타입 값을 자동으로 꺼내줌
		int result = number1-number4; //객체-객체? 띠용. -> 각각에서 숫자 꺼내서 뺄셈 계산 후 result에 넣어줌..
		System.out.println(result);
	}

}







