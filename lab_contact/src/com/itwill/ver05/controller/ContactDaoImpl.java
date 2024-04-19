package com.itwill.ver05.controller;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver05.model.Contact;

//import static 문장 : 클래스에서 public static으로 선언된 멤버(필드,메서드)의 이름을 가져오는 것.
import static com.itwill.ver05.util.FileUtil.*; //모든 멤버들을 다 가져옴
//import static com.itwill.ver04.util.FileUtil.initializeData; // 이렇게 하나하나 가져와도 됨.

//MVC 아키텍쳐에서 Controller 역할 담당 클래스. DAO(Data Access Object). 다오는 컨트롤러 dto는 모델
public class ContactDaoImpl implements ContactDao {
	//----singleton
	private static ContactDaoImpl instance = null;
	
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		} 
		return instance;
	}
	//----singleton
	
	private List<Contact> contacts;
	
	private ContactDaoImpl() {
		//데이터 폴더 초기화 : 폴더가 없으면 새로 만듦.
		initializeDataDir(); //폴더 먼저 만들어놔라.
		
		//연락처 데이터 초기화 : 데이터 파일에서 리스트를 읽어오거나 빈 리스트 생성
		contacts = initializeData(); //FileUtil의 멤버들을 import 했으므로 클래스 이름 생략하고 써도 됨.!!
	}

	/**
	 *  인덱스가 연락처 리스트의 유효한 범위 안에 있는 지를 리턴.
	 * @param index 검사할 인덱스
	 * @return true / false
	 */
	public boolean isValidIndex(int index) {
		return (index>=0) && (index<contacts.size());
	}

	
	//메모리가 파일이랑 동기화 되어 있다는 가정 하에 코드 작성//
	
	@Override
	public int create(Contact contact) {
		contacts.add(contact); //리스트(메모리)에 추가
		writeDataToFile(contacts); //파일에 작성.
		return 1;
	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (isValidIndex(index)) {
			return contacts.get(index);
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if (!isValidIndex(index)) {
			return 0;
		} else {
			contacts.set(index, contact);
			writeDataToFile(contacts); //변경되었으니 파일에도 업데이트 해줘야함
			return 1;
		}
		
	}

	@Override
	public int delete(int index) {
		if (isValidIndex(index)) {
			contacts.remove(index);
			writeDataToFile(contacts);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Contact> search(String keyword) {
		List<Contact> result = new ArrayList<>();
		for (Contact c: contacts) { //대소문자 구분없이 검색하기 위해
			if (c.getName().toLowerCase().contains(keyword.toLowerCase()) 
					|| c.getPhone().toLowerCase().contains(keyword.toLowerCase())
					|| c.getEmail().toLowerCase().contains(keyword.toLowerCase())
					) {
				result.add(c);
			}
		}
		return result;
	}

}
