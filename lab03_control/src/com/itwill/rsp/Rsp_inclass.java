package com.itwill.rsp;

import java.util.Random;
import java.util.Scanner;

public class Rsp_inclass {

	public static void main(String[] args) {
		Random rand = new Random();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
        
        int user = scan.nextInt();
        
        System.out.println("User : "+user);
        
        int comp = rand.nextInt(3);
        
        System.out.println("Computer : "+comp);
        
        int result=user-comp;
        
        /*
        if (result == 0) {
        	//tie
        } else if (result == 1 || result == -2) {
        	//user win
        } else {
        	//comp win
        }
        */
        
        
        
        /*
        if (user==comp) {
        	//비김
        } else if ((user==0&&comp==2)||(user==1&&comp==0)||(user==2&&comp==1)) {
        	//user 이김
        } else {
        	//computer 짐
        }
        */
        
        
        
        
        /*
        if (user==comp) {
        	//tie
        } else if (user==0) {
        	//이기고 지고
        } else if (user==1) {
        	//이기고지고
        } else if (user==2) {
        	//이기고지고
        }
        */
        
        
        /*
        if (user==0) {
        	if (comp ==0) {
        		System.out.println("Tie");
        	} else if (comp==1) {
        		System.out.println("Computer Win");
        	} else if (comp==2) {
        		System.out.println("User Win");
        	}
        } else if (user==1) {
        	if (comp ==0) {
        		System.out.println("User Win");
        	} else if (comp==1) {
        		System.out.println("Tie");
        	} else if (comp==2) {
        		System.out.println("Computer Win");
        	}
        } else if (user==2) {
        	if (comp ==0) {
        		System.out.println("Computer Win");
        	} else if (comp==1) {
        		System.out.println("User Win");
        	} else if (comp==2) {
        		System.out.println("Tie");
        	}
        }
        */
        
        
	}

}
