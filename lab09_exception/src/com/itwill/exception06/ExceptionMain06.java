package com.itwill.exception06;

public class ExceptionMain06 {

	public static void main(String[] args) {
		//Integer.parseInt(""); // compile에러가 없지만, try-catch로 안 묶어도 됨. (익바익) 
		// throws 선언문이 있는 메서드들 중에서, RunTimeException을 상속하는 예외 타입들은 try-catch를 사용하지 않아도 컴파일 에러가 없음.
		// RunTimeException이 아닌 예외들은 반드시!! 
		//(1) try-catch 문장을 사용하거나
		//(2) throws 선언문을 추가해야한다.

		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		try {
			int result = cal.divide(8, 4);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("main end");
	}

}
