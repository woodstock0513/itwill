package com.itwill.method04;

import java.util.Random;

public class MethodMain04 {

	public static void main(String[] args) {
		// 다양한 리턴 타입
		
		
		Random random = new Random();
		
		int number = random.nextInt(100);//파라미터에 할당
		
		System.out.println(number);
		
		// Ex 1. isEven(정수) : 정수가 짝수이면 true, 그렇지 않으면 false를 리턴
		boolean result = isEven(number);
		System.out.println("isEven = "+result);
		
		// Ex2.
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        System.out.println("x=" + x + ", y=" + y);
        
        int big = whoIsBig(x, y); // x, y 중 크거나 같은 수를 리턴.
        System.out.println("big=" + big);
        
        // Ex3.
        int code = random.nextInt(1, 5);
        String gender = parseGenderCode(code); // 1 또는 3이면 "male", 2 또는 4이면 "female", 그 이외에는 "unknown"
        System.out.println("code=" + code + ", gender=" + gender);
		
	} 
	
	/**
	 * 입력받은 정수가 홀수인지 짝수인지 판단하는 메서드이다.
	 * @param x 정수이다.
	 * @return 짝수면 true, 홀수면 false
	 */
	public static boolean isEven(int x) {
//		1안
//		if (x%2==0) {
//			return true;
//		} else {
//			return false;
//		}
//		2안
//		boolean result =  false; //리턴값으로 사용할 변수 만들고 기본값으로 초기화
//		if (x%2==0) {  //기능 코드가 길어질 때 return값을 바로 반환하다 보면 오류 발생 가능성 높아짐.
//			result = true;
//		}else {
//			result = false;
//		}
//		return result; //리턴값은 한번만 실행됨.
//		3안
		return (x%2==0) ? true : false;  //한줄컷 
		
	}
	/**
	 * 두 수 x와 y중에서 크거나 같은 수를 리턴
	 * @param x 크기를 비교할 정수
	 * @param y 크기를 비교할 정수
	 * @return x가 더 크면 x를, y가 더 크면 y를 반환한다.
	 */
	public static int whoIsBig (int x, int y) {
//		if (x>=y) {
//			return x;
//		} else {
//			return y;
//		}
		return (x>=y) ? x : y;
	}
	/**
	 * 성별 코드(정수)를 문자열로 변환해서 리턴.
	 * @param x 성별 코드. 1~4 사이.
	 * @return 코드값이 1 또는 3이면 "male" / 2또는 4이면 "female"을 반환한다.
	 * 만약 그 이외의 코드값인 경우에는 "unknown"을 리턴.
	 */
	public static String parseGenderCode(int x) {
//		if (x==1||x==3) {
//			return "male";
//		} else if (x==2||x==4) {
//			return "female";
//		} else {
//			return = "unknown";
//		}
		String result = ""; //반환값을 저장하기 위한 변수
		switch (x) { 
		case 1:
		case 3:
			result = "male";
			break;
		case 2:
		case 4:
			result ="female";
			break;
		default :
			result = "unknown"; 
		}
		return result;
	}

}
