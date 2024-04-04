package com.itwill.modifier03;

public class Person {
	private String name; // 읽기 전용 필드
	private int age; // 읽기 쓰기 필드

	public Person(String name, int age) {
		if (name != null && age>0) {
			this.age = age;
			this.name = name;
		} else {
		System.out.println("이름, 나이 필수. 나이는 1이상.");
			throw new IllegalArgumentException();
		}
	}

	// getter
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	// setter
	public void setAge(int age) {
		if (age>0) {
		this.age = age;
		} else {
			System.out.println("나이는 1살 이상입니다.");
			throw new IllegalArgumentException();
		}
	}
}


