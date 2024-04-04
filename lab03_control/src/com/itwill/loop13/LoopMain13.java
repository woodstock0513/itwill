package com.itwill.loop13;

public class LoopMain13 {

	public static void main(String[] args) {

		/*
		 * 교재 연습문제 5 출력 결과
		 *
		 **
		 ***
		 ****
		 */
		System.out.println("연습 5번");

		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

		/*
		 * 교재 연습문제 6 출력 결과
		 *
		 **
		 ***
		 ****
		 */
		System.out.println("연습 6번");
		for (int i = 1; i < 5; i++) {
			; // 열 (아래로)
			for (int j = 4; j > 0; j--) { // 행 (옆으로)
				if (i < j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}

		for (int i = 4; i > 0; i--) {
			for (int j = 1; j < 5; j++) {
				if (i > j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}

		System.out.println("연습 6-2");
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (j <= 4 - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();

		}
		for (int x = 1; x < 5; x++) {
			for (int y = 1; y <= 4 - x; y++) {
				System.out.print(" ");
			}
			for (int y = 1; y <= x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
