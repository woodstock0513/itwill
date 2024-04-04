package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

    public static void main(String[] args) {
        // 과제:
        // 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
        // 배열에 0이상 10이하 난수 5개를 저장.
    	// 배열 원소들을 출력
        // 배열 원소들 중 최댓값을 찾아서 출력.
        // 배열 원소들 중 최솟값을 찾아서 출력.
    	
    	//선생님코드
    	int [] numbers = new int [5];
    	Random random = new Random();
    	for (int i = 0 ; i<numbers.length ; i++) {
    		numbers [i] = random.nextInt(11);
    	}
    	
    	for (int i : numbers) {
    		System.out.print(i + " ");
    	}
    	System.out.println();
    	
    	int max = numbers[0]; //배열의 첫번째 원소를 최댓값이라고 가정.
    	for (int x : numbers) { //배열의 모든 원소를 순서대로 하나씩 반복.
    		if (x > max) {  //배열에서 꺼낸 값이 (현재까지의) 최댓값보다 크다면
    			max = x;  //최댓값을 배열에서 꺼낸 값으로 변경
    		}
    	}
    	
    	System.out.println("max = "+max);
    	
    	int min = numbers[0]; //이거 말고 큰 숫자로 둬도 됨. 10이상이어야.
    	
    	for (int x : numbers) {
    		if (x < min) {
    			min = x;
    		}
    	}
    	System.out.print("min = "+min);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*
    	내가한거
    	int [] nums = new int[5];
    	Random rand = new Random();

    	for (int i = 0; i<nums.length;i++) {
    		nums[i] = rand.nextInt(10);
    	}
    	
    	for (int i : nums) {
    		System.out.print(i+" ");
    	}
    	System.out.println();
    	
    	int max = nums[0];
    	int min = nums[0];
    	
 
    	for (int i = 0; i<nums.length; i++) {
    		if (max>=nums[i]) {
    			continue;
    		} else {
    			max = nums[i];
    		}
    		
    	}
    	System.out.println("최댓값 : "+max);
    	
    	for (int i = 0; i<nums.length;i++) {
    		if (min<=nums[i]) {
    			continue;
    		} else {
    			min = nums[i];
    		}
    	}
    	System.out.println("최솟값 : "+min);
    	*/
    }

}