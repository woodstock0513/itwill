package com.itwill.class05;

public class Subject {
    // field
    int korean;
    int english;
    int math;
    int science;
    
    // TODO 생성자: (1)기본 생성자. (2)아규먼트를 갖는 생성자.
    public Subject () {}
    
    public Subject (int korean, int english, int math , int science) {//값을 전달받아 저장
    	this.korean = korean; 
    	this.math = math;
    	this.english = english;
    	this.science = science;
    }
    
    // TODO 메서드: (1)총점 리턴. (2) 평균 리턴.
    
    public int total () {
    	return korean + english + math + science; //마찬가지로 this.korean 이런식으로 쓰는게 ㄱㄴ
    	//필드 변수와 지역변수. 파라미터를 구분할 필요가 없으면 this 생략 가능.
    	//필드 변수임을 명시하고 싶다면 쓰면 됨
    }
    
    public double mean () {
    	// (double) this.total () / 4 가능.
    	return (korean + english + math + science) / 4.0;
    }
    
    public void info () {
    	System.out.println("국어 : " + this.korean);
    	System.out.println("영어 : " + this.english);
    	System.out.println("수학 : " + math);
    	System.out.println("과학 : " + science);
    	System.out.println("총점 : " + total());
    	System.out.println("평균 : " + mean());
    	
    }

}