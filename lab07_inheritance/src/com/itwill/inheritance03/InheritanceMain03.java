package com.itwill.inheritance03;

public class InheritanceMain03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car(100,60);
		
		car1.drive();
		
		HybridCar car2 = new HybridCar(40, 60, 70);
		car2.drive();
		car2.charge(100);
		
		// 다형성(polymorphism)을 사용한 변수 선언과 초기화
		// SuperType var = new SubType();
		
		Car car3 = new HybridCar(70,40,90);

		car3.drive(); //다형성으로 선언되어 있더라도 override되어있는 메서드가 호출됨
		
		((HybridCar)car3).charge(100); //casting. (상속 관계 성립할 때 사용 가능) 다른 field 사용가능해짐.
		//casting을 하면 SubType의 모든 메서드를 사용할 수 있음.
//		car3.charge(100); //casting을 하지 않으면, SubType의 모든 메서드를 사용할 수 없음
		//부모 클래스는 자식 클래스의 새로운 기능 관심 없음 ! 
		
		// SubType var2 = new SuperType(); - compile error
//		HybridCar car = new Car(100,100);
		
		//다형성의 장점 : 코드의 재사용성(re-usability)을 높여줌
		// (예) 배열 선언, 파라미터 선언 등에서 상위 타입으로 선언한 변수에 하위타입 객체들을 할당할 수 있기 때문에
		// 코드 재사용성이 높아진다
		Car[] cars = new Car[3];
		//배열을 상위타입으로 하면 상위타입, 하위타입 모두 저장할 수 잇음.
		cars[0] = car1;  //new Car(..)
		cars[1] = car2;  //new HybridCar(..)
		cars[2] = car3;  //new HybridCar(..)
		
		for (Car c : cars) {
			test(c);
		}
		
	}
	
	public static void test (Car car) { //HybridCar을 아규먼트로 넣어도 됨
		// instanceof 연산자 - 객체가 어떤 타입인 지를 반환하는 연산자. //타입 구분을 위해 사용
		// 변수 instanceof Type(Class) : 변수가 클래스 타입이면 true, 그렇지 않으면 false.
		if (car instanceof HybridCar) {
			System.out.println("Hybrid car...");
		} else {
			System.out.println("car...");
		}
	}

}
