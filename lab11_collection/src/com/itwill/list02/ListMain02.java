package com.itwill.list02;

import java.util.LinkedList;

public class ListMain02 {

	public static void main(String[] args) {
		//문자열을 저장하는 LinkedList 객체 생성
		LinkedList<String> lang = new LinkedList<>();
		System.out.println(lang.size()); //length 아님 주의!!!!
		System.out.println(lang);
		
		lang.add("java");
		lang.add("java script");
		
		System.out.println("size = "+lang.size());
		System.out.println(lang);
		System.out.println(lang.get(1));
		
		lang.remove(1); //인덱스 위치의 값 삭제
		System.out.println(lang);
		
//		lang.remove("java"); // 같은 값의 원소를 찾아서 삭제
//		System.out.println(lang);
		
		lang.set(0, "JAVA");
		System.out.println(lang);

	}

}
