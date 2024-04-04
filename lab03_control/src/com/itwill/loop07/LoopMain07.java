package com.itwill.loop07;

public class LoopMain07 {

    public static void main(String[] args) {
        // 과제: 구구단 출력하기
        // 2단은 2x2까지만, 3단은 3x3까지만, 4단은 4x4까지만, ..., 9단은 9x9까지 출력.
    	
        // (1) break 이용하기.
    	for (int i=2;i<10;i++) {
    		System.out.println("----"+i+"단----");
    		for (int j=1;j<10;j++) {
    			System.out.printf("%d x %d = %d\n",i,j,i*j);
    			if (j==i) {
    				break;
    			}
    		}
    	}

    	
    	
    	
    	
    	
    	
        // (2) break 이용하지 않기.
    	for (int i=2;i<10;i++) {
    		System.out.println("----"+i+"단----");
    		for (int j=1;j<=i;j++) {
    			System.out.printf("%d x %d = %d\n",i,j,i*j);
    		}
    	}

    }

}