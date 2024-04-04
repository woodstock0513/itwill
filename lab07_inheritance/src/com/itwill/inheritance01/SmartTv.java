package com.itwill.inheritance01;

// 스마트 티비는 기본 티비를 확장(상속)한다. //베이직 티비를 확장해서 스마트 티비를 만들겟따!!!
// 상위(super), 부모(parent), 기본(base)클래스 - BasicTv
// 하위(sub), 자식(child), 유도(derived)클래스 - SmartTv
// 모든 클래스의 최상위 클래스는 java.lang.Object 클래스
// 상위 클래스가 java.lang.Object인 경우, extends Object는 생략가능
public class SmartTv extends BasicTv {
	//같은 패키지라 바로 쓸 수 잇고, 다른 패키지에 있으면 import 해야함

	private String ip;
	
	public void webBrowsing() {
		System.out.println("internet");
	}
	
	
	public void checkChannel() {
		System.out.println(getChannel());
	}
	
	
}
