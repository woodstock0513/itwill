package com.itwill.looppractice;

import java.util.Scanner;

public class LoopPractice {

	public static void main(String[] args) {
		
		
		
		
		//확인 7번
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("-------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-------------------");
			System.out.print("선택> ");
			int in = scan.nextInt();
			
			if (in ==1 ) {
				System.out.println("예금액>10000");
			} else if (in==2) {
				System.out.println("출금액>2000");
			} else if (in==3) {
				System.out.println("잔고>8000");
			} else {
				System.out.println();
				break;
			}
			System.out.println();
			
		}
	
		System.out.println("프로그램 종료");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * 확인 6번
		for (int i =1;i<5;i++) {
			for (int j=4;j>0;j--) {
				if (i<j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		int n=1;
		do {
			System.out.println(n);
			n++;
		} while (n<5);
		
		
		
		
		
		
		
		
		
		//7 번 하다 만
		 * do {
			System.out.println("-------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-------------------");
			System.out.print("선택> ");
			in = scan.nextLine();
			boolean tf = (in == "4");
		} while (false);
		
		
		
		
		
		*/
		
		
		
	}

}
