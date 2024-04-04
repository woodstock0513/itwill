package com.itwill.inheritance08;

public class Circle extends Shape {
	//field
	private double radius;
	
	public Circle (double radius) {
		super("Circle");
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return radius * radius * Math.PI;
	}
	
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
}
