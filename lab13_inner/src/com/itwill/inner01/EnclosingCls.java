package com.itwill.inner01;

public class EnclosingCls {
	public static int var = 1; // static field
	private int x; // instance filed

	public EnclosingCls(int x) {
		this.x = x;
	}

	// static method
	public static void test() {
		System.out.println("var = " + var);
//		System.out.println(x);
		// -> 컴파일 에러
	}

	// method

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Enclosing [x=%d,var=%d]",x,var);
	}
	
	//static 내부 클래스 (중첩클래스)
	public static class NestedCls{
		private int x;
		
		public NestedCls(int x) {
			
		}
		
		public void info() {
			System.out.println("----Nested Cls----");
			System.out.println("Nested x="+x); // 중첩 클래스의 필드
			System.out.println("Enclosing var="+var); // 외부 클래스의 스태틱 필드
//			System.out.println(EnclosingCls.this.x); //컴파일 에러
			//-> static 내부 클래스(중첩 클래스)에서는
			// 외부 클래스의 static 멤버만 사용 가능하고 
			// 외부 클래스의 non-static 멤버들을 사용할 수 없다.
			
		}
	}
	
	
}
