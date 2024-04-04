package com.itwill.array03;

import java.util.Random;

public class ArrayMain03 {

	public static void main(String[] args) {
//		시험 점수 성적 처리 프로그램
//		성적은 난수로 만들고 배열에 저장. 배열된 저장된 점수들의 합계와 평균을 출력.
//		
//		Random 타입 변수 선언 & 초기화
//		int 타입 5개를 저장할 수 있는 배열(scores) 선언하고 기본값으로 초기화;
//		for 문을 사용해서 5개의 정수 난수 (0~10)을 배열에 저장
//		향상된 포문을 사용해서 배열에 저장된 모든 점수들을 출력
//		합계, 평균 출력
		
		Random rand = new Random();
		
		int[] scores = new int[10];
		
		for (int i = 0;i<scores.length;i++) {
			scores[i] = rand.nextInt(0,11);
		}
		
		for (int i:scores) {
			System.out.print(i+" ");
		}
		System.out.println();
		int sum=0;
		for (int x:scores) {
			sum+=x;
			}
		System.out.printf("sum = %d\n",sum);
		
		double mean = (double) sum/scores.length;
		
		System.out.printf("mean = %.2f",mean);
		
		
		
		
		
		
		
		
		
		/*
		int sum=0;
		double mean=0;
		
		for (int i = 0;i<5;i++) {
			int score = rand.nextInt(0,11);
			scores[i] = score;
			sum+=score;
		}
		
		for (int i : scores) {
			System.out.print(i+"점 ");
		}
		System.out.println();
		
		mean = sum / 5.0;
		
		System.out.printf("sum = %d, mean = %.2f", sum, mean);
		*/
	}

}
