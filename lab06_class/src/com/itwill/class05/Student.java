package com.itwill.class05;

public class Student {
    // field
    int id; // 학생 번호
    String name; // 학생 이름
    Subject subject; // 수강 과목
//	Subject subject = new Subject();  //이러면 Subject는 절대 null이 나오지 않음
//    기본 생성자 보다 먼저 발생. 아규먼트를 갖는 생성자 사용 시 재할당됨.
//    그래도 null point exception은 발생할 수 있음 - 아규먼트를 갖는 생성자 사용시 null 넣을 때. -> 얘도 고려해야
    
    // TODO 생성자: (1)기본 생성자. (2)아규먼트를 갖는 생성자.
    public Student () {}
    
    public Student (int id, String name, Subject subject) {
    	this.id = id;
    	this.name = name;
    	this.subject = subject;	  
    }
    
    public Student (int id, String name,int korean, int english, int math , int science) {
    	this.id = id;
    	this.name = name;
    	this.subject = new Subject ( korean, english, math , science);
    }
    //이런식으로도 가능!!!
    
    
    
    // TODO 메서드: 학생의 정보(번호, 이름, 각 과목의 점수, 총점, 평균)를 출력.
    public void inform () {
    	System.out.println("---------------------");
    	System.out.println("학생의 번호 : "+id);
    	System.out.println("학생의 이름 : "+name);
    	if (subject != null) {
    		subject.info();
//    		System.out.println("학생의 국어 점수 : "+subject.korean);
//        	System.out.println("학생의 수학 점수 : "+subject.math);
//        	System.out.println("학생의 영어 점수 : "+subject.english);
//        	System.out.println("학생의 과학 점수 : "+subject.science);
//        	System.out.println("학생의 총점수 : "+ subject.total());
//        	System.out.println("학생의 평균 점수 : "+subject.mean()); //얘네 다 합쳐서 subject.info 라고 할 수 잇음
    	} else {
    		System.out.println("Subject : null");
    	}
    	System.out.println("---------------------");
    }
    
    
    
}