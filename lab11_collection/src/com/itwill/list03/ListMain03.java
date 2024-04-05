package com.itwill.list03;

import java.util.ArrayList;
import java.util.Random;

public class ListMain03 {

	public static void main(String[] args) {
		// 1. 정수를 저장할 수 있는 AL를 선언, 객체 생성
		ArrayList<Integer> numbers = new ArrayList<>();
		
		// 2. numbers에 [0,100] - 0이상 100이하. 범위의 난수 20개를 저장. //(0,100) - 0초과 100미만. 
		int num = 20;
		Random rand = new Random();
		for (int i = 0; i<num;i++) {
			numbers.add(rand.nextInt(101));
		}
		
		// 3. numbers 출력
		System.out.println(numbers);
		
		// 4. 홀수들만 저장할 수 있는 AL(odds) 선언, 객체 생성
		ArrayList<Integer> odds = new ArrayList<>();
		
		// 5. numbers에 저장된 숫자들 중에서 홀수들을 찾아 odds에 저장 - 반복문으로 검사.
		for (int i =0 ; i < numbers.size();i++) {  //향상된 반복문으로 해도 ㄱㅊ
			if (numbers.get(i) %2 != 0) {
				odds.add(numbers.get(i));
			}
		}
		
		// 6. odds 출력
		System.out.println(odds);
				
		// 7. 정수를 저장할 수 있는 AL(evenSquares) 선언, 객체 생성
		ArrayList<Integer> evenSquares = new ArrayList<>();
		
		// 8. numbers에 저장된 숫자들 중에서 짝수를 찾아 짝수의 제곱을 evenSquares에 저장
		for (int i =0 ; i < numbers.size();i++) { //얘도 향상된 반복문으로 걍 ㄱㄱ
			if (numbers.get(i) %2 == 0) {
				int sq = numbers.get(i) * numbers.get(i);
				evenSquares.add(sq);
			}
		}
		
		//9. evenSquares 출력
		System.out.println(evenSquares);

	}

}
