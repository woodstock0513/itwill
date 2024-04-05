package com.itwill.list01;

import java.util.ArrayList;

// Collection<E> //원소타입 명시해야함
//  |__ List<E>
//	   	|__ArrayList<E>, LinkedList<E>
//	리스트(List)의 특징 :
// 1. 값들을 저장(add)할 때 순서가 중요. - 인덱스를 갖는 자료구조.
// 2. 값들을 저장할 때 마다, index는 자동으로 증가. (index는 0부터 시작)
// 3. 리스트 중간에 있는 값을 삭제하면 index는 자동으로 재배열 됨.
// 4. 같은 값들을 여러번 저장할 수 있음. - Set<E>과 다른 점!!
// 5. List<E>에서 <E>는 리스트에 저장하는 원소(element)의 타입을 의미.
//  (주의) 원소 타입은 클래스 이름만 사용 가능. 기본 타입을 사용할 수 없음!!
//         -> Wrapper class가 필요한 이유! ㅎㅎ

// ArrayList<E>의 특징:
// 1.배열을 이용한 리스트 -> 값들이 연속된 메모리 공간에 저장.
// 2. 값을 저장(add), 삭제(remove)하는 속도가 느림
// 3. 검색(get)하는 속도는 빠름

// LinkedList<E>의 특징
// 1. linked list 알고리즘을 이용한 리스트. - 이전/이후 노드의 주소를 저장하는 알고리즘
// 2. 값을 저장(add), 삭제(remove)하는 속도가 빠름
// 3. 검색(get)하는 속도는 느림

public class ListMain01 {

	public static void main(String[] args) {
		// 정수들을 저장하는 ArrayList를 생성
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		// <> 안에는 무조건 클래스가 들어가야함.!!! 생성자 호출시에는 내용물 생략 가능. 선언할땐 필수
		// -> 생성자 호출에서는 ArrayList의 원소 타입을 생략할 수 있음.

		// ArrayList에 저장된 원소 개수
		System.out.println("size = " + numbers.size()); // 처음엔 비어잇음. size = 0
		System.out.println(numbers); // 원소가 하나도 없으면 그냥 []로 출력.

		// ArrayList에 정수들을 저장. add 사용
		numbers.add(1); // Integer 자리에 int 넣음. auto boxing 이용한것!
		numbers.add(100);
		numbers.add(-5);

		System.out.println("size = " + numbers.size());// 추가할때마다 size가 늘어남!!

		// ArrayList에 저장된 원소(값) 가져오기
		System.out.println("[1] = " + numbers.get(1));
		System.out.println("[2] = " + numbers.get(2));

		// 반복문 이용
		for (int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i) + " ");
		}
		System.out.println();

		for (Integer i : numbers) { // int i 로 해도 됨. (언박싱)
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println(numbers); // toString 오버라이드!!!! 걍 출력하면댐

		// ArrayList의 원소 삭제
		numbers.remove(1); // remove(int index): 해당 인덱스의 원소 삭제
		System.out.println(numbers);

		numbers.remove(Integer.valueOf(1)); // int와 Integer를 구분해야. 아규먼트가 객체이기 때문!!!
		// remove(Object x) : 같은 값의 원소의 지운다. Integer!! equals로 비교함 (메서드가해줌 걱정ㄴㄴ) 타입만 잘
		// 맞춰서 적을 것.
		System.out.println(numbers);

	}

}
