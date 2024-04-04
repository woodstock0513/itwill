package com.itwill.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Captain cap = Captain.getInstance();
		System.out.println(cap);
		System.out.println(cap.getName());
		cap.setName("Steve");
		System.out.println(cap.getName());
		
		Captain c = Captain.getInstance(); //instance 값 그대로 리턴
		System.out.println(c);
		
		Singleton s1 = Singleton.INSTANCE;  //new Singleton(); 이런 식으로 하면 안됨
		System.out.println(s1); //enum 타입은 toString이 override되어 있어서 주소값을 볼 수 없음.
		System.out.println(s1.getName());
		s1.setName("zz");
		System.out.println(s1.getName());
		
		
		Singleton s2 = Singleton.INSTANCE; //s2와 s1은 같다! (같은 INSTANCE)
	}

}
