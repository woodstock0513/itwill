package com.itwill.enum01;

public enum Season3 {
	SPRING("봄"),  //public static final Season3 SPRING = new Season3("봄"); 를 간단하게 쓴 것!!
	SUMMER("여름"),
	FALL("가을"),
	WINTER("겨울"); //프라이빗 스태틱 파이널 변수라고 생각
	
	private String name;
	
	//enum의 생성자의 접근 수식어는 private만 사용 가능. private은 생략 가능.
	private Season3(String name) { // 절대 포블릭으로 공개할 수 없음
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
