package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
	private static final int MAX_LENGTH = 3; // 연락처 배열의 최대 길이(최대 원소의 개수)
	private Scanner scanner = new Scanner(System.in); // 여기저기서 메서드에 이용하기 때문에 필드에 선언
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 일반적인 배열 선언이랑 똑같음!
	// 연락처를 저장하기 위한 배열

	private int count = 0; // 현재까지 연락처 배열에 저장된 개수. "배열"이기 때문에 사용
	// 배열에 새로운 연락처가 저장될때마다 count++을 실행. 인덱스 번호.

	public static void main(String[] args) {

		System.out.println("*** 연락처 프로그램 v0.1");

		ContactMain app = new ContactMain(); // class에 있는 내용들 사용할 준비.

		boolean run = true; // 프로그램 계속 실행

		while (run) {

			int menu = app.showMainMenu();

			switch (menu) {
			case 0:
				run = false;
				break; // switch문!!! break
			case 1:
				// 새로운 연락처 저장.
				app.saveNewContact();
				break;
			case 2:
				// 목록 보기
				app.readAllContacts();
				break;
			case 3:
				// 인덱스 검색
				app.readContactByIndex();
				break;
			case 4:
				// 수정
				app.updateConTactByIndex();
				break;
			default:
				System.out.println("메뉴 번호(0 ~ 4)를 확인하세요.");
			}

		}
		System.out.println("\n***프로그램 종료***");
	}

	private void updateConTactByIndex() {
		System.out.println("\n---------연락처 수정---------");
		System.out.print("인덱스 입력 >> ");
		int index = Integer.parseInt(scanner.nextLine());

		if (index < 0 || index > count) {
			System.out.println("수정할 연락처가 없습니다.");
			return;
		}

		System.out.println("수정 전 : " + contacts[index].toString());

		System.out.print("이름 수정 >> ");
		String name = scanner.nextLine();
		contacts[index].setName(name);

		System.out.print("번호 수정 >> ");
		String phone = scanner.nextLine();
		contacts[index].setPhone(phone);

		System.out.print("이메일 수정 >> ");
		String email = scanner.nextLine();
		contacts[index].setEmail(email);

		System.out.println("수정 후 : " + contacts[index].toString());

	}

	private void readContactByIndex() {
		System.out.println("\n---------인덱스 검색---------");
		System.out.print("인덱스 입력 >> ");
		int index = Integer.parseInt(scanner.nextLine());

		if (0 <= index && index < count) {
			System.out.println(contacts[index].toString());
		} else {
			System.out.println("저장된 연락처가 없습니다.");
		}
	}

	private void readAllContacts() {
		System.out.println("\n---------목록 보기---------");
//		for (Contact c : contacts) { //배열 개수가 최댓값보다 작으면 null.. -> 향상된 for문 안댐, if문으로 써도 되긴 함
//			System.out.println(c.toString());
//		}
		for (int i = 0; i < count; i++) {
			System.out.println(contacts[i].toString());
		}
	}

	private void saveNewContact() {
		System.out.println("\n---------새 연락처 저장-----------");

		// 배열에 저장된 연락처 개수(count)가 배열 최대 길이와 같다면 저장 기능을 종료.
		if (count == MAX_LENGTH) {
			System.out.println("저장 공간이 부족합니다.");
			return; // void 타입이므로 메서드를 끝낸다는 의미.
		}

		System.out.print("이름을 입력하세요 >> ");
		String name = scanner.nextLine();

		System.out.print("전화번호를 입력하세요 >> ");
		String phone = scanner.nextLine();

		System.out.print("이메일을 입력하세요 >> ");
		String email = scanner.nextLine();

		Contact contact = new Contact(name, phone, email);

		if (count < MAX_LENGTH) {

			// Contact 타입 객체를 연락처 배열 인덱스 count에 저장한다.
			contacts[count] = contact;

			// 배열 저장 후에는 연락처 저장 개수(인덱스)를 증가
			count++;
		} else {
			System.out.println("더 이상 저장할 수 없습니다.");
		}
	}

	private int showMainMenu() {
		System.out.println("\n---------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("---------------------------------------------");
		System.out.print("선택 >> ");
		int menu = Integer.parseInt(scanner.nextLine());
		return menu;
	}

}