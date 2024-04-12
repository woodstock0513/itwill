package com.itwill.inner02;

public class InnerMain02 {

	public static void main(String[] args) {
		// Book 타입 객체 생성
		Book book1 = new Book("HarryPotter","JKR","문화출판사");
		System.out.println(book1);
		
		Book book2 = new Book("일론머스크", "월터 아이작슨", "21세기 북스");
		
		Book book3 = new Book( "월터 아이작슨","일론머스크", "21세기 북스"); //이러면 위 두 책이 완전이 다른 게 되어버림
		
		Book book4 = Book.builder().author("신용권").publisher("한빛").title("혼자공부하는자바").build(); //메서드 연쇄호출
		//각각의 메서드들이 리턴하는 값을 잘 생각하면서 작성
		//뭘 먼저 부르던간에, 의미만 맞춰서 쓰면 됨.
		System.out.println(book4);
		
		Book book5 = Book.builder().title("gg").build();
		
		System.out.println(book5);
	}

}
