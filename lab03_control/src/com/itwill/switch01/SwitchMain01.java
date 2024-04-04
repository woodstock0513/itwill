package com.itwill.switch01;

public class SwitchMain01 {

	public static void main(String[] args) {
		// switch - case 구문 : 
		// 해당 case 위치로 이동하여 break; 문장을 만날때까지 실행.
		// 해당하는  case가 없으면 default 블럭을 실행.
		// deafult 블럭은 switch 구문 중 가장 마지막에 작성해야. 없어도 ㄱㅊ
		//switch case(변수 or 식)에서 사용 가능한 타입
		//정수(byte, short, int, long, char), 문자열(String), enum 타입
		
		String season  = "fall";
		switch (season) {
		case "spring" : 
			System.out.println("봄");
			break; //switch 구문을 나가라. break가 들어가있는 중괄호 블럭 끝내기
		case "summer" :
			System.out.println("여름");
			break;
		case "fall" :
			System.out.println("가을");
			break;
		case "winter" :
			System.out.println("겨울");
			break;
		default : 
			System.out.println("몰라요");
		}
		
		int num = 5;
		switch (num%2) {
		case 1:
			System.out.println("odd");
			break;
		case 0 : //default 이용 가능.
			System.out.println("even");
			break; //사실 필요 X
		}
	

	}

}