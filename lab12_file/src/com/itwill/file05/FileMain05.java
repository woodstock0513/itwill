package com.itwill.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file04.Product;

public class FileMain05 {

	public static void main(String[] args) {
		//파일에 쓸 더미 데이터
		ArrayList<Product> list = new ArrayList<>();
		for (int i = 0; i<1000000;i++) {
			list.add(new Product(i, "name_"+i, i*10));
		}
		
		System.out.println(list.size());
		
		//ArrayList를 저장하는 파일 이름 
		String fileName = "data/product_list.dat";
		
		// Product 타입 객체 1,000,000개(백만개)를 저장하는 ArrayList를 파일에 쓰기
		//FOS, BOS, OOS를 이용
		
		try(
				FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
		){
			
			oos.writeObject(list);
			
			System.out.println("성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파일에서 객체를 읽어서 ArrayList<Product>로 변환하기
		//FIS, BIS, OIS를 이용
		
		try(
			FileInputStream in = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(in);
			ObjectInputStream ois = new ObjectInputStream(bis);
		){
			ArrayList<Product > p = (ArrayList<Product>) ois.readObject();
			System.out.println(p);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
