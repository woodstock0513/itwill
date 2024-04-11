package com.itwill.file08;

import java.io.File;

//파일, 폴더(디렉토리) 관리 - 정보, 생성, 삭제 ...
//현재 작업 폴더(CWD: Current Worjing Directory):
// 현재 프로그램(프로세스)가 실행되는 폴더 위치.
// 이클립스에서 자바 프로그램을 실행(run as Java application)할 때, 현재 작업 폴더의 위치는 프로젝트 폴더
//
//절대 경로(absolute path)
// - 시스템의 루트(C:\, D:\, /)부터 파일 또는 폴더가 있는 위치까지를 찾아가는 방식
// - (Windows 예) C:\Users\itwill\git\itwill\lab12_file\data\hello.txt
// - (Linux, MacOS 예) /users/itwill/documents/hello.txt
//
//상대경로(relative path)
// 현재 작업 폴더를 기준으로 파일이나 폴더 위치를 찾아가는 방식.
//(Windows 예) data\hello.txt
//(Linux, MacOS 예)documents/hello.txt
//현재 폴더(디렉토리): . 사용 예).\data\hello.txt
//생략해도 되니까 거의 사용하지 않음
//상위 폴더(디렉토리): .. 사용 녜) ..\src\com\itwill\file08\FileMain08.java
//은근많이사용
//파일 구분자(file separator) : 상위 폴더와 하위 폴더, 폴더와 파일을 구분하기 위한 기호
//Windows : \  다른  OS (Linux, MacOS) : /
//문자열("") 안에서 백슬래쉬는 특별한 의미가 있음. 탈출문자(escape 문자열)이다.
//\뒤의 문자 하나는 탈출함.(문자열취급?이안됨)
//"\"를 쓰고 싶으면 \\. 두번 써야함.
// o \n : 줄바꿈. \t: 탭(tab). \s: 공백(space)
// o Windows 파일 경로 : C:\\Users\\itwill\\git... 이런 식
// o Linux, MacOs는 딱히 차이 X :  /users/itwill/git...
public class FileMain08 {

	public static void main(String[] args) {
		// 이클립스에서 자바 프로그램이 실행되는 현재 작업 디렉토리(CWD)
		String cwd = System.getProperty("user.dir"); //현재작업디렉토리보여줌
		System.out.println("CWD : "+cwd); 
		
		String path = "C:\\Users\\itwill\\git\\itwill\\lab12_file"; //Windows 절대 경로 표현법
		// \하나여도 복붙하면 2개 됨.
		
		System.out.println(path);
		
		
//		String path2 = "data\\hello.txt"; //Windows 상대 경로 표현법
		//하지만 좋은 표현이 아님.... windows에서만 사용 가능하기 때문
		String path2 = "data"+File.separator+"hello.txt"; //-> OS에 무관한 상대경로 표현법
		//시스템에 따라 달라지는 구분자를 넣어준다. 
		System.out.println(path2);
		
		//File 클래스:
//		파일과 폴더를 모두 포함해서 말하기도 함
		//좁은 의미의 파일(txt, jpg, mp4, ...)과 폴더(디렉토리)에 관련된 기능들을 가지고 있는 클래스.
		//파일 타입의 객체 생성 - 파일(과 폴더)을 관리할 수 있는 객페 생성
		
		File f = new File(path2);
		
		File FF = new File("test/abc.txt"); // abc라는 파일을 관리하는 객체 생성, 
		//경로들은 상대경로, 현재 작업 공간 아래로 절대 경로, 그러나 존재하지는 않음
		
		
		//file 객체와 물리적인 file 구분 잘 할 것!!  file 객체는 파일들을 관리하는 기능.을 가진 것.
		System.out.println("경로 : "+f.getPath()); //완전 막 맨날 상대경로 이런건 아님. 뒤에서 설명
		
		System.out.println("절대 경로 : "+f.getAbsolutePath()); //모든 route를 보여줌
		
		System.out.println("존재 여부 : "+f.exists());
		System.out.println("파일 여부 : "+f.isFile());
		System.out.println("폴더 여부 : "+f.isDirectory());
		System.out.println("파일 크기 : "+ f.length()); //바이트 단위

		// 새 폴더 만들기
		File testFolder = new File("test");

		if (testFolder.exists()) {
			System.out.println("존재");
		}else { //만들기
			testFolder.mkdir(); //makedirectory
			System.out.println("생성 성공");
		}
		
		//폴더 삭제하기
		if (testFolder.exists()) {
			testFolder.delete();
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 불가");
		}
	}

}
