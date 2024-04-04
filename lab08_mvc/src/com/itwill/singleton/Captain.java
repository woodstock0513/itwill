package com.itwill.singleton;

//싱글턴 (singleton) : 힙에 오직 한 개만 존재하는 객체
//
//싱글턴 디자인 패턴 (singleton design pattern)
//객체가 오직 한개!
//클래스를 설계할 때 객체를 오직 하나만 생성할 수 있도록 작성하는 디자인 패턴
// (1) private static field
// (2) private constructor(생성자)
// (3) public static method

public class Captain {
	// (1)
	private static Captain instance = null; //메서드에서 힙의 주소를 저장하는 용도(처음엔 null).
	//메서드에 instance = null이 저장.
	
	private String name;
	
	// (2)
	private Captain () {
		this.name = "Cap";
	} //main에서 부를 수 없음.
	
	// (3) 
	public static Captain getInstance() { //main에서 부를 수 잇름.
		//main입장에선 captin 소환없이 메서드 호출해야함 -> static 붙여야만..
		if (instance == null) { //insatance 메서드 영역에 잇듬.. 
			instance = new Captain(); //null에 new Captin의 주소 저장!
		}
		return instance; //주소 리턴
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
