package com.itwill.inheritance07;

// 추상메서드 (abstract method) :
// - 메서드의 시그니처(수식어, 리턴타입, 메서드 이름, 파라미터 선언)만 선언되어 있고, 
// 메서드의 body(몸통)가 구현되어 있지 않은 메서드.
// - 추상 메서드는 반드시 "abstract" 키워드로 수식해야 함.
// - 추상 메서드 선언은 반드시 세미콜론(;)으로 끝내야 함.

// 추상 클래스(abstract class)란..
// - "abstact"라는 수식어가 사용된 클래스. -> 추상메서드의 유무로 판단하는 것은 아님.
// - 대부분의 경우, 추상 클래스는 추상 메서드를 가지고 있는 경우가 많다. 
// - 클래스가 추상 메서드를 가지고 있는 경우에는 반드시 abstract로 선언해야 함.
// - 추상 클래스는 객체를 생성할 수 없음(실체가 없는 클래스임..)
// - 추상 클래스를 상속하는 클래스를 선언하고 모든 추상 메서드를 override한 이후에 객체를 생성할 수 있음.

//추상 클래스
abstract class X { //추상 클래스 안에 추상 메서드 없어도 됨.
	public void test() {
		System.out.println("hi");
	}
}
//추상 클래스 , 안에 추상 메서드
abstract class Animal {
	public abstract void move(); //추상 메서드. 리턴 타입 앞에만 abstract 써주면 됨. {} 있으면 안됨.
}

class Dog extends Animal{ //이러면 Dog 객체 생성 가능.
	@Override
	public void move() { //body 생겼으니까 abstract 붙이면 안됨.
		System.out.println("강아지가 총총총.. ");
	}
}

class Fish extends Animal{
	@Override
	public void move() {
		System.out.println("물고기가 휘리릭.. ");
	}
}

class Bird extends Animal{
	@Override
	public void move() {
		System.out.println("새가 훨훨.. ");
	}
}


public class InheritanceMain07 {

	public static void main(String[] args) {
		Animal[] animals = {
				new Dog(), //다형성
				new Fish(),
				new Bird(), 
//				new Animal()
		};
		
		for (Animal a : animals) {
			a.move(); //다형성으로 선언되어있더라도 override된 메서드가 호출됨. (클래스가다르니까)
		}
		
		animals[0].move();
		animals[1].move();
		animals[2].move();
		
		
	}

}
