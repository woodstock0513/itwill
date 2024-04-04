package com.itwill.condition07;

import java.util.Random;

public class ConditionMain07 {

	public static void main(String[] args) {
		// 조건문, 비교, 논리 연산자 연습		
		// 난수(random number)를 생성할 수 있는 타입의 변수를 선언, 초기화
		Random rand = new Random();
		
		int java = rand.nextInt(101);  // 0이상 101 미만. 101개의 정수 난수를 저장.
		System.out.printf("Java 점수는 %d점 입니다.\n",java);
		
		int sql = rand.nextInt(101);
		System.out.printf("SQL 점수는 %d점 입니다.\n",sql);
		
		int javaScript = rand.nextInt(101);
		System.out.printf("JavaScript 점수는 %d점 입니다.\n",javaScript);
		
		//세과목이 모두 40점 이상이고, 평균이 60점 이상이면 합격
		//그렇지 않으면 불합격 출력
		
		int sum = java + sql + javaScript;
		double mean = sum/3.0;
		
		String result = (java>=40 && sql>=40 && javaScript>=40 && mean>=60 ) ? "합격입니다." : "불합격입니다.";
		
		System.out.println(result);
		
		if (java>=40 && sql>=40 && javaScript>=40 && mean>=60 ) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
				
	}

}
