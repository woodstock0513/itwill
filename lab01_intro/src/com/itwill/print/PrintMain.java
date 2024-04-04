package com.itwill.print;

public class PrintMain {

	public static void main(String[] args) {
		// 여러가지 콘솔 출력 방법
		System.out.println("한줄출력-print line"); //출력 후 줄바꿈
		System.out.println("1+2"); //문자열 스트링
		System.out.println(1+2); // 덧셈 결과 출력. 정수
		System.out.println("1+2="+3); //+는 문자열을 붙여주는 역할
		System.out.println("1+2="+1+2);
		System.out.println("1+2="+(1+2));	
		
		System.out.print("안녕하세용구리");
		System.out.println("  happy");

		//  \t는 탭
		System.out.printf("문자열 포맷 : 정수(%d), 실수(%f), 문자열(%s)\n",123,3.14,"숫자"); //formatted printing. 형식을 가지는 출력문.
		System.out.printf("%d + %d = %d", 12,23,35);

		
	}

}
