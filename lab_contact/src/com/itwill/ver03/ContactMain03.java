package com.itwill.ver03;

import java.util.List;
import java.util.Scanner;

import com.itwill.ver01.Contact;

public class ContactMain03 {

	private final Scanner scanner = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance(); // 싱글턴

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.3 ***");

		ContactMain03 app = new ContactMain03();

		boolean run = true;
		while (run) {
			int menu = app.selectMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewContact();
				break;
			case 2:
				app.readAllContacts();
				break;
			case 3:
				app.readContactByIndex();
				break;
			case 4:
				app.updateContactByIndex();
				break;
			case 5:
				app.deleteContactByIndex();
				break;
			default:
				System.out.println("메뉴 번호(0 ~ 5)를 확인하세요.");
			}
		}

		System.out.println("*** 프로그램 종료 ***");
	}

	private void deleteContactByIndex() {
		System.out.println("\n--- 연락처 삭제 ---");

		System.out.print("인덱스 입력>> ");
		int index = inputInteger();
		if (!((ContactDaoImpl) dao).isValidIndex(index)) {
			System.out.println("해당 인덱스에는 삭제할 정보가 없습니다.");
			return;
		}
		dao.delete(index);

		ContactMain03 list = new ContactMain03();
		list.readAllContacts();
	}

	private void updateContactByIndex() {
		System.out.println("\n--- 연락처 수정 ---");

		System.out.print("인덱스 입력>> ");
		int index = inputInteger();

		if (!((ContactDaoImpl) dao).isValidIndex(index)) {
			System.out.println("해당 인덱스에는 수정할 정보가 없습니다.");
			return;
		}

		Contact old = dao.read(index);
		System.out.println("수정전: " + old);

		System.out.print("이름 수정>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 수정>> ");
		String phone = scanner.nextLine();

		System.out.print("이메일 수정>> ");
		String email = scanner.nextLine();

		Contact updated = new Contact(name, phone, email);
		
		if ((name.isBlank()) || (phone.isBlank()) || (email.isBlank())) {
			updated = null;
			System.out.println("정보를 모두 입력하세요.");
			
		}
		
		int result = dao.update(index, updated);
		if (result == 1) {
			System.out.println(">>> 연락처 수정 성공");
		} else {
			System.out.println(">>> 연락처 수정 실패");
		}

	}

	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");

		System.out.print("인덱스 입력>> ");
		int index = inputInteger();

		if (!((ContactDaoImpl) dao).isValidIndex(index)) {
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
			return;
		}

		Contact contact = dao.read(index);
		
			System.out.println(contact);
		
	}

	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");

		List<Contact> contacts = dao.read();
		int index = 0;
		for (Contact c : contacts) {
				System.out.println("[" + index + "] " + c);
				index++;
			}
		
	}

	private void saveNewContact() {
		System.out.println("\n--- 새 연락처 저장 ---");

		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();

		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();
		// 공백 입력받은 경우는...

		Contact contact = new Contact(name, phone, email);
		
		if ((name.isBlank()) || (phone.isBlank()) || (email.isBlank())) {
			contact = null;
			System.out.println("정보를 모두 입력하세요.");
		}

		int result = dao.create(contact);
		if (result == 1) {
			System.out.println(">>> 연락처 저장 성공");
		} else {
			System.out.println(">>> 연락처 저장 실패");
		}

	}


	private int selectMainMenu() {
		System.out.println("\n------------------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정 [5]삭제");
		System.out.println("-----------------------------------------------------");
		System.out.print("선택> ");

		int menu = inputInteger();

		return menu;
	}

	private int inputInteger() {
		int result = 0;

		while (true) {
			try {
				result = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력값은 정수여야 합니다.");
				System.out.print("정수 입력>> ");
			}
		}

		return result;
	}

}