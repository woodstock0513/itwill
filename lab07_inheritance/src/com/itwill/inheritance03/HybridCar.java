package com.itwill.inheritance03;

public class HybridCar extends Car {
	// 필드
	private int battery;

	public HybridCar(int fuel, int speed, int battery) {
		// 상위 타입(Car)에 기본 생성자가 없기 때문에
		// 반드시 "명시적으로(explicitly)" 아규먼트를 갖는 상위 클래스 생성자를 호출해야함
		super(fuel, speed);
		this.battery = battery;
	}

	// 메서드
	public void charge(int battery) {
		this.battery = battery;
		System.out.println("CHRAGING ... BATTERY : "+battery);
		}
	
	
//	오버로딩(over-loading)
//	파라미터가 다르면 같은 이름의 메서드나 생성자를 여러 개 선언할 수 있음.
//	메서드 오버라이딩 (over-riding)
//	상위 타입에서 선언된 메서드를 하위 타입에서 재정의하는 것.
//	리턴 타입, 메서드 이름, 파라미터 선언이 모두 같아야 함.
//	접근 수식어는 상위 타입의 가시성 범위와 같거나 더 넒어질 수 있음.
//	하위 클래스 내에서 super.~~으로 상위 객체의 메서드 호출 가능.
//	단, main에서는 호출 불가.
	
	
	@Override //에너테이션 (annotation) - 자바 컴파일러가 사용 (오버라이딩 맞는지 검사해라 ~ ) . 필수는 아님.
	//밑의 메서드 한 개에만 적용
	public void drive() {
//		super.drive(); //--> 상위 객체의 재정의 하기 전의 메서드 호출 
		System.out.println("HYBRID Driving~ SPEED : "+super.getSpeed()+" FUEL : "+getFuel()+" BATTERY : "+battery);
													//super 생략해도 됨. (this 생략과 마찬가지)
	}
}
