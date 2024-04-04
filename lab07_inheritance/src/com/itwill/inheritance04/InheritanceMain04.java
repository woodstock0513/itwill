package com.itwill.inheritance04;

public class InheritanceMain04 {

//	final : 변경할 수 없는.
//	final 지역 변수 : 값을 초기화한 이후에 그 값을 변경할 수 없는 (재할당할 수 없는) 지역변수
//	final field : 반드시 한 번은 명시적으로 초기화해야하고, 이후에는 값을 변경할 수 없는 필드.
//	 (1) final 필드를 선언과 동시에 초기화
//	 (2) final 필드를 초기화할 수 있는 아규먼트를 갖는 생성자를 작성.
//	final method : 변경할 수 없는 메서드. 재정의(over-ride) 할 수 없는 메서드.
//	final class : 변경할 수 없는 클래스. 상속 받을 수 없는 클래스 ex) java.lang.system java.lang.String
	
//	class MyString extends String{}
	//final class를 상속하는 새로운 클래스는 선언될 수 없음!
	
	class A {
		public void test1() {
			System.out.println("test1");
		}
		public final void test2() {
			System.out.println("test2");
		}
	}
	
	
	class B extends A{
		@Override //상위 클래스의 final이 아닌 메서드는 override할 수 있다.
		public void test1() {
			System.out.println("B test1");
		}
//		상위 클래스에 final로 선언된 메서드는 하위 클래스에서 override 할 수 없다.
//		public void test2() {
//			System.out.println("");
//		}
	}
	
class C {}

class E extends C{}

final class D{}

//class F extends D{}
	
	public static void main(final String[] args) {
		// 넘겨받은 객체를 변경할 수 없게끔.
		
	}

}
