package com.itwill.array09;

import java.util.Random;

public class ArrayMain09 {

	public static void main(String[] args) {
		Random random = new Random();
		// 1차원 정수 (int) 배열 3개를 갖는 2차원 배열(array)를 선언, 초기화
		
		// 2차원 배열 array의 첫번째 배열에는 난수를 2개, 두번쩨 배열에는 난수 3개, 세번째 배열에는 난수 4개를 저장.
		// 난수의 범위는 0이상 10 미만
		// 2차원 배열 array의 내용을 출력.
		// 2차원 배열의 모든 원소(정수 9개)의 합을 계산하고 출력
		// 2차원 배열의 모든 원소(정수 9개)의 평균을 계산하고 출력
		
		int[][] array = new int [3][];
		
//		array[0] = new int [2];
//		array[1] = new int [3];
//		array[2] = new int [4];
		
		

		for (int i =0;i<array.length;i++) {
			array[i] = new int[i+2];  //규칙성이 있어서 이렇게 가능
			for (int j = 0; j<array[i].length;j++) {
				array[i][j] = random.nextInt(10);
			}
		}
		
		int sum = 0;
		int count = 0; //배열의 원소 개수를 저장할 변수
		for (int[] i : array) {
			for (int j : i) {
				System.out.print(j + " ");
				sum+=j;  // 배열에서 읽는 값을 sum에 더함
				count++; //배열에서 읽은 원소 개수를 증가
			}
			System.out.println();
		}
		
		System.out.println("sum = "+sum);
		
		int len=0; 
		
		for (int i=0; i<array.length;i++) {
			len += array[i].length;
		}
		
		double mean  = (double) sum / len;  //len을 count로 대체 가능.
		
		System.out.printf("mean = %.2f",mean);
		

	}

}
