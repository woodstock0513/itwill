package com.itwill.enum01;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int season = Season1.SPRING;
//		int x=0;해도 되는데 코드가 의미가 없어.
		switch (season) {
		case Season1.SPRING:
			System.out.println("봄");
			break;
		case Season1.SUMMER:
			System.out.println("여름");
			break;
		case Season1.FALL:
			System.out.println("가을");
			break;
		case Season1.WINTER:
			System.out.println("겨울");
			break;
		default:
			System.out.println("이상기후");
			break;
		}
		
//		Season2 season22 = new Season2(); // 가능 -> 프라이빗 생성자 만들어서 에러남. 만들어진 것만 호출 가능해짐..
		//근데 새로운 객체가 힙에 만들어짐. 기존에 만들어진 거와 주소가 다름

		Season2 season2 = Season2.FALL;
						  //이건 주소값
		//switch case 쓸 수 없음. ??
		System.out.println(season2);
		
		if (season2 == Season2.SPRING) {
			System.out.println(season2.getName());
		} else if (season2 == Season2.SUMMER) {
			System.out.println(season2.getName());
		} else if (season2 == Season2.FALL){
			System.out.println(season2.getName());
		} else {
			System.out.println("....");
		}
		
		Season3 s = Season3.FALL;
		System.out.println(s);
		System.out.println(s.getName());
		
	}

}
