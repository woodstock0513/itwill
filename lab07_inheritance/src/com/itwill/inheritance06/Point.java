package com.itwill.inheritance06;

//2차원 평면에 점의 좌표를 표현.
public class Point {
	//필드
	private int x;
	private int y;
	
	
	//생성자
	public Point () {}
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	//아무것도 오버라이딩 하지 않음. -> 오브젝트 그대로 쓰겟다
	
	@Override //Object 클래스에서 상속받은 toString() 재정의
	public String toString() {
		return "Point (x = "+x+", y = "+y+")";
	}
	
	@Override //Object 클래스에서 상속받은 equals() 재정의 (맘대로 해도 됨)
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Point) {
			Point pt = (Point) obj; //안전한 캐스팅.
			result = ((this.x == pt.x) && (this.y == pt.y)); // return true라는 뜻
		} 
		return result;
	}
	//해시코드 같이 override 해야함..!!
	
	@Override //Object 클래스에서 상속받은 hashCode() 재정의 (맘대로 하면 안됨.)
	//주의) equals가 true인 것들끼리 같은 값을 리턴해야함.
	public int hashCode() {
		return x+y;
	}
	


}
