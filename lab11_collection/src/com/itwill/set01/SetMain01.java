package com.itwill.set01;

import java.util.HashSet;
import java.util.TreeSet;

//Collection<E>
//|__List<E>
//   	|__ArrayList<E>, LinkedList<E>, ... - index 사용. 같은 값 여러개 저장 가능
//
//Collection<E>
//|__Set<E>
//    |__HashSet<E>, TreeSet<E>, ...
//
// Set<E>의 특징: (Hash, Tree의 공통 특징~)
//(1) 중복된 값((equals)가 true인 값)을 저장하지 못함. 예 {1,2,2,3,3,3,} = {1,2,3}
//(2) 저장하는 순서가 중요하지 않음. - 인덱스가 없음!!
//HashSet<E> : Hash 알고리즘(검색을 빠르게 하기 위한 알고리즘)을 사용한 집합(Set) - 해쉬 오버라이딩 중요한 이유.
//비슷한 애들끼리 모아둠. 모으는 기준은 정하기 나름.
//TreeSet<E> : Tree 알고리즘(정렬을 빠르게 하기 위한 알고리즘)을 사용한 집합(Set)
//저장할 때마다 원래 있는 값과 비교하면서 저장.

public class SetMain01 {

	public static void main(String[] args) {
		// 정수를 저장할 수 있는 TreeSet을 선언, 초기화
		TreeSet<Integer> numbers = new TreeSet<>();
		System.out.println(numbers);
		System.out.println(numbers.size());

		// Set에 원소들 저장.
		numbers.add(2);
		numbers.add(100);
		numbers.add(50);
		numbers.add(30);
		numbers.add(50); // 중복 저장 안됨.

		System.out.println(numbers);
		System.out.println(numbers.size());

//		Set<E>.get(index) 메서드를 제공하지 않음! 전체를 다 출력해야 위치 확인 가능
//		for (int i = 0; i<members.size();i++) 형식의 for문 사용 불가. 향상된 for문장은 사용 가능
		for (Integer x : numbers) {
			System.out.print(x + " ");
		}
		System.out.println();
		
//		Set<E>.set(int index, E value) 메서드를 제공하지 않음!! get, set다 안 됨.
//		Set<E>.remove(int index) 메서드를 제공하지 않음!
//		Set<E>.remove(Object obj) 메서드만 제공 - 값을 비교(equals)해서 같은 값의 객체를 제거
		numbers.remove(50);
		
		System.out.println(numbers);
		
		//문자열을 저장하는 HashSet을 선언하고 초기화
		HashSet<String> set = new HashSet<>();
		System.out.println(set);
		System.out.println(set.size());
		set.add("aaa");
		set.add("hello");
		set.add("hello");
		System.out.println(set);
		System.out.println(set.size());
		

	}

}
