package com.itwill.array02;

public class ArrayMain02 {

	public static void main(String[] args) {

		//배열 선언 & 초기화 방법 2 :
		//배열이 가지고 있는 원소들을 나열하면서 배열을 초기화.
		// 타입[] 변수이름 = {...}; - 더 간단.
		// 타입 [] 변수 이름 = new 타입이름 [] {...}; 주의! 원소개수 표시 X!
		int[] numbers = {1,3,5,7,9};
		for (int i = 0; i<numbers.length; i++){
				System.out.println(numbers[i]);
		}
		//향상된 for문 (enhanced for statement, for each) - 코드 간단.
		//for ( 변수 선언 (배열이 가지고 있는 원소의 타입으로) : 배열 이름 ) { ... }
		//배열의 원소들을 순서대로 반복(literation)하면서 반복문 블록을 수행.
		//배열 원소의 값을 읽을 수는 있지만, 변경할 수는 없다.
		for (int x : numbers) { // 반복할 원소가 없을 때까지. 순서대로 하나씩 꺼내오는거. 인덱스 이용 불가.
			System.out.println(x);
			//x를 바꿔도 numbers의 배열을 바꾸는 것 X
			//x는 배열의 값을 가져오는 역할
			x=20; // 의미 X
		}
		//boolean 타입 5개를 저장하는 배열을 선언하고, 기본값(폴스)로 초기화
		boolean [] bools = new boolean[5];
		for (int i = 0;i<bools.length;i++) {
			System.out.print(bools[i] + " ");
		}
		System.out.println();
		
		bools[0] = true;
		bools[2] = true;
		
		for (boolean x : bools) {
			System.out.print(x+ " ");
		}
		System.out.println();
		
		//문자열 3개를 저장할 수 있는 배열을 선언하고 기본값으로 초기화.
		String names[] = new String[3];
		names[0] = "홍길동";
		names[2]="오쌤";
		for (String i : names) {
			System.out.println(i);
		}
		
		
	}
	
}
