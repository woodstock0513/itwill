package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//입/출력 스트림 (Input/Output Stream) : 프로그램에서 값을 입력받거나 출력하는 통로
//(예) System.in : 입력 스트림 객체
//(예) System.out : 출력 스트림 객체
// 프로그램 <=== InputStream === 입력장치(키보드,콘솔,파일,...)
// 프로그램 === OutputStream ===> 출력장치(모니터,프린터,파일,...)
//
//프로그램 <=== FileInputStream === 파일
//프로그램 === FileOutputStream ===> 파일
//
//java.io.InputStream : 프로그램이 데이터를 읽어들이는 통로
//|__FileInputStream : 프로그램이 파일에서 데이터를 읽어들이는 통로
// (1) FileInputStream 객체 생성
// (2) FIS 객체의 read 관련 메서드 호출
// (3) FIS 객체를 닫음(close) *필수!!!
//
//java.io.OutputStream : 프로그램에서 데이터를 쓰는(출력하는) 통로
//|__FileOutputStream : 프로그램에서 파일에 데이터를 쓰는 통로
//(1) FileOutputStream 객체 생성
//(2) FOS 객체의 write 관련 메서드 호출
//(3) FOS 객체를 닫음(close) *필수!!!

public class FileMain01 {

	public static void main(String[] args) {
		String origin = "data/hello.txt"; // 원본파일(읽을파일) 이름. 경로/이름 형식으로 작성(프로젝트 이름 생략)
		String destination = "data/hello_copy.txt"; // 복사할 파일 이름. 경로/이름

		FileInputStream in = null; // 선언만 밖에서!!!!!
		FileOutputStream out = null;
		try {
			in = new FileInputStream(origin); // 파일이 없는 경우를 대비해 try-catch
			out = new FileOutputStream(destination); //output 하기 위해.. FOS 객체 생성
			while (true) {
				int read = in.read(); // 파일에서 한바이트만 읽음.
				if (read == -1) { //파일 끝(end of file. EOF)에 도달했을 때 break
					break;
				}
				out.write(read); //print문 말고, write를 사용!!
				//파일에 읽은 1바이트를 씀.
//				System.out.print((char) read);
			}
			System.out.println("파일 복사 성공");
//			in.close(); // try에 있으면 exception 발생 시 안 닫힘.. -> finally이용!!!!을 못함.. 지역변수 이슈 -> 선언을 밖에서 하기. 호출은 안에서 해야함
		} catch (Exception e) { // FileNotFoundException보다 상위여서 멀티 캐치인데 부모타입(IOException)만 쓴거. 걍 Exception만 써도
								// 됨.
			e.printStackTrace();
		} finally {
			try {
				in.close(); //FIS 객체를 닫음. (리소스 해제)
				out.close(); //FOS 객체를 닫음. (리소스 해제)
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 3번의 step인데 try-catch 때문에 코드가 길어지는거,,
	}

}
