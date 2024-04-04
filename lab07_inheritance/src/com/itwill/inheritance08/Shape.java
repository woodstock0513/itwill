package com.itwill.inheritance08;

public abstract class Shape {
	//field
	protected String type; //직사각형, 원, 사각형..
	
	//constructor
	public Shape (String type) {
		this.type = type;
	}
	
	//추상 메서드
	public abstract double area(); //도형의 넓이를 리턴하는 메서드. 도형마다 넓이 계산법이 다름. 
	public abstract double perimeter();
	
	//final 메서드 : 하위 클래스에서 재정의(override)할 수 없는 메서드
	public final void draw() {
		String info = String.format("%s [넓이 = %f, 둘레 = %f]\n", type, area(),perimeter());
		System.out.print(info);
	}
}
