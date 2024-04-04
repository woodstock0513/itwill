package com.itwill.method06;

public class MethodMain06 {

	public static void main(String[] args) {
		// 메서드 오버로딩 (method overloading) :
		// 메서드의 파라미터가 다르면 같은 이름으로 메서드를 여러 개 선언 가능.
		// (주의) 메서드의 파라미터는 동일하고, 리턴 타입만 다르게 하는 경우는 불가하다. - 구분이안댐.
		// 호출하는 곳에서 구분이 가능해야!!
		
		System.out.println("hi"); //println(String x)
		System.out.println(100); //println(int x)
		System.out.println(); //println()
		System.out.println(true); //println(boolean x)
		
		newline();
		System.out.println("=======");
		newline(5);
		System.out.println("=======");

	}
	
	/**
	 * 콘솔에 빈 줄 하나를 출력하는 메서드.
	 */
	public static void newline() {
		System.out.println();
	}
	/**
	 * 콘솔에 n개의 빈 줄을 출력하는 메서드.
	 * @param n : 콘솔에 출력할 빈 줄의 개수. 양의 정수. 0이하의 정수이면 아무것도 출력하지 않음.
	 */
	public static void newline(int n) {
		while (n>0) { //for문도 가능.
			System.out.println();
			n--;
		}
	}
	//이게 오버로딩!

}
