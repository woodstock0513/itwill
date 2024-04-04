package com.itwill.modifier02;

import com.itwill.modifier01.AccessExample;
//다른 패키지에서 선언된 class 이름으로 변수를 선언하려면
//(1)import 문장을 작성하고 변수 선언에서 클래스 이름만 사용하거나
//(2)import 문장 없이 패키지 이름을 포함한 전체 클래스 이름으로 변수를 선언함.
//같은 패키지 안에 있으면 import 안해도 됨.
//java.lang 패키지에 포함된 클래스들은 import 문장 없이 클래스 이름만으로 변수 선언 가능
//ex) java.lang.String java.lang.System. ...  필수적인애들
public class ModifierMain02 {

	public static void main(String[] args) {
		// com.itwill.modifier01.AccessExample 타입의 객체를 생성
		AccessExample ex = new AccessExample(1, 2, 3, 4); // 방법1
//		com.itwill.modifier01.AccessExample ex = new com.itwill.modifier01.AccessExample(1, 2, 3, 4); //방법2
		System.out.println(ex.d);
//		System.out.println(ex.b); // 컴파일 에러 발생 : b is not visible
		ex.d=10;
		System.out.println(ex.d);
		
		ex.info();
	}

}
