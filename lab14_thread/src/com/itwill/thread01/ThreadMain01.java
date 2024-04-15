package com.itwill.thread01;

//thread 사용법 1:
//(1) thread 상속하는 클래스 선언
//(2) (1)에서 선언한 클래스에서 run 메서드를재저의(override) -> 쓰레드가 할 일.
//(3) (2)에서 생성한 클래스의 객체를 생성
//(4) (3)에서 생성된 객체의 start() 메서드를 호출. -> 쓰레드 실행됨
//(주의) 쓰레드 객체의 run 메서드를 직접 호출하면 안됨!!!
//이유 : start() 메서드 호출 -> JRE에서 쓰레드를 초기화(메모리 할단, 스케쥴링, ...)
//							 -> JRE에 의해 run()메서드가 호출됨.

public class ThreadMain01 {

	public static void main(String[] args) {
		// (1) 쓰레드를 상속받는 클래스 선언
		class MyThread extends Thread{ //java.lang에 있으니까 import 할 필요 없음
			private String name;
			
			public MyThread(String name) {
				this.name = name;
			}
			
			// (2) run메서드 재정의
			@Override
			public void run() {
				for (int i=0;i<100;i++) {
					System.out.println(i+" : "+name);
					try {
						sleep(100); //Thread 클래스의 static 메서드 호출
						//100ms = 0.1s 동안 잠자겟다.
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		//(3) MyThread 객체 생성
		MyThread th1 = new MyThread("judy");
		MyThread th2 = new MyThread("hello");
		MyThread th3 = new MyThread("love");
		
		long start = System.currentTimeMillis(); //쓰레드 시작 시간
		
		// (4) MyThread 객체의 start() 메서드 호출
		th1.start();
		th2.start();
		th3.start();
		//main 프로세스가 실행시킨 다른 프로세스(쓰레드)들이 모두 종료될 때까지 기다림.
		
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//위 두개의 프로세스가 모두 끝날 때까지 기다림 
		
		long end = System.currentTimeMillis();
		
		System.out.println("소요 시간 : "+(end-start)+"ms");
		
		System.out.println("main 종료");

	}

}
