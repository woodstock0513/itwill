package com.itwill.ver02;

import java.util.Scanner;

import com.itwill.ver01.Contact;

//MVC 아키텍쳐에서 view 역할을 담당. 입출력만 하면 됨.
//모델, 컨트롤러 사용
public class ContactMain02 extends ContactDaoImpl {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("***연락처 프로그램v0.2***");

		boolean run = true;

		ContactMain02 app = new ContactMain02();

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
			}

		}

		System.out.println("***프로그램 종료***");

	}

	private void updateConTactByIndex() {
		System.out.print("수정할 인덱스 입력 >> ");
		int index = Integer.parseInt(sc.nextLine());
		if (isValidIndex(index)) {
			System.out.println("수정할 정보 입력");
			Contact con = new Contact();
			System.out.print("name : ");
			con.setName(sc.nextLine());
			System.out.print("phone : ");
			con.setPhone(sc.nextLine());
			System.out.print("email : ");
			con.setEmail(sc.nextLine());

			update(index, con);
		} else {
			System.out.println("유효하지 않은 인덱스입니다.");
		}

	}

	private void readContactByIndex() {
		System.out.print("확인할 인덱스 입력 >> ");
		int index = Integer.parseInt(sc.nextLine());
		Contact con = read(index);
		if (con == null) {
			System.out.println("선택할 수 없는 인덱스입니다.");
		} else {
			System.out.println(con);
		}
	}

	private void readAllContacts() {
		Contact[] contacts = read();
		if (contacts == null) {
			System.out.println("저장된 정보가 없습니다.");
		} else {
			for (Contact con : contacts) {
				System.out.println(con);
			}
		}

	}

	private void saveNewContact() {
		if (count < MAX_LENGTH) {
			Contact con = new Contact();
			System.out.print("name : ");
			con.setName(sc.nextLine());
			System.out.print("phone : ");
			con.setPhone(sc.nextLine());
			System.out.print("email : ");
			con.setEmail(sc.nextLine());
			create(con);
		} else {
			System.out.println("저장 공간이 없습니다.");
		}

	}

	public int showMainMenu() {
		int num;
		try {
			System.out.println("\n---------------------------------------------");
			System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
			System.out.println("---------------------------------------------");
			System.out.print("선택 >> ");
			num = Integer.parseInt(sc.nextLine());
			if (0 <= num && num <= 4) {
				return num;
			} else {
				System.out.println("0~4사이를 입력하세요.");
				return showMainMenu();
			}
		} catch (Exception e) {
			System.out.println("정수를 입력하세요");
			return showMainMenu();
		}
	}

}
