package com.itwill.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		// 문자열 1차원 배열
		String[] leSserafim = {"채원", "사쿠라", "윤진", "카즈하", "은채"};
		String[] newJeans = {"혜인", "해린", "민지","하니","다니엘"};
		String[] bts = {"정국", "뷔","지민","슈가","제이홉","RM","진"};
		
		//문자열 2차원 배열
		String[][] idols = {leSserafim, newJeans,bts}; 
		
		//2차원 배열의 내용을 for문을 사용해서 출력
		for (int a=0; a<idols.length;a++) {
			for (int b=0;b<idols[a].length;b++) {
				System.out.print(idols[a][b] + " ");
			}
			System.out.println();
		}
		System.out.println();
		//2차원 배열의 내용을 향상된 for문을 사용해서 출력
		for (String[] a : idols) {
			for (String b : a) {
				System.out.printf("%s\t",b);
			}
			System.out.println();
		}

	}

}
