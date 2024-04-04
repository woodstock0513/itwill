package com.itwill.loop06;

public class LoopMain06 {

	public static void main(String[] args) {
		//중첩반복문 : 반복문 안에서 반복문 사용
		//구구단 2~9단.
		
		for (int i = 2 ; i<10;i++) {
			System.out.println("----"+i+"단 ----");
			
			for (int j =1; j<10;j++) {
				System.out.printf("%d x %d = %d\n",i,j,i*j);
			}
		
			System.out.println("------------");
		}
		
	}

}
