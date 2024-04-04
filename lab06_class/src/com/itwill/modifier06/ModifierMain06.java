package com.itwill.modifier06;

/*
 * 접근 수식어 (access modifier) 는 지역 변수에는 사용할 수 없음!!!
 * final 수식어
 * - 클래스, 클래스의 멤버(필드, 메서드), 지역변수에서 사용 가능.
 * - 선언하는 거면 거의 다 붙일 수 있당!!
 * - final 의미 : 바꿀 수 없는. 
 * - final 필드, 지역변수  :  한 번 초기화가 되면 더이상 값을 변경할 수 없는 변수. 상수(constant)
 * - final 필드는 반드시!
 *  (1) 선언과 동시에 초기화 하거나
 *  (2) 아규먼트를 갖는 생성자를 선언해서 명시적으로 초기화해야 함.
 *  (3) 인스턴스 필드는 자바실행환경(JRE)가 사용하는 메모리 영역 중 힙 영역에 생성. 
 *  
 *  인스턴스 멤버(필드, 메서드) vs 정적(static) 멤버
 *  1. 인스턴스 멤버 - 인스턴스 : 호출되어 힙에 생성된 객체 
 *  (1) static 수식어가 없는 멤버
 *  (2) 객체를 생성한 후에 참조 변수를 이용해서 사용하는 멤버
 *  2. 정적 멤버(필드, 메서드)
 *  (1) static 수식어가 사용된 멤버
 *  (2) 객체를 생성하지 않아도 사용할 수 있는 멤버. → 생성자 호출안해도됨!
 *  (3) 클래스 이름을 이용해서 사용하는 멤버! ex) Math.PI, Math.random(), System.in, System.out
 *  (4) 정적 필드는 JRE가 사용하는 메모리 영역 중 메서드 영역에 생성.
 *  (5) 정적 멤버들은 프로그램의 main() 메서드가 호출되기 전에, 프로그램 로딩 시점에 메모리에 생성된다.
 */

public class ModifierMain06 {
	
	private static final int version = 1; //이 클래스(MM06) 안에서만 쓰는,변경할 수 없는 정수 
	
	private final String s = "Hello"; //(1) 방법
	
	private final String s2;   // (2) 방법. 선언할 때 초기화되지 않은 final 필드. 생성자 필수
	
	//final 필드를 명시적으로 초기화하는 생성자. 기본생성자 안됨.
	public ModifierMain06(String m) {  //이거 없으면 위 문장 에러남
		s2 = m;
	}
	
	
	public static void main(String[] args) { //main부터 시작해라! -> 스태틱.
		
//		version=2;
//		s2="a"; //부르기 전이라 할 수 없음. 객체 생성부터 해야.
		
		// 지역 변수 선언 & 초기화
		int n1 = 10;
		n1 = 100;
		
		final int n2 = 10; //-> 상수. final 지역변수
//		n2=100;  //값을 변경(재할당)할 수 없음.
		
		//꼭 선언과 동시에 초기화 할 필요는 없다. 나중에 해도 되지만, 한번만 가능하다.
		final int n3;
		n3 = 10;
//		n3=100;
		
		
		ModifierMain06 app = new ModifierMain06("bus");
//		app.s2 = "dd"; // final 필드는 객체 생성 이후에 값을 변경할 수 없다.
		
		//Test 클래스의 정적 멤버 사용
		System.out.println("Test.y = " + Test.y);
		Test.y = 20; //static 필드는 객체 생성과 관계없이 사용할 수 있음.
		System.out.println("Test.y = " + Test.y);
		Test.printFields2();
		
		//Test 클래스의 인스턴스 멤버 사용 : 먼저 객체를 생성해야
		Test test = new Test();
		System.out.println("test.x = " + test.x); //y도 가능하긴 한데 좋은 방법이 아님.
		test.x = 50;
		test.printFields();
		

	}

}
