package com.itwill.thread02;

//자바는 다중상속을 허용하지 않음 -> 다른 클래스를 이미 상속하는 클래스는 Thread 클래스를 상속할 수 없음.
///그러나 자바는 인터페이스 구현 개수에는 제한이 없음.
//
//쓰레드 사용법 2
//(1)Runnable 인터페이스를 구현하는 클래스를 선언
//(2) (1)에서 선언한 클래스에서 run 메서드를 재정의(override) -> 쓰레드가 할 일.
//(3) Thread 객체 생성 -   Thread 생성자의 아규먼트로 (2)에서 작성한 클래스의 객체를 넘김 
//(4) (3)에서 생성된 객체의 start() 메서드를 호출. -> 쓰레드 실행됨

public class ThreadMain02 {

	public static void main(String[] args) {
		//(1) Runnable 구현 클래스
		class MyRunnable implements Runnable{
			private String name;
			
			public MyRunnable (String name) {
				this.name = name;
			}

			@Override
			public void run() {
				for (int i=0;i<100;i++) {
					System.out.println(i+":" + name);
					try {
						Thread.sleep(10);  //thread를 상속하지 않기 때문에....
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}
		//(3) Thread 생성
		Thread th1 = new Thread(new MyRunnable("hi"));
		
	
		
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0;i<100;i++) {
					System.out.println(i+":" + "익명클래스");
					try {
						Thread.sleep(10);  //thread를 상속하지 않기 때문에....
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		//람다 표현식을 이용
		Thread th3 = new Thread(()->{
			for (int i=0;i<100;i++) {
				System.out.println(i+":람다 표현식");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	
		
		//(4) thread 실행
		th1.start();
		th2.start();
		th3.start();
		
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end");

	}

}
