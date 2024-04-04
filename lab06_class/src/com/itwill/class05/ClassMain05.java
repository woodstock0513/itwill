package com.itwill.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // TODO: Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
    	Subject sub = new Subject();
    	sub.english = 100;
    	sub.korean = 98;
    	sub.math = 74;
    	sub.science = 83;
    	
    	System.out.println(sub.total());
    	System.out.println(sub.mean());
    	
    	Subject sub2 = new Subject(87,85,98,94);
    	System.out.println(sub2.total());
    	System.out.println(sub2.mean());
    	
    	sub2.info();
    	
   
    	
    	//아규먼트를 갖는 생성자를 사용해 Student 타입 객체 생성
    	Student st2 = new Student(14,"Tom",sub2);
    	
    	st2.inform();
    	
    	
     	//기본 생성자를 사용해 Student 타입 객체 생성
    	Student st = new Student(); //전부 다 기본값.
//    	st.id = 25;
//    	st.name = "Jenny";
//    	st.subject = sub;
    	
    	st.inform();
    	
        
    }
    
}