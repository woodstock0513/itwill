package com.itwill.modifier04;

import com.itwill.modifier05.PublicClassEx;

public class ModifierMain04 {

	public static void main(String[] args) {
		// PublicClassEx 타입 객체 생성
		PublicClassEx ex = new PublicClassEx(); //Ctrl + space 간단하게 import 가능. 다른 패키지 안에 있는 거라 import 필수 
		System.out.println(ex);
		
		
//		com.itwill.modifier05.PackageClassEx ex2; // 컴파일 에러. not visible
	}

}


class A {}
