package com.itwill.inheritance08;

public class Rectangle extends Shape {
	//field
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		super("Rectangle");
		this.height = height;
		this.width = width;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return height * width;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2 * (height + width);
	}

}
