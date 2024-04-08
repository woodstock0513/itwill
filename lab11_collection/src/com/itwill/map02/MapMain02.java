package com.itwill.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

	public static void main(String[] args) {
		// 문자열을 key로 하고 정수를 value로 하는 TreeMap을 선언, 초기화
		TreeMap<String, Integer> menu = new TreeMap<>(); //자주 쓰이는 형태! 과목점수,메뉴가격
		
		//데이터 저장
		menu.put("짜장면", 7000);
		menu.put("짬뽕", 8000);
		menu.put("볶음밥", 7000); //ㄱㄴㄷ순서!!
		
		System.out.println(menu);
		
		//keySet() : TreeSet에선 오름차순 정렬된 키들의 집합 **tree라서 가능!!!!
		Set<String> keySet = menu.keySet();
		for (String k : keySet) {
			System.out.println(k+" : "+menu.get(k));
		}
		//descendingkeySet() : TreeSet에서 내림차순 정렬된 키들의 집합 **tree라서 가능!!!!
		Set<String> keySet2 = menu.descendingKeySet();
		for (String k : keySet2) {
			System.out.println(k+" : "+menu.get(k) );
		}
	}

}
