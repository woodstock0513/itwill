package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

	private final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionMain03 app = new ExceptionMain03();
		int x = app.inputInteger2();

		System.out.println("x = " + x);

	}
	
	
	public int inputInteger2() { //재귀함수.
		try {
			System.out.print("정수 입력 >> ");
			return Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e){
			System.out.println("정쑤!!");
			return inputInteger2();
		}
	}

	public int inputInteger() {
		System.out.print("x를 입력하시오");
		boolean run = true;
		int result=0;

		while (run) {
			try {
				result =  Integer.parseInt(sc.nextLine());
				run = false;  //걍 break로 해도 되나봄 
				
			} catch (NumberFormatException e) {
				System.out.println("정수를 입력하세요!!");
				System.out.println("ERROR!! " + e.getMessage());

			}
		}
		return result;
	}

}
