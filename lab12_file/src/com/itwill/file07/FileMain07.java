package com.itwill.file07;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;

//IO Stream : 바이트 스트림(byte Stream) 읽기 쓰기의 기본 단위는 바이트 단위
//모든 종류의 파일에서 사용 가능.
//InputStream
//|__FileInputStream, BufferedInputStream, ObjectInputStream
//OutputStream
//|__FileOutputStream, BufferedOutputStream, ObjectOutputStream
//Reader, Writer : 문자 스트림 (character Stream) 읽기 쓰기의 기본 단위는 "문자(character)"
// 텍스트파일(txt,csv, ...) 에서만 사용 가능.
//
//Reader
//|__InputStreamReader, BufferedReader
//	|__FileReader
//Writer
//|__OutputStreamWriter, BufferedWriter
//	|__FileWriter
//
//인코딩(encoding) : 문자를 그 문자에 해당하는 코드(정수)값으로 변환 ex) A -> 65
//디코딩(decoding) : 문자 코드(정수)를 그 코드에 해당하는 문자로 변환 ex) 65 -> A
//운영체제(OS)마다 기본 인코딩 방식이 다름.
//리눅스,유닉스, 맥 :  UTF-8
//한글 MS windows : MS949(CP949,EUC-KR) 몇개만 제외하고 거의 비슷!, 
//영문 MS windows : CP1252 . 같은 윈도우지만 다름....


public class FileMain07 {

	public static void main(String[] args) throws IOException {
		// 파일 이름
		final String utf8File = "data/utf8.txt"; //utf8인코딩으로 저장한 파일
		final String ansiFile = "data/ansi.txt"; //ansi(ms949) 인코딩으로 저장한 파일
		
		//java 11 이전 (10까지) 버전에서 문자 스트림과 인코딩을 다루는 방법
		//FileReader, FileWriter 클래스 생성자에서 인코딩 타입을 설정 불가.
		//1. FileInputStream(바이트 스트림) 객체 생성 (필수)
		FileInputStream in = new FileInputStream(ansiFile);
		
		//2. 인코딩을 설정한 InputStreamReader 객체를 생성 (필수)
		InputStreamReader isr = new InputStreamReader(in, "EUC-KR");  //EUC-KR이 바뀌면 안됨!!!!!!
		
		//3. 옵션! 읽기 속도를 빠르게 하기 위해 버퍼(메모리)를 사용
		BufferedReader reader = new BufferedReader(isr); //아규먼트-Reader!!
		
		while (true) { //무한루프
			int read = reader.read(); //파일에서 1글자를 읽음
			
			if (read == -1) { //EOF
				break;
			}
			System.out.print((char)read);
		}
		System.out.println();
		//try 안 썼으니까 close 해줘야함!!!
		reader.close(); //리소스 해제
		
		//java 11 버전부터 FileReader, FileWriter 클래스에서 인코딩을 설정할 수 있는 생성자를 제공하기 시작.
		//1. FileReader 객체를 생성할 때 인코딩 방식을 설정 (필수) 
		FileReader fr = new FileReader(utf8File, Charset.forName("UTF-8"));
		
		//2. 옵션! 읽기 속도를 빠르게 하기 위해 버퍼(메모리)를 사용
		BufferedReader br = new BufferedReader(fr);
		
		
		
		while (true) {
			String line = br.readLine(); // 한줄씩 읽기
			if (line==null) { //EOF
				break;
			}
			System.out.println(line);
		}
		
		
//		
//		while (true) {
//			int read = br.read(); //한글자씩 읽기
//			if (read == -1) {
//				break;
//			}
//			System.out.print((char)read);
//		}
//		System.out.println();
//		
		br.close(); // 리소스 해제
		
		
		
	}

}
