package com.itwill.file02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMain02 {

	public static void main(String[] args) throws Exception {
		// 대용량 파일 복사:
		// data/ratings.dat 파일을 읽고 data/ratings_copy.dat 파일에 복사
		//throw절 이용하기!
		//(1) read(), write(int b)메서드를 사용할 때의 시간 측정
		
		
		//(2) 다른 read/write 메서드를 사용할 때 시간 측정
		
		
		String origin = "data/ratings.dat"; //원본 파일
		String dest = "data/ratings_copy.dat"; //복사할 파일
		
		FileInputStream in = new FileInputStream(origin);
		FileOutputStream out = new FileOutputStream(dest);
		
		long start = System.currentTimeMillis(); //파일 복사를 시작한 시작 시간 측정
		
		while (true) {
			//(1) read()
//			int b = in.read(); //4byte 저장 공간(int)에 하나만 채우고 나머지는 0 채워서 리턴. 
			
			//(2) read(byte[] b)
			byte[] buffer = new byte[4*1024]; //4096byte = 4KB 크기의 빈 배열 생성
			int b = in.read(buffer);
			//-> buffer : 파일에서 읽는 내용을 저장하기 위한 바이트 배열/
			//-> 리턴 값 : 파일에서 실제로 읽은 바이트 수
			if (b==-1) { //EOF
				break; //무한루프 종료
			}
			//(1) write(int b)
//			out.write(b); // 맨 앞에 잇는 저장된 것만 write. 파일에 1바이트 씀
			
			//(2) write(byte[] b)
//			out.write(buffer); //-> 바이트 배열의 내용을 그대로 파일에 씀. 4KB를 파일에 씀
			
			//write(byte[] buf, int off, int len)
			out.write(buffer, 0, b);
			//-> byte[] buf : 파일에 쓸 데이터를 가지고 있는 바이트 배열
			//-> int off : 배열 b에서 읽기 시작할 인덱스. offset 0이면 처음부터 끝까지 다 쓰겟다는 의미.
			//-> int len : length 배열에서 실제로 파일에 쓸 바이트 길이
		
		}
		
		long end = System.currentTimeMillis(); //파일 복사가 끝난 시간 측정
		
		System.out.println("복사 경과 시간 : " + (end-start)+"ms");
		
		in.close();
		out.close();
		

	}

}
