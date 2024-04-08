package com.itwill.set03;

import java.util.HashSet;

public class SetMain03 {

	public static void main(String[] args) {
		// Score 타입을 저장할 수 있는 HashSet을 선언, 초기화
		HashSet<Score> scores = new HashSet<>();
		System.out.println(scores);
		
		//scores에 Score객체들을 저장.
		scores.add(new Score());
		scores.add(new Score(0,0,0));
		scores.add(new Score(1,5,3));
		scores.add(new Score(5,1,3)); //hashcode가 같지만 equals가 false
		
		System.out.println(scores);

	}

}
