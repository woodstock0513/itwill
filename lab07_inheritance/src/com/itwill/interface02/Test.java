package com.itwill.interface02;

// 인터페이스가 가질 수 있는 멤버들 - Java 8 이후 변경 사항 
//1. [public static final] 필드      - []는 생략가능
//2. [public abstract] 메서드    -이 둘은 모든 인터페이스 공용
//3. [public] static 메서드 - Java 8 버전부터.
//    -> body가 구현된 메서드.
//    -> 객체 생성 없이, 인터페이스 이름을 접두사로 써서 호출 가능한 메서드
//4. [public] default 메서드. - Java 8 버전부터
//    -> body가 구현된 메서드.
//    -> 인터페이스를 구현한 하위 타입의 객체를 생성한 후에 호출할 수 있는 메서드.
//5. private static method - Java 9 버전 부터. 암것도 생략하면 안됨
//    -> body가 구현된 메서드.
//    -> static 또는 default 메서드에서만 호출한 목적으로 만드는 메서드. 
//     람다 어쩌고에서 사용하나봄 
//     3, 4의  메서드가 너무너무 길어지는것보단 그 안에서도 메서드를 활용하면 짧아지고 좋으니까 그때 사용하나봄
//6. private 메서드
//    -> body가 구현된 메서드.
//    -> default 메서드에서만 호출한 목적으로 만드는 메서드. 


public interface Test {
	//1. [public static final] 필드
	int VERSION = 1;
	
	//2. [public abstract] 메서드 
	void test();
	
	//3. [public] static 메서드
	static void staticMethod() { //interface 이름만 있으면 호출가능.
		System.out.println("공개 정적(public static) 메서드.");
		privateStaticMethod();
		System.out.println("--------fin--------");
	}
	
	//4. [public] default 메서드
	default void defaultMethod() { //객체 생성 이후 호출가능.
		//default 생략하면 안됨!!! class 였으면 생략해도 되지만 interface는 아무것도 없으면 public abstract으로 취급하기 때문
		//퍼블릭이니까 다른 곳에서 메서드 사용 ㄱㄴ
		System.out.println("공개 기본(public default) 메서드");
		privateStaticMethod();
		privateMethod();
		System.out.println("--------fin--------");
	}
	
	//5. private static method
	private static void privateStaticMethod() { //body를 가진 메서드 중에서 ..
		System.out.println("비공개 정적(private static) 메서드.");
	}
	
	
	//6. private 메서드
	private void privateMethod() {
		System.out.println("비공개(private) 구현된 메서드");
	}
	
	
	
}
