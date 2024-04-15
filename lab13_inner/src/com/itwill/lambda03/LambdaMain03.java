package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Stream 클래스 & 메서드 //입출력 스트림과 헷갈리지 말 것.
		Random rand = new Random();

		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numbers.add(rand.nextInt(100));
		}
		System.out.println(numbers);

		// numbers의 원소들 중에서 짝수들만 선택(필터링)한 새로운 리스트를 만들고 출력
		ArrayList<Integer> evens = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (numbers.get(i) % 2 == 0) {
				evens.add(numbers.get(i));
			}
		}
		System.out.println(evens);

		List<Integer> evens2 = numbers.stream().filter((x) -> x % 2 == 0).toList();
		System.out.println(evens2);

		// Stream을 사용해서 numbers의 원소 중 홀수들만 선택한 리스트를 만들고 출력
		List<Integer> odds = numbers.stream().filter((x) -> x % 2 == 1).toList();
		System.out.println(odds);

		// Stream을 사용해서 numbers의 원소의 제곱을 저장하는 리스트를 만들고 출력
		List<Integer> squares = numbers.stream().map((x) -> x * x).toList();
		System.out.println(squares);

		// Stream을 사용해서 numbers의 원소들 중 홀수들의 제곱을 저장하는 리스트를 만들고 출력
		List<Integer> oddSquares = numbers.stream().filter((x) -> x % 2 == 1).map((x) -> x * x).toList();
		System.out.println(oddSquares);
		
		//위와 똑같은 내용, but 코드가 더 길다.
		List<Integer> result = new ArrayList<>();
		for (Integer i : numbers) {
			if (i % 2 == 1) {
				result.add(i * i);
			}
		}
		System.out.println(result);
		
		
		List<String> lang = Arrays.asList("java","kotlin","c","python", "javascript");
		
		//lang의 원소들 중 문자열 길이 5글자 이상인리스트
		List<String> five = lang.stream().filter((s)-> (s.length())>=5).toList();
		System.out.println(five);
		
		//lang의 문자열을 대문자로 변환한 리스트
		List<String> upper = lang.stream().map(s->s.toUpperCase()).toList();
		System.out.println(upper);
		
		//lang의 원소들 중 문자열 길이 5글자 이상인 원소들을 대문자로 변환한 리스트
		List<String> fiveUpper = lang.stream().filter((s)-> s.length()>=5).map(s->s.toUpperCase()).toList();
		
//		List<String> fiveUpper = lang.stream().filter((s)-> s.length()>=5).map(String ::toUpperCase).toList();//메서드 참조 람다.
		
		System.out.println(fiveUpper);
		
		//람다 : (파라미터 선언) -> 리턴값
		//메서드 참조를 사용한 람다 표현식
		//(1) 람다의 리턴값이 그 아규먼트에서 "파라미터가 없는 메서드"를 호출한 경우
		//   x->x.toUpperCase()
		//   String ::toUpperCase   //메서드 참조 람다.
		//(2) 람다의 아규먼트를 1개만 갖고, 
		// 람다의 구현부가 메서드 1개 호출이고, 그 메서드가 람다의 아규먼트를 전달받는 경우:
		//   x-> System.out.println(x)
		//   System.out::println
		
		lang.forEach((x)-> System.out.println(x));
		lang.forEach(System.out::println); //메서드 참조 람다.
		
	}

}
