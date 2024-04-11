package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain06 {

	public static void main(String[] args) {
		// Student 백만개를 저장하는 더미 데이터(AL) 생성
		ArrayList<Student> students = new ArrayList<>();

		for (int i = 0; i < 1000000; i++) {
//			students.add(new Student(i,"name_"+i, new Score())); 이케 한 줄 말고 나눠서 해도 ㄱㅊ
			Random rand = new Random();
			Score score = new Score(rand.nextInt(101), rand.nextInt(101), rand.nextInt(101));
			Student student = new Student(i, "name_" + i, score);
			students.add(student);
		}

		System.out.println("first : " + students.getFirst());
		System.out.println("last : " + students.getLast());

		// 더미 데이터를 파일에 씀. 파일에 쓰는 데 걸린 시간 측정.

		final String fileName = "data/students.dat";

		try (
			FileOutputStream out = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
		) {
			long start = System.currentTimeMillis(); // 시작시간
			oos.writeObject(students); // 파일 쓰기
			long end = System.currentTimeMillis(); // 종료시간
			System.out.println("저장 완료");
			System.out.println("저장 소요 시간 : " + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 파일에서 데이터를 읽음. 파일을 읽는 데 걸리는 시간 측정

		try (
				
			FileInputStream in = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(in);
			ObjectInputStream ois = new ObjectInputStream(bis);
		) {
			long start = System.currentTimeMillis();
			ArrayList<Student> st = (ArrayList<Student>) ois.readObject();
			long end = System.currentTimeMillis();
			System.out.println(st.size());
			System.out.println("first : " + st.getFirst());
			System.out.println("last : " + st.getLast());
			
			System.out.println("복사 소요 시간 : " + (end - start) + "ms");
			System.out.println("복사 완료");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
