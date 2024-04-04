package com.itwill.condition04;

public class ConditionMain04 {

	public static void main(String[] args) {
		//중첩 조건문 : if 블럭 또는 else 블럭 안에 또다른 조건문이 있는 경우
		int num=-5;
		
		if (num>0) {
			System.out.println("positive");
		} else {
			if (num==0) {
				System.out.println("zero");
			}
			else {
				System.out.println("negative");
			}
		}
	}

}
