package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

	public static void main(String[] args) {
		// 정수를 저장하는 해시셑을 선언하고 초기화
		HashSet<Integer> numbers = new HashSet<>();

		// set에 [0,10) - 0이상 10 미만의 서로 다른 난수 5개를 set에 저장.
		Random rand = new Random();
		while (true) {
			numbers.add(rand.nextInt(10));
			if (numbers.size() == 5) {
				break;
			}
		}
		
//		while (numbers.size()<5) { 조건식 이케도 가능
//			numbers.add(rand.nextInt(10));
//		}
		

		// 향상된 for문을 이용해서 집합의 내용 출력
		for (Integer i : numbers) {
			System.out.print(i + " ");
		}
	}

}
