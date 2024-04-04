package com.itwill.loop04;

public class LoopMain04 {

    public static void main(String[] args) {
    	
        /* 369게임: 아래와 같이 출력하세요.
            1   2   *   4   5   *   7   8   *   10
            11  12  *   14  15  *   17  18  *   20
            21  22  *   24  25  *   27  28  *   *
            *   *   *   *   *   *   *   *   *   40
            41  42  *   44  45  *   47  48  *   50
            51  52  *   54  55  *   57  58  *   *
            *   *   *   *   *   *   *   *   *   70
            71  72  *   74  75  *   77  78  *   80
            81  82  *   84  85  *   87  88  *   *
            *   *   *   *   *   *   *   *   *   100
        */
    	
    	//10으로 나눈 나머지!!
    	//10으로 나눈 몫!!
    	
    	for (int i=1;i<101;i++) {
    		if ((i%10==3)||(i%10==6)||(i%10==9)) {  //일의자리 369
    			System.out.print("*\t");
    		} else if ((i/10==3)||(i/10==6)||(i/10==9)) { //십의자리 369
    			System.out.print("*\t");
    		} else {
    			System.out.printf("%d\t",i); //그외
    		}
    		if (i%10==0) {
    			System.out.println();
    		}
    	}
    	
    	for (int i=1;i<101;i++) {
    		int x = i%10; //i의 일의자리 수
    		int y = i/10; //i의 십의자리 수
    		boolean one = (x==3) || (x==6) || (x==9); //일의 자리수가 369
    		boolean ten = (y==3) || (y==6) || (y==9); //십의 자리수가 369
    	
    		if (one && ten) { //and 조건 먼저 해야함
    			System.out.print("**\t");
    		} else if (one || ten){
    			System.out.print("*\t");
    		} else {
    			System.out.printf("%d\t",i); //그외
    		}
    		if (i%10==0) {
    			System.out.println();
    		}
    		
    	}
    	
    }
    
}