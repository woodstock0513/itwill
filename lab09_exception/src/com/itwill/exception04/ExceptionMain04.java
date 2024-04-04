package com.itwill.exception04;

//예외 클래스들의 상속 관계 :
//Object
//|__ Throwable  ---- getMessage의 주인! (able이지만 인터페이스가 아니라 ㄱ클래스임)
//		|__ Exception
//			|__ RuntimeException
//				|__ Ari~, Number~, NullPointer~, Array~
//--> Exception을 잡으면 모든 예외 다 잡을 수 잇음 (상속이슈)


//catch 블럭이 여러 개인 경우, 하위 타입의 예외 타입을 먼저 catch하고 , 상위 타입의 예외를 나중에 catch


public class ExceptionMain04 {

	public static void main(String[] args) {
		
		
		// finally : 에외 상황 발생 여부와 상솬없이 항상 실행되는 블록
		// try 또는 catch블록 안에 return 문장이 있어도, finally 블록이 실행된 후에 return 문장이 실행됨

		try {
			
		} catch (ArithmeticException e)  {
			
		} catch (Exception e) {
			//일종의 다형성
			//Exception  클래스를 상속하는 모든 종류의 예외를 잡을 수 있음.
		}
		
		
		try {
			int x = 100;
			int y = 0;
			System.out.println("몫 : " + (x / y));
			System.out.println("end try");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("end catch");
			return; // main 메서드 종료
		} finally {
			System.out.println("when?");
		}
		System.out.println("main  end");
	}

}
