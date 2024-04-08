package com.itwill.map01;

import java.util.HashMap;
import java.util.Set;

import javax.print.DocFlavor.INPUT_STREAM;

//Collection<E>
//|__List<E>, Set<E>

//Map<K, V>
//|__HashMap<K,V>, TreeMap<K,V>

//Map<K, V>: 키(Key)와 값(Value)의 쌍으로 구성된 데이터를 저장하는 자료 구조
//(1) Key : 중복된 값을 가질 수 없음. Map에서 하나의 값을 찾기 위한 인덱스와 비슷한 역할
//	- 데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도
//	- 인덱스와 달리 반드시 연속된 값을 가질 필요는 없음. 정수가 아니어도 됨.
//(2)Value : 중복된 값을 가질 수 있음.
//HashMap<K,V> - Key를 기준으로 검색을 빠르게 할 수 있는 Map
//TreeMap<K,V> - Key를 기준으로 정렬을 빠르게 할 수 있는 Map

public class MapMain01 {

	public static void main(String[] args) {
		// 정수를 key로 하고, 문자열을 value로 하는 HashMap을 선언, 초기화
		HashMap<Integer, String> map = new HashMap<>();
		
		System.out.println(map);
		System.out.println(map.size());
		
		// map에 key-value 데이터를 저장.
		map.put(1, "홍길동");
		map.put(513, "ansekdud");
		map.put(816, "moon");
		
		System.out.println(map);
		
		//map에 저장된 값(value)를 찾는 메서드. get
		String value = map.get(1);
		System.out.println(value); //-> key가 존재하면 value 리턴
		
		value = map.get(50);
		System.out.println(value); //-> key가 없으면 null을 리턴.
		
		//getOrdefault(key, defaultValue)
		value = map.getOrDefault(513, "nono"); //-> key가 존재하면 key에 매핑된 value 리턴
		System.out.println(value);
		
		value = map.getOrDefault(10, "nono"); //-> key가 없으면 아규먼트 defaultValue 리턴
		System.out.println(value);
		
		//keySet() : Map의 키(Key)들로만 이루어진 집합(set)을 리턴
		Set<Integer> keySet= map.keySet();
		System.out.println(keySet);
		for (Integer k : keySet) {
			System.out.println(k +" : "+map.get(k));
		}
		
		//map에 저장된 데이터 삭제
		map.remove(513); //return은 value값을 해줌...
		System.out.println(map);
		//put(key,value)
		// (1) key가 존재하지 않으면 새로운 key-value를 저장.
		// (2) key가 존재하면 해당 key의 값을 변경
		map.put(513, "nn");
		System.out.println(map);

	}

}
