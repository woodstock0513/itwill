package com.itwill.class03;

public class ClassMain03 { //클래스 이름은 변수를 선언할 때 쓰는 타입 이름.
	//클래스 내부에서 변수 선언 - 필드

	public static void main(String[] args) {
		// person 타입의 객체를 기본 생성자를 호출해서 생성.
		Person p1 = new Person(); //생성자를 만드는 순간 이건 쓸 수 없음. 둘다 필요하면 둘다 만들어야
		
		System.out.println(p1.name); //null - 참조타입
		System.out.println(p1.age); //0  기본값이 출력됨.
		
		//붕어빵을 ㅏㅏㅁ들기 위한 틀= 클래스
		//민ㄷ,ㅡ,ㄹㅇㅈ;ㄴ ㅁ븡아ㅣㅃㅇ - 객체
		//실제로 구워진 붕어ㅏㅂ ㅇ - 인스턴스
		
		p1.name = "오쌤";
		p1.age = 16;
		p1.introduce(); //기능 이용
		//인서턴스가 가지고 있는 데이터가 중요함
		
		//아규먼트를 갖는 생성자를 호출홰서 Person타입 객체 생성
		Person p2 = new Person("문다영", 23);//객체생성
		//만들어진 객체 - 인스턴스
		//퍼슨 타입의 인스턴스 p2
		//인스턴스가 있어야 메서드 호출 가능.
		//인스턴스.메서드이름 이런식
		//랜덤, 스캐너도 다 이런 식이엇음!!!!!!
		
		p2.introduce(); //객체에서 메서드 호출
		// 초기화 할 필요 없이 바로 introduce 사용 가능!
	}

}
