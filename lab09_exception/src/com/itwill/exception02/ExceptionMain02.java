package com.itwill.exception02;

import java.util.Scanner;

//try-catch 문장을 사용한 예외 처리 : 

//try {
//	정상적인 상황에서 실행할 코드들; //(1)
//}catch (Exception 타입의 변수 선언) {
//	예외 상황이 발생했을 때 처리할 코드들; //(2)
//} finally{
//	예외 상황 발생 여부와 상관 없이 반드시 실행할 코드들; //(3)
//}

// 예외 발생 X : (1) -> (3)
// 예외 발생 : (1)- 예외 발생 -> (2) -> (3)

//try - catch 문장에서 catch블럭은 반드시 1개 이상 있어야함.
// catch블럭은 처리하려는 예외의 종류에 따라 여러개 작성 가능.
//finally 블록은 선택 사항


public class ExceptionMain02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("정수 x 입력 >> ");
			int x = Integer.parseInt(sc.nextLine());

			System.out.print("정수 y 입력 >> ");
			int y = Integer.parseInt(sc.nextLine());

			System.out.println("나눗셈 => " + (x / y));
		} catch (ArithmeticException e) {
			System.out.println("y는 0이 될 수 없음.");
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("정수만 입력하시오");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("END");
		}
		
		
		
		
		

	}

}
