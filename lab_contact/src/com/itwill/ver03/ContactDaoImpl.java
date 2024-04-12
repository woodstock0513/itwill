package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {

	private static ContactDaoImpl instance = null;

	private ContactDaoImpl() {}

	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}

	private int count = 0;

	private List<Contact> contacts = new ArrayList<>(); //다형성

	public boolean isValidIndex(int index) {
		return (index<=count); //이걸 size로!!
	}
	
	@Override
	public int create(Contact contact) {
		if (contact != null) {
			contacts.add(contact);
			count++;
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {
		return contacts.get(index);

	}

	@Override
	public int update(int index, Contact contact) {
		// 이름 하나만 바꾸고 싶을땐..
//		contacts.get(index).setName(contact.getName());
		//단. null point exception 주의
		
		if (0 <= index && index < count && contact!=null) {
			contacts.add(index, contact);
			contacts.remove(index+1); //수정하는게 set!!!
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (0 <= index && index < count) {
			contacts.remove(index);
			return 1;
		} else {
			return 0;
		}

	}

}