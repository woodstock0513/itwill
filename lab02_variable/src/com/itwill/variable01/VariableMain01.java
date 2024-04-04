package com.itwill.variable01;

public class VariableMain01 {

	public static void main(String[] args) {
		//변수(베리어블):프로그램에서 필요한 데이터를 저장하는 메모리 공간
		//변수 사용
		//1. 변수 선언 : 저장하는 데이터의 종류(타입=자료형)과 변수 이름 선언
		//2. 변수 초기화 : 변수의 값을 처음 저장하는 것.
		int age; //integer 선언문
		age = 23; //변수 age의 값을 23으로 초기화 = age에 정수 23 저장
		System.out.println("나이 = "+age);
		
		int x = 20; //변수 선언과 동시에 초기화
		System.out.println("x는"+ x);
		
		//Java의 기본 데이터 타입 - 논리,숫자
		//정수 타입: byte,short,*int*,long,char - 숫자의 크기 diff
		//실수 타입: float,*double*  더블이 좀 더 정밀(소수점 뒷자리 & 수의 크기 diff)
		//논리 타입: boolean - true, false
		
		long c = 5_452_134_654L;
		double d = 2135465652.0132465132;
		System.out.println(c+d);
		
		boolean a=true;
		System.out.print(a);
		
		//변수 이름 작성 시 주의할 점
		//1. 알파벳, 숫자, _, $ 만 사용
		//2. 대소문자 구분!!
		//3. 이름 처음에 숫자로 시작 불가
		//4. 자바 키워드(예약어)는 사용 불가! EX) int,float 이런것들
		
		//관습적인 주의사항 - 변수 역할에 어울리는 "의미있는" 단어를 사용하여 만드는 것을 권장.
		//2개 이상의 단어를 붙여서 만들 경우에는 "소문자"로 시작하는 camel 표기법 권장. ex)userId, userPassword
		//snake 표기법. user_id, user_password. 단어 사이를 _로 연결 - 파이썬에서 사용
	}

}
