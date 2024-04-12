package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class LambdaMain01 {

	public static void main(String[] args) {
		
		// Calculator타입 객체 생성
		Calculator cal = new Calculator(2, 8);
		
		//---- 별도 파일에 작성된 클래스 Adder 사용
		//Calculable을 구현하는 객체 생성
		Calculable adder = new Adder(); //다형성
		
		
		//메서드 생성
		double result = cal.calculate(adder);
		System.out.println(result);
		
		
		//---- 지역 클래스 사용
		class Subtracter implements Calculable{
			@Override
			public double calculate(double x, double y) {
				// TODO Auto-generated method stub
				return x-y;
			}
		}
		result = cal.calculate(new Subtracter());
		System.out.println(result);
		
		
		
		//----익명클래스 사용
		result = cal.calculate(new Calculable() {
			@Override
			public double calculate(double x, double y) {
				// TODO Auto-generated method stub
				return x*y;
			}
		});
		
		
		//-----람다 표현식 사용
		result = cal.calculate((double x, double y) -> {return x /y;}); //이게 원래 정식 문법
		result = cal.calculate((x,y)-> x/y);
		//                 (파라미터) -> 리턴값
		// 추상 메서드를오직 한 개만 가지고 있는 인ㅍ터페이스만이 람다 표현식을 이용할 수 있음.
		System.out.println(result);
		
		result = cal.calculate((x,y)-> x*x+y*y);
		System.out.println(result);
		
		
		
		
		
//		람다 표현식.(lambda expression)
//		익명 클래스 객체 생성을 간단하게 작성하기 위한 문법
//		함수형 인터페이스(추상 메서드가 오직 1개인 인터페이스)만 람다 표현식을 사용할 수 있음.!!!!!
//		=> 추상 메서드가 2개 이상이면 못 씀..ㅠㅠ 익명 클래스 만들어야함.
//		
//		람다 표현식 문법 : (파라미터 선언) -> { 코드; }
//		- 파라미터 선언에서 변수 타입은 생략 가능 (이건 only 람다 표현식에서만 가능.)
//		- 람다 표현식 몸통({})에 한 문장만 있는 경우, {}와 ; 생략 가능. {}만 생략하는 경우엔 ;가 남아있으면 중간에 코드가 끊기기 때문에 ;도 같이 생략한다.!! 
//		- 람다 표현식 몸통이 리턴 문장만 있는 경우에는 return 도 생략 가능하다. -> 리턴 값만 쓰면 됨
//		  (x,y)-> x/y
//		람다 표현식에서 파라미터 개수가 한 개인 경우에는 ()가 생략 가능.
//		 (x) -> 2*x , x -> 2*x
//		파라미터가 없는 경우, ()는 생략할 수 없음.
//		() -> "안녕";  파라미터가 없음을 알려줌

	}

}