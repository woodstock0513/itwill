package com.itwill.loop14;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
//		Scanner를 사용한 콘솔 입력:
//		nextInt(): 입력 버퍼 (임시 메모리)에서 공백문자(스페이스,탭,엔터)로 구분된 입력값을 읽어서 int 타입 정수를 반환
//		읽은 값까지만 입력 버퍼를 지움. -> 그니까 사실은 공백문자는 안 지워짐. 빈칸,엔터 이런건 남아잇듬..
//		nextdouble() : 입력 버퍼에서 공백 문자로 구분된 입력값을 읽어서 double 타입 실수를 반환. 읽은 값까지만 입력 버퍼를 지움.
//		next(): 입력 버퍼에서 공백문자로 구분된 입력값을 읽어서 문자열(스트링)을 반환. 읽은 값까지만 입력 버퍼를 지움. 
//		요 애들은 버퍼에 정보 남아있으면 그걸 읽음
//		nextLine(): 입력 버퍼에서 엔터를 만날 때까지 모든 값을 읽어서 문자열을 반환
//		nextLine()을 호출하면 입력 버퍼의 모든 내용이 지워짐!!!
//		근데 문제. 위의 엔터를 지가 읽음..
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하시오. ");
		int num = scanner.nextInt(); //엔터를 치면 입력이 끝남.
		System.out.println("입력한 정수 : "+num);
		
		System.out.print("정수를 입력하시오. ");
		num = scanner.nextInt(); //엔터를 치면 입력이 끝남.
		System.out.println("입력한 정수 : "+num);
		
		System.out.print("이름을 입력하시오. ");
		String name = scanner.next();
		System.out.println("입력한 이름 : "+name);
		
		System.out.print("이메일을 입력하시오. ");
		String mail = scanner.next();
		System.out.println("입력한 메일 : "+mail);
		
		scanner.nextLine(); //입력 버퍼에 남아있는 값을 읽고 버퍼를 지움.
		
		System.out.print("문자열을 입력하시오. ");
		String str = scanner.nextLine();
		System.out.println(str);
		
//		nextLine으로 읽은 값을 정수로 변환 -> Integer.parseInt 사용!
//		nextLine으로 읽은 값을 실수로 변환 -> Double.parseDouble 사용!
		
		System.out.print("정수를 입력하시오. ");
		num = Integer.parseInt(scanner.nextLine());
		System.out.println("입력한 정수 : "+num);
		
		System.out.print("실수를 입력하시오. ");
		double x = Double.parseDouble(scanner.nextLine());
		System.out.println("입력한 실수 : "+ x);
		
		System.out.print("문자열을 입력하시오. ");
		str = scanner.nextLine();
		System.out.println(str);
	}

}
