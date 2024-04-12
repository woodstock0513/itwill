package com.itwill.inner01;

public class OuterCls {
	// field
	private int x;
	private String s;
	private int y;

	// cons
	public OuterCls(int x, int y, String s) {
		this.x = x;
		this.s = s;
		this.y = y;
	}

	// method

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("OuterCls(x=%d, y=%d, s=%s)", x,y, s);
	}

	// static이 아닌 멤버 내부 클래스
	// 선언 위치는 중요하지 않음
	public class InnerCls { //private, protected 가능. 약간 멤버의 일종이라고 생각..
		//field
		private int y;
		
		//cons
		public InnerCls(int y) {
			this.y=y;
		}
		
		//method
		public void info() {
			System.out.println("----InnerCls----");
			System.out.println("y="+y); //InnerCls의 인스턴스의 필드 사용
			System.out.println("x = "+x); //외부 클래스의 필드도 사용 가능!!!!!
			System.out.println("OuterCls y = "+OuterCls.this.y); //외부클래스 참조법
			// 내부 클래스의  필드 이름과 외부 클래스의 필드 이름이 같은 경우,
			// 외부 클래스의 인스턴스의 필드를 사용하는 방법.
			System.out.println("s="+s);//OuterCls 인스턴스의 필드!!
		}
		
	} //end Class innercls

} // end class outercls
