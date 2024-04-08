package com.itwill.list04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain04 {

    public static void main(String[] args) { // Arrays라는 녀석. asList는 스태틱 메서드. 
        List<String> names = Arrays.asList("java", "sql", "html", "css", "javascript",
                "servlet", "jsp", "spring");  //원소가 들어잇는 리스트를 바로 만들기
        
        // 1. names에서 5글자 이상인 문자열을 대문자로 변환해서 저장하는 ArrayList를 만들고 출력.
        // -> [JAVASCRIPT, SERVLET, SPRING]
        ArrayList<String> Upper = new ArrayList<>();
        for (String s : names) {
        	if(s.length()>=5) {
        		Upper.add(s.toUpperCase());
        	}
        }
        System.out.println(Upper);
        
        System.out.println("----------------------------");

        // 2. names에 저장된 문자열의 글자수들을 저장하는 ArrayList를 만들고 출력.
        // -> [4, 3, 4, 3, 10, 7, 3, 6]
        ArrayList<Integer> character = new ArrayList<>();
        for (String s : names) {
        	character.add(s.length());
        }
        System.out.println(character);
        
        System.out.println("----------------------------");
        
       
        
        // 3. codes의 원소가 0이면 "남성", 1이면 "여성"을 저장하는 ArrayList를 만들고 출력.
        List<Integer> codes = Arrays.asList(0, 1, 0, 1, 1, 0);
        ArrayList<String> gender = new ArrayList<>();
        for (int i : codes) {
        	if (i == 0) {
        		gender.add("남성");
        	} else {
        		gender.add("여성");
        	}
//        	gender.add((i==0 ? "남성" : "여성")); 로도 ㄱㄴ
        }
        System.out.println(gender);
        
        
    }

}