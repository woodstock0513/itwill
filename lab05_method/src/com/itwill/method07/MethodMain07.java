package com.itwill.method07;

public class MethodMain07 {

	public static void main(String[] args) {
		// 가변길이 인수 (variable length arguement)
		// 메서드의 아규먼트 개수가 미리 정해져 있지 않은 경우
		// 메서드를 호출할 때 마다 아규먼트 개수가 달라질 수 있음.
		// ex) printf
		System.out.printf("hello\n"); //argument 1개
		System.out.printf("hello,%s\n", "오쌤"); //아규먼트 2개 (쉼표 구분)
		System.out.printf("%d x %d = %d\n",4,3,12); //argument 4개
		// 메서드 형식 한 가지 !
		
		int total = addAll();
		System.out.println(total);
		
		total = addAll(1,100);
		System.out.println(total);
		
		total = addAll(1,8,2,3,5,7);
		System.out.println(total);
		
		System.out.println(calculate("+"));
		System.out.println(calculate("+",2,4,6,10));
		System.out.println(calculate("*",2,4));
	}
	
	// 가변 길이 인수를 갖는 메서드를 선언하는 방법 : 
	// 가변 길이 인수를 저장하는 파라미터는 "변수 타입 ... 변수이름"으로 선언.
	// 가변 길이 인수는 메거드 안에서 배열처럼 취급. 
	// - 가변길이 인수는 length 속성이 있고 for문, 향상된 for문 사용 가능
	// 가변 길이 인수를 저장하는 파라미터는 반드시! 마지막 파라미터여야 한다!!
	// 가변 길이 인수를 저장하는 파라미터는 2개 이상 있을 수 없음!
	
	// 사용할 때..
	// 가변 길이 인수를 갖는 메서드를 호출할 때는 아규먼트 개수의 제한이 없음.
	// - 아규먼트를 전달하지 않아도 됨

	public static int addAll(int ...args) { //05의 int [] 배열이랑 비슷하지만 다름. (호출할때 다름)
		System.out.println("length = "+ args.length); // 가변길이인수는 배열처럼 렝쓰 속성을 가지고 있다.
		int result=0;
		for (int x : args) { //배열이랑 똑같이
			result += x;
		}
		return result;
	}
	
	/**
	 * calculate
	 * op의 값이 "+"인 경우에는 가변길이 인수 values에 합을 리턴. values가 없으면 0을 리턴.
	 * op의 값이 "*"인 경우에는 가변길이 인수 values에 곱을 리턴. values가 없으면 1을 리턴.
	 * op의 값이 "+"나 "*"가 아니면 0을 리턴.
	 * @param op : 연산자. "+" or "*".
	 * @param values : 가변길이 인수. 정수(int). 
	 * @return values들의 합이나 곱.
	 */
	public static int calculate (String op, int ...values ) { //가변길이인수는 반드시!! 마지막 파라미터. 저 values가 이름!
		int result = 0;
//		if (op=="+") {  //switch 도 가능~
//			for (int i : values) {
//				result += i;
//			}
//		} else if (op=="*") {
//			result = 1;
//			for (int i : values) {
//				result *= i;
//			}
//		} else {
//			result = 0;
//		}
//		return result;
		
		switch (op) {
		case "+":
			for (int i : values) {
				result += i;
			}
			break;
		case "*":
			result = 1;
			for (int i : values) {
				result *= i;
			}
			break;
		}
		return result;
	}
	
}