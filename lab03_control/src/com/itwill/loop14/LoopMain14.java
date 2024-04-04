package com.itwill.loop14;

import java.util.Scanner;

public class LoopMain14 {

	public static void main(String[] args) {
		//산생님이랑
		boolean run = true; // 프로그램을 계속 실행할 지 종료할 지를 결정하기 위한 변수
		int balance = 0; //은행 계좌의 잔고를 저장하기 위한 변수

		Scanner scanner = new Scanner(System.in); //콘솔 입력을 위해.

		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menu = scanner.nextInt();
			
			switch (menu) { //break를 만날때까지 실행.
			case 1 :
				System.out.print("예금 >> ");
				int deposit = scanner.nextInt();
				balance +=deposit;
				System.out.printf("입금 : %d, 잔고 : %d\n",deposit,balance);
				break;
			case 2 : 
				System.out.print("출금 >> ");
				int withdraw = scanner.nextInt(); //굳이 다른 변수 안 해도 됨
				balance -=withdraw;
				System.out.printf("출금 : %d, 잔고 : %d\n",withdraw,balance);
				break;
			case 3:
				System.out.printf("잔고 >> %d\n",balance);
				break;
			case 4:
				System.out.println();
				run = false; //while 문을 종료하기 위한 조건 변경.
				break; // switch 문장을 종료.
			default:
				System.out.println("잘못된 입력입니다.");
				
			}
		}
		
		System.out.println("프로그램 종료");
		
		
		
		
		
		
		/* 내가혼자
		boolean run = true; //프로그램 실행
		int balance = 0; // 통장 잔고

		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("------------------------------------");
			System.out.print("선택> ");
			int scan = scanner.nextInt();
			
			switch (scan) {
			case 1 :
				System.out.print("예금액>");
				int in = scanner.nextInt();
				balance += in;
				break;
				
			case 2 :
				System.out.print("출금액>");
				int out = scanner.nextInt();
				balance -=out;
				break;
				
			case 3 : 
				System.out.printf("잔고>%d",balance);
				break;
			}
			System.out.println();
			if (scan == 4) {
				run = false;
			}
			

		}
		System.out.println("프로그램 종료");
		*/
	}

}
