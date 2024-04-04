package com.itwill.method05;

public class MethodMain05 {

	public static void main(String[] args) {
		// TODO 메서드 호출, 그 결과를 출력
		// sum 호출, 출력
		
		int [] array = {-5,7,0,4,5}; //아규먼트로 기능

		System.out.println("sum = "+sum(array));

		System.out.println("mean = "+mean(array));
		
		System.out.println("max = "+max(array));

		System.out.println("min = "+min (array));
	}
	
	
	/**
	 * sum.
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 리턴.
	 * @param array : 정수들의 1차원 배열 (int[])
	 */
	public static int sum (int[] array) {
		int summ=0; //sum으로 선언해도 됨. 지역변수라서 ㄱㅊ
		for (int i =0; i<array.length;i++) {  // 이것도 향상된 for문으로 가능.
			summ+=array[i];
		}
		return summ;
	}
	
	/**
	 * mean
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들의 평균을 리턴
	 * @param array : 정수들의 1차원 배열
	 * @return  array 원소들의 평균을 double 타입으로 리턴.
	 */
	public static double mean (int[] array) { // 파라미터 있든 없든 괄호는 필수!!
		double res;
		res = (double) sum(array)/array.length; //메서드는 어디서든 호출 가능~
		return res;
	}
	
	/**
	 * max
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최댓값을 리턴.
	 * @param array : 정수들의 1차원 배열
	 * @return array 원소들 중 최댓값. 
	 */
	public static int max (int[] array) {
		int M = array[0];
		for (int i : array) {
			if (M <= i) {
				M=i;
			}
		}
		return M;
	}
	
	/**
	 * min
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최솟값을 리턴.
	 * @param array : 정수들의 1차원 배열
	 * @return array 원소들 중 최솟값. 
	 */
	public static int min (int[] array) {
		int m = array[0];
		for (int i : array) {
			if (m >= i) {
				m=i;
			}
		}
		return m;	
	}

	
}
