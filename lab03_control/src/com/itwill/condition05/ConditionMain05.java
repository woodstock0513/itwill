package com.itwill.condition05;

import java.util.Scanner;

public class ConditionMain05 {

	public static void main(String[] args) {
		// 삼항 연산자 : if-else 구문을 간단히 쓰는 문법
		// (조건식) ? (조건식이 참일 때 선택할 값) : (조건식이 거짓일 때 선택할 값)
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int big; // x와 y 중에서 더 큰 수를 저장하기 위한 변수
		if (x>=y) {
			big = x;
		} else {
			big =y;
		}
		
		System.out.println(big);
		
		int big2 = (x>=y) ? x : y;
		
		System.out.println(big2);
	}

}


