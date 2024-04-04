package com.itwill.exception05;

import java.util.Scanner;

//multi-catch 블록
//하나의 catch 구문에서 여러개의 Exception 타입 객체를 처리하는 방법
//
//try {
//	//todo
//} catch (Exception Type 1 | Exception Type 2 | ... e){
//	//todo
//}
//
// 주의) 상속 관계가 있는 예외 클래스들은 멀티-캐치 블록에서 사용할 수 없음.
//가능한 예 : catch(Ari~|Number~ e)   -- 상속관계가 아님
//컴파일 에러 : catch (Ari~ | Exception e) --상속관계라서 부모타입만 쓰면 됨.


public class ExceptionMain05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("x = ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.print("y = ");
			int y = Integer.parseInt(sc.nextLine());
			
			System.out.println("몫 = "+(x/y));
			
	
			
		} catch (NumberFormatException | ArithmeticException e) {
			System.out.println(e.getMessage());
		}
			
	}

}
