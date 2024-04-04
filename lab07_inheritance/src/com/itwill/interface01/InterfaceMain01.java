package com.itwill.interface01;

import javax.xml.crypto.Data;

import com.itwill.database.Database;
import com.itwill.mysql.MysqlDatabase;
import com.itwill.oracle.OracleDatabase;

// 인터페이스 (interface)
// 사용 목적 : 팀/회사 간의 분업/협업을 하기 위해서 메서드들의 signiture(리턴타입,이름,파라미터)를 약속하기 위해.
// 메서드는 이렇게 사용하면된다~ 안내하는 늑김
// 인터페이스가 가질 수 있는 멤버:
//  (1) public static final(상수) field - 퍼블릭 스태틱 파이널 수식어는 생략 가능.
//  (2) public abstract method (추상 메서드) - 퍼블릭 앱스트랙 수식어 생략 가능
// 인터페이스를 선언할 때에는 "interface" 키워드 사용
// 인터페이스는 아주 특별한 추상 클래스.
// 인터페이스는 객체를 생성할 수 없고, 인터페이스를 "구현"하는 클래스를 선언해서 객체를 생성할 수 있음.
//  class 클래스이름 extends 상위클래스이름 {}
//  class 클래스이름 implements 인터페이스이름 {}
// class는 단일 상속만 가능하지만, interface 구현 개수는 제한이 없음.
// class A implements B,C,D {}
// 인터페이스는 상위 인터페이스를(클래스 상속 못함) 상속(확장)할 수 있고, 다중 상속이 가능하다.
// interface I extends A,B {}

public class InterfaceMain01 {

	public static void main(String[] args) {
		// Oracle Database 객체 생성, 메서드 이용
//		OracleDatabase db = new OracleDatabase();
		
//		MysqlDatabase 객체 생성, 메서드 이용
		MysqlDatabase db = new MysqlDatabase();
		
		//호출문장만 수정하면, 나머지 코드는 안 바꿔도 됨.
		//interface에서 정한대로 oracle, mysql에서 코드를 만들어줌.

		//근데 호출문장도 다형성 이용하면 수정할게 더 적어짐!!!!!
//		Database db = new MysqlDatabase(); 이케 쓰면 됨!!!!! 코드의 재사용성 더 올라감 ~

		
		int a = db.insert();
		System.out.println(a);

		a = db.select();
		System.out.println(a);

	}

}
