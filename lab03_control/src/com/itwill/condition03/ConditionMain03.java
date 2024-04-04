package com.itwill.condition03;

import java.util.Scanner;

public class ConditionMain03 {

	public static void main(String[] args) {
		
		// 스캐너 타입의 변수를 선언하고 초기화
		Scanner sc = new Scanner(System.in);
		//콘솔창에서 java, sql, javScript 과목 점수(0~100) 입력받고 저장.
		System.out.print("java 시험 점수를 입력하세요. ");
		int java = sc.nextInt();
		System.out.print("sql 시험 점수를 입력하세요. ");
		int sql = sc.nextInt();
		System.out.print("javaScript 시험 점수를 입력하세요. ");
		int javaScript = sc.nextInt();
		
		//세 과목의 점수 출력
		System.out.printf("java 점수는 %d점, sql 점수는 %d점, javaScript 점수는 %d점입니다.\n",java,sql,javaScript);
		
		//세 과목의 총점 계산하고 출력
		int sum = java+sql+javaScript;
		System.out.println("세 과목의 총점은 "+sum+"입니다.");
	
		//세 과목의 평균(소수점)을 계산하고 출력
		double ave = sum / 3.0; // or double ave = (double) sum / 3
		System.out.printf("세 과목의 평균은 %.2f입니다.\n",ave);
		
		System.out.print("당신의 학점은 ");
		
		//세과목 평균이 90점 이상이면  A, 80~ B, 70~ C, under 70 F
		if (ave>=90) {
			System.out.println("A");
		} else if (ave>=80) {
			System.out.println("B");
		} else if (ave>=70) {
			System.out.println("C");
		} else {
			System.out.println("F");
		}

	}

}
