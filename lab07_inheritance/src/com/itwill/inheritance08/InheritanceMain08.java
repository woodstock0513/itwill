package com.itwill.inheritance08;

public class InheritanceMain08 {

	public static void main(String[] args) {
		// Rectangle
		
		Rectangle rect = new Rectangle(4, 5);
		rect.draw();
		
		//Circle 타입의 객체 생성
		Shape c = new Circle(1.2); //서클을 만들고, Shape에 저장. 다형성
//		Circle c = new Circle(3.8);
		c.draw();
		

	}

}
