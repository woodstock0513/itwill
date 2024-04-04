package com.itwill.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		//반복문에서 break와 continue 문장 : 
		//break : 반복문 블럭을 실행 중에 break 문장을 만나면, break가 포함된 가장 가까운 반복문 블럭을 끝냄.
		
		for (int x = 0; x<5; x++) {
			if (x==3) {
				break; //걍 아예 끝
			}
			System.out.println(x);
		}
				
		System.out.println("------------------------");
		
		//continue : 반복문 블럭을 실행 중에 continue 문장을 만나면
		//continue 아래의 코드들은 실행하지 않고 그 다음 반복과정을 수행한다.
		
		for (int x = 0; x<5;x++) { //초기화, 조건식, 변화식 모두 생략 가능. 단, 세미콜론은 있어야.
			if (x==3) {
				continue;
			}
			System.out.println(x);
		}
		
		System.out.println("-----------------------");
		
		//break 문장의 용도 : 무한 반복문 실행 중에 특정 조건을 만족하면 반복문을 종료하고 싶을 때
		for (int x = 1;;x++) {  //조건식 생략 시 true라는 뜻. break  없으면 프로그램이 안 끝남. 무한루프
			System.out.println(x);
			if (x==10) {
				break;
			}
			
		}
		
	}

}
