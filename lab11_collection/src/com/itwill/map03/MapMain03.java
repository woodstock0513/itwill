package com.itwill.map03;

import java.util.HashMap;
import java.util.TreeMap;

public class MapMain03 {

	public static void main(String[] args) {
		// 단어 개수 세기 (word counting):
		// 문자열에 등장하는 단어를 key로 하고,
		// 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고, 출력

		String sentence = "짜장면 짬뽕 짜장면 볶음밥 김치찌개 부대찌개 김치찌개 된장찌개";
		//-> 결과 : {짜=2,짬=1,볶=1 ..}
		
		//String[], Map<String,Integer>
		String[] str = sentence.split(" ");
		for (String s : str) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		//단어(key)-빈도수(value)를 저장하기 위한 map을 선언, 초기화
		HashMap<String, Integer> word = new HashMap<>();
		
		//배열에 저장된 단어들을 순서대로 하나씩 반복
		for (String s : str) {
			Integer count = word.getOrDefault(s, 0); //짜장면이라는 key를 가지고 잇는거 리턴해줘. 없으면 0
			word.put(s, count+1);
			System.out.println(word);
		}
		
		System.out.println("-------");
		HashMap<String, Integer> word2 = new HashMap<>();
		
		for (String s : str) {
			Integer count = word2.get(s);
			if(count!=null) {
				word2.put(s, count+1);
			} else { //처음 등장한 단어!!
				word2.put(s, 1);
			}
			System.out.println(word2);
		}
		
		
		
//		int i = 0;
//		while (i<str.length) {
//			int count = 0;
//			for (int j = 0 ;j<str.length;j++) {
//				if (str[i].equals(str[j])) {
//					count++;
//				}
//				word.put(str[i], count);
//			}
//			i++;
//		}
//		
		for (int x = 0; x<str.length;x++) {
			int count = 0;
			for (int y = 0; y<str.length;y++) {
				if (str[x].equals(str[y]))
					count++;
			}
			word.put(str[x], count);
		}
	

	}

}
