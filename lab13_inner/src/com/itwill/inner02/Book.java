package com.itwill.inner02;

public class Book {
	private String title;
	private String author;
	private String publisher;
	
	//생성자 오버로딩
	public Book() {}
	
	public Book ( String title ) {
//		this.title = title;
		this(title,null,null); //오버로딩된 다른 생성자 호출
	}
	 //이렇게는 안됨,, 왜냐면 파라미터기 String 한개인 생성자가 이미 있으니까.
//	public Book ( String author) { 
//		this.author = author;
//	}
	
	//파라미터가 String 2개인 경우는 ㄱㄴ
	
	public Book ( String title , String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return String.format("Book [제목:%s,저자:%s,출판사:%s]", title, author, publisher);
	}
	
	//--Builder(Factory) 디자인 패턴
	
	//Book을 만들기 전에 선언해야하므로 static
	public static BookBuilder builder() {
		return new BookBuilder();
		//외부 클래스에서 내부 클래스의 private 생성자를 호출할 수 있음
	}
	
	public static class BookBuilder{
		//field  외부 클래스와 동일하게 선언
		private String title;
		private String author;
		private String publisher;
		
		private BookBuilder () {}
		
		//리턴 타입이 있는 세터 역할을 하는 함수들
		public BookBuilder title(String title) {
			this.title = title;
			return this;
		}
		
		public BookBuilder author(String author) {
			this.author = author;
			return this;
		}
		
		public BookBuilder publisher ( String publisher) {
			this.publisher = publisher;
			return this;
		}
		
		public Book build () {
			return new Book(title, author, publisher);
		}
		
	}
	
	//--Builder(Factory) 디자인 패턴

}
