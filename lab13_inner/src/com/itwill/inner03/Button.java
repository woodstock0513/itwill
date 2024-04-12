package com.itwill.inner03;

public class Button {
	//public static 내부 인터페이스 -> static 생략 가능.
	public interface OnClickListener{  //상수, 추상메서드!!!!!!!!!!
		void onClick(); //public abstract method
	}
	//field
	private String btnName;
	private OnClickListener listener;
	
	//cons
	public Button (String btnName) {
		this.btnName = btnName;
	}
	
	//setter
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	//method
	public void click() {
		System.out.println(btnName +"버튼");
		listener.onClick();
	}
	
}
