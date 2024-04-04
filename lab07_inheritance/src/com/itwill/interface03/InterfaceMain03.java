package com.itwill.interface03;

class A {}
class B {}

class C extends A {} //class C는 A를 확장(상속).
//class D extends A, C {} //다중상속 - 자바는 클래스의 다중상속을 허용하지 않음.
//추상클래스던 아니던 상관X

interface I {}
interface J {}
class E implements I{} //class E는 interface I를 구현.
class F implements I,J{} // 클래스가 구현하는 인터페이스의 개수는 제한이 없음
class G extends B implements I {} //클래스 G는 클래스 B를 확장하고, 인터페이스 I를 구현한다.

interface K extends I, J {} //인터페이스 K는 인터페이스 I,J를 확장한다. -> K를 구현하면 I,J도 구현하게됨
//인터페이스는 다중상속이 가능!!
// 인터페이스는 다른 인터페이스를 구현할 수 없음..

//interface L extends A {} //인터페이스는 클래스를 확장할 수 없음.

interface Clickable {
	void click(); //public abstract
}

interface Scrollable{
	void scroll();
}

class Mouse implements Clickable,Scrollable{

	@Override
	public void scroll() {
		System.out.println("scroll");
	}

	@Override
	public void click() {
		System.out.println("click");
	}
	
}

public class InterfaceMain03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mouse m1 = new Mouse();
		m1.click();
		m1.scroll();
		
		Clickable m2 = new Mouse();
		m2.click();
		((Mouse)m2).scroll(); //캐스팅!
		((Scrollable)m2).scroll(); //캐스팅!
	}

}
