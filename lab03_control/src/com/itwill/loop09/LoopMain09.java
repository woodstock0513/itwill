package com.itwill.loop09;

public class LoopMain09 {

	public static void main(String[] args) {
		// 중첩 while 문장을 사용해서 구구단 1단부터 12단까지
		int x = 1;
		
		while (x<13) {
			int y = 1;
			System.out.printf("-----%d단-----\n",x);
			while (y<13) {
				System.out.printf("%d x %d = %d\n",x,y,x*y);
				y++;
				
			}
			x++;
			
		}

	}

}