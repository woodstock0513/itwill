package com.itwill.loop03;

public class LoopMain03 {

    public static void main(String[] args) {
        /* Ex1. 아래와 같이 구구단 2단을 출력하세요.
            2 x 1 = 2
            2 x 2 = 4
            2 x 3 = 6
            ...
            2 x 8 = 16
            2 x 9 = 18
        */
    	for (int i= 1 ; i<10 ; i++) {
    		System.out.println("2 x "+i+" = "+2*i);
    		//System.out.printf("2 x %d = %d\n",i,2*i);
    	}
    	
    	System.out.println();

        /* Ex2. 아래와 같이 1 ~ 100 숫자를 한 줄에 10개씩 출력하세요.
            1     2     3     4     5     6     7     8     9     10
            11    12    13    14    15    16    17    18    19    20
            21    22    23    24    25    26    27    28    29    30
            31    32    33    34    35    36    37    38    39    40
            ...
            81    82    83    84    85    86    87    88    89    90
            91    92    93    94    95    96    97    98    99    100
        */
    	
    	
    	for (int i =1 ; i<101; i++) {
    		System.out.print(i+"\t"); //숫자 한 줄에 출력
    		if (i%10==0) {
    			System.out.println(); //줄바꿈
    		}
    	}
    	
    	System.out.println();
    	
    	for(int i = 0; i<10 ; i++) { //십의자리
    		for (int j = 1 ; j<=10 ; j++) {  //일의자리
    			System.out.printf("%-4d",(i*10+j));
    		}
    		System.out.println();
    	}
    	
    	System.out.println();
    	
        for (int i = 1; i<=10 ; i++) { //일의자리
        	for (int j=0 ; j<10;j++) { //십의자리
        		System.out.printf("%-4d",j*10+i);
        	}
        	System.out.println();
        }
    }

}