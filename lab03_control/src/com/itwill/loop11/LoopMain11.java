package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		// Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력
		int sum=0; //1~10 자연수의 합을 저장할 변수
		int i = 1;
		do {
			sum = sum+i;
			i++;
		} while (i<11);
		System.out.println("do while : "+sum);
		sum=0;
		i=1;
		while (i<11) {
			sum = sum+i;
			i++;
		}
		System.out.println("while : "+sum);
		sum=0;
		
		for (i=1;i<11;i++) {
			sum+=i;
		}
		System.out.println("for : "+sum);
		
		//Ex2. 1부터 100까지의 자연수들 중에서 짝수들의 합을 계산하고 출력
		sum=0;
		i=0;
		do {
			if (i%2==0) {
				sum = sum+i;
			}
			i++;
		} while (i<101);
		System.out.println("do while : "+sum);

		sum=0;
		i=0;
		while (i<101) {
			if (i%2==0) {
				sum +=i;
			}
			i++;
		}
		System.out.println("while : "+sum);
		sum=0;
		
		for (i=0;i<101;i=i+2) {
			sum+=i;
		}
		System.out.println("for : "+sum);
		
		//Ex3. 1부터 100까지의 자연수들 중에서 홀수들의 합을 계산하고 출력
		sum=0;
		i=1;
		do {
			if (i%2==1) {
				sum = sum+i;
			}
			i++;
		} while (i<101);
		System.out.println("do while : "+sum);
		sum=0;
		i=1;
		while (i<101) {
			sum+=i;
			i+=2;
		}
		System.out.println("while : "+sum);
		
		sum=0;
		
		for (i=1;i<101;i+=2) {
			sum += i;
		}
		System.out.println("for : "+sum);
		

	}

}
