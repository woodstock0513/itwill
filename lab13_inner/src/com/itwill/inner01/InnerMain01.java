package com.itwill.inner01;

import com.itwill.inner01.OuterCls.InnerCls;//를 하면 외부 클래스 참조 안해도됨/
import com.itwill.inner01.EnclosingCls.NestedCls;

//변수 선언 위치:
//1. 필드 : 클래스의 멤버로 선언하는 변수. 접근수식어(private, protected, public)를 사용할 수 있음.
// (1) 인스턴스 필드 : static이 아닌 필드.
// 	   생성자를 호출해 객체를 생성한 후에, 그 참조 변수(인스턴스)로 접근해서 사용하는 필드.
// (2) 정적(static) 필드 : static으로 선언한 필드
//     프로그램 로딩 시점에 클래스 로더에 의해 메모리에 만들어지는(로딩되는) 필드
//     객체를 생성하지 않고 클래스 이름을 접두사로 사용하는 필드.
//2. 지역변수 : 메서드 안에서 선언하는 변수. 접근 수식어를 사용할 수 없음. final은 사용 가능. 
//   선언된 위치에서부터 변수가 포함된 블록이 끝날 때까지 사용 가능
//   메서드의 파라미터도 지역 변수의 일종.
//
//내부 클래스/인터페이스(inner class/interface)
// 다른 클래스나 인터페이스 안에서 선언된 클래스/인터페이스
//외부클래스/인터페이스(outer,enclosing class/interface)
// 내부 클래스/인터페이스를 감싸고 있는 클래스
//내부 클래스를 선언할 수 있는 위치 : 
//1. 멤버 내부 클래스
// (1) 인스턴스 내부 클래스 : static이 아닌 멤버 내부 클래스
//     외부 클래스의 객체를 먼저 생성한 후에, 그 참조변수로 참조해서 객체를 생성하고 사용할 수 있는 멤버 내부 클래스.
// (2) 정적(static) 내부 클래스 : static으로 선언한 내부 클래스
//     외부 클래스의 객체 생성 여부와 상관없이 사용할 수 있는 멤버 내부 클래스.
//     중첩 클래스.(nested class)
//1-2. 멤버 내부 인터페이스는 static이어야함. -> static 생략
//
//2. 지역 (내부) 클래스.(local 클래스) : 메서드 안에서 선언된 내부 클래스
// 선언된 메서드 블록 안에서만 객체를 생성하고 사용할 수 있는 클래스 - 엄총 많이 사용함.
//3. 익명 클래스(anonmyous class) : 이름이 없는 클래스 - 1,2의 경우 모두 가능
// 클래스 선언과 동시에 객체 생성까지를 해야만 하는 클래스.
//-> 람다 표현식(lambda expression)

public class InnerMain01 {
	class A {} //멤버내부
	static class B {}

	public static void main(String[] args) {
		// OuterCls 타입의 객체 생성 
		OuterCls outer1 = new OuterCls(1, 10,"java");
		System.out.println(outer1);
		
		//InnerCls 타입의 객체 생성 - import X
		OuterCls.InnerCls inner = outer1.new InnerCls(5); //외부클래스의 인스턴스가 있어야함!!!
		inner.info();
		
		//내부 클래스의 이름을 import 한 경우
		InnerCls inner2 = outer1.new InnerCls(4);
		//앞부브만 좀 쉬워짐.
		inner2.info();
		
		
		InnerCls inner3 = new OuterCls(10, 20, "lunch!").new InnerCls(456);
		inner3.info();
		//중첩이 아닌 inner 클래스는 무조건outer 클래스 객체가 있어야 생성 가능하다.
		
		
		//Enclosing의 static field
		System.out.println("EnclosingCls.var = "+EnclosingCls.var);
		
		//Enclosing의 static method
		EnclosingCls.test();  //마찬가지로 import 하면 클래스 이름 생략 가능.
		
		//Enclosing Cls 타입의 객체 생성
		EnclosingCls encl = new EnclosingCls(513);
		System.out.println(encl); //toString 테스트
		
		// NestedCls 타입 객체 생성
		EnclosingCls.NestedCls nested = new EnclosingCls.NestedCls(427); //static이라.. 
		//encl 없어도 됨
		nested.info();
		
		//  중찹 클래스 NestedCls 이름을 import한 경우
		NestedCls nested2 = new NestedCls(123); //외부 클래스인지 내부 클래스인지 구분이 안감(이것만보고)
		nested2.info();
		
		
		
	}

}
