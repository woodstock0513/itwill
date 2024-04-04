package com.itwill.method03;

public class MethodMain03 {

	public static void main(String[] args) {
		// 반환값이 없는 메서드 작성, 호출 연습
		countdown(10);

	}
	
	public static void countdown(int x) { //파라미터는 지역변수!
		if (x<=0) {
			System.out.println("양수를 입력하세요.");
			return; // 메서드를 끝낸다는 의미
			//return 문장의 의미
			//1) 메서드를 종료 2) return 문장에 값이 있으면 메서드를 호출한 곳으로 값을 반환.
			//void 메서드는 1)의 경우만 사용 가능. 값이 없는 return문만.
		}
		while (x>=0) {
			System.out.println(x);
			x--;
		}
		//or for문 사용.
	}

}
