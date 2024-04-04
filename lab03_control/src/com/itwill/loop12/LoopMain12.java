package com.itwill.loop12;

import java.util.Random;

public class LoopMain12 {

	public static void main(String[] args) {
		// 확인문제 3
		// 주사위 두 개를 던졌을 때 결과를 (x,y) 형식으로 출력.
		// 주사위 두 개의 눈의 합이 5가 되면 실행을 멈춤
		int x,y;
		Random rand = new Random();
		System.out.println("문제 3번");
		System.out.println("---do while 문---");
		do {
			x= rand.nextInt(1,7); //switch 2번 참고
			y=rand.nextInt(1,7);
			System.out.printf("(%d,%d)\n",x,y);
			
		} while (x+y!=5); // DO를 실행시키는 조건
		
		System.out.println("---while 문---");
		
		while (true) { //무한루프
			int a = rand.nextInt(1,7); // 1 <= x <7 범위의 난수
			int b = rand.nextInt(1,7); // 1 <= x <7 범위의 난수
			System.out.printf("(%d,%d)\n",a,b);
			if ((a+b)==5) { // 멈추는 조건
				break; 
			}
		}
		
		

	
		//확인 문제 4
		// 4x+5y=60을 만족하는 x와 y찾기
		// x와 y는 10 이하의 자연수
		
		System.out.println("문제 4번");
		for (x=1;x<11;x++) {
			for (y=1;y<11;y++) {
				if (4*x+5*y==60) {
					System.out.printf("(%d,%d)\n",x,y);
				}
			}
		}
		
		
		
	}

}
