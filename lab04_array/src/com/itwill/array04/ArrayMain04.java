package com.itwill.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
//		정수 10개를 저장할 수 있는 배열을 만들고 기본값으로 초기화
//		배열 codes에 1 이상 4 이하 범위의 정수를 임의로 저장.
//		정수 배열의 내용을 출력
//		문자열(string) 10개를 저장할 수 있는 배열(genders)를 만들고 기본값으로 초기화
//		code의 원소가 1 또는 3이면 "남성", 2 또는 4이면 "여성"으로 바꿔서 문자열 배열에 저장.
//		문자열 배열의 내용을 출력
		int [] codes = new int [10];
		
		Random rand = new Random();
		
		for (int i = 0;i<codes.length;i++) {
			codes[i] = rand.nextInt(1,5);
		}
		
		for (int i : codes) {
			System.out.print(i+" ");
		}
		System.out.println();
		String [] genders = new String[10];
		
		//향상된 for문은 값 저장이 안되기 때문에 쓸 수 없음!! index 이용해야하므로 일반 for문 사용!
		for (int i=0;i<codes.length;i++) {
			if (codes[i]==1 || codes[i]==3) {
				genders[i] = "남성";
			} else {
				genders[i] = "여성";
			}
		}
		for (String s : genders) {
			System.out.print(s + " ");
		}
		
	}

}
