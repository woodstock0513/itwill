package com.itwill.variable03;

public class VariableMain03 {

	public static void main(String[] args) {
		//변수를 사용할 때 주의할 점 : 같은 이름으로 변수 두 번이상 선언 불가
		int x = 1; //정수를 저장할 수 있는 변수 x 선언, 1로 초기화. 4byte정수
		System.out.println("x = "+x);
		x=3;//이미 선언된 변수 값 변경.
		System.out.println("x = "+x);
		
		//int x=5; -> 변수 x가 이미 선언되어 있으므로 재선언 불가~
		
		
	}

}
