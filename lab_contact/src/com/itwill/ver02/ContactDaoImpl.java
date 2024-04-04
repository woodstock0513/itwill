package com.itwill.ver02;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
	int count = 0;
	Contact[] contacts = new Contact[MAX_LENGTH];

	public boolean isValidIndex(int index) {
		return ((0 <= index) && (index < count));
	}

	public int create(Contact contact) {
		if (count < MAX_LENGTH) {
			contacts[count] = contact;
			count++;
			return 1;
		} else {
			return 0;
		}
	}

	public Contact[] read() {
		if (count == 0) {
			return null;
		}
		Contact[] result = new Contact[count];
		for (int i = 0; i < count; i++) {
			result[i] = contacts[i];
		}
		return result;
	}

	public Contact read(int index) {
		if (isValidIndex(index)) {
			return contacts[index];
		} else {
			return null;
		}

	}

	public int update(int index, Contact contact) {
		if (isValidIndex(index)) {
			contacts[index] = contact;
			return 1;
		} else {

			return 0;
		}

	}

}
