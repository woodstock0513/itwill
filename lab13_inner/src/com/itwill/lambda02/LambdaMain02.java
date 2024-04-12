package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyFilter{
	boolean test(Object x);
}

public class LambdaMain02 {
	
	public List<Object> filter(List<Object> list, MyFilter filter){
		List<Object> result = new ArrayList<>();
		for (Object x : list) {
			if (filter.test(x)) {
				result.add(x);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LambdaMain02 app = new LambdaMain02(); //filter 메서드를 호출하기 위해
		
		List<Object> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println(numbers);

		//numbers에서 홀수들만 선택(필터링)
		List<Object> odds = app.filter(numbers, new MyFilter() {
			//익명 클래스 구현 객체
			@Override
			public boolean test(Object x) {
				return (Integer)x %2==1;
			}
		});
		System.out.println(odds);
		
		
		//numbers에서 짝수들만 선택(필터링)
		List<Object> evens = app.filter(numbers, (x)->(Integer)x %2==0);
		System.out.println(evens);
		
		List<Object> lang = Arrays.asList("java","sql","html","python", "javascript");
		
		// lang의 원소들 중 문자열의 길이가 5자 이상인 원소들만 필터링
		List<Object> words = app.filter(lang, (x)->((String)x).length()>=5);
		System.out.println(words);
	}

}
