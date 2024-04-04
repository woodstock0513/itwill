package com.itwill.rsp;

import java.util.Random;

import java.util.Scanner;

public class Rsp {

    public static void main(String[] args) {
        // 가위/바위/보 (Rock-Scissors-Paper) 게임:
        // 가위 - 0, 바위 - 1, 보 - 2
        
        // TODO: Random 타입 변수를 선언, 초기화.
    	Random rand = new Random();
        // TODO: Scanner 타입 변수를 선언, 초기화.
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
        
        // TODO: 사용자가 콘솔창에서 입력한 정수를 변수(us	er)에 저장.
        int user = scan.nextInt();
        
        // TODO: 0이상 3 미만의 정수 난수 1개를 변수(computer)에 저장.
        int computer = rand.nextInt(3);
        
        // TODO: 가위바위보 게임 결과(User win/Computer win/Tie)를 출력.
        System.out.printf("사용자는 %d을(를) 냈고, 컴퓨터는 %d을(를) 냈습니다.\n",user,computer);
        
        String userString;
        if (user ==0) {
        	userString = "가위";
        } else if (user==1) {
        	userString = "바위";
        } else {
        	userString = "보";
        }
        
        String computerString;
        if (computer ==0) {
        	computerString = "가위";
        } else if (computer==1) {
        	computerString = "바위";
        } else {
        	computerString = "보";
        }
        
        System.out.println("사용자는 "+userString+"를 냈고 컴퓨터는 "+computerString+"를 냈습니다.");
        
        if (user==computer) {
        	System.out.println("Tie");
        } else if (computer==user+1||(user==2&&computer==0) ) {
        	System.out.println("Computer Win");
        } else {
        	System.out.println("User Win");
        }
        
    }

}


/*

if (user==computer) {
	System.out.println("Tie");
} else if(computer==user+1) {
	System.out.println("Computer Win");
} else if (user==2&&computer==0) {
	System.out.println("Computer Win");
} else {
	System.out.println("User Win");
}


if (user==computer) {
	System.out.println("Tie");
} else if (user==0&&computer==1) {
	System.out.println("Computer Win");
} else if (user==1&&computer==2) {
	System.out.println("Computer Win");
} else if (user==2&&computer==0) {
	System.out.println("Computer Win");
} else {
	System.out.println("User Win");
}

//20240319
//이런식으로 중첩해서도 가능할듯
//가장 간단한 9문장 짜리도 잇음
if (user==0) {
	if (comp ==0) {
		
	} else if (comp==1) {
		
	} else {
		
	}
} else if (user==1) {
	if (comp ==0) {
		
	} else if (comp==1) {
		
	} else {
		
	}
}
*/