package com.itwill.condition06;

import java.util.Scanner;

public class ConditionMain06 {

	public static void main(String[] args) {
		// 삼항 연산자 연습
		//1. number 변수가 짝수인지 홀수인지 저장하는 변수 evenOrOdd
		Scanner sc =  new Scanner (System.in);
		
		System.out.print("숫자를 입력하시오. ");
		
		int num = sc.nextInt();
		
		String evenOrOdd = (num % 2==0) ? "even" :  "odd";
		
		System.out.println(evenOrOdd);
		
		//2. genderCode 값이 1 또는 3이면 "남성", 그렇지 않으면 "여성"으로 저장.
		
		System.out.print("주민번호 뒷자리 첫번째 수를 입력하시오. ");
		
		int genderCode = sc.nextInt();
		String man = "남성";
		String woman = "여성";
		
		String gender = (genderCode==1 || genderCode ==3) ? man : woman;
		
		System.out.println(gender);

	}

}
