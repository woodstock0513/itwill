package com.itwill.view;

import java.util.Scanner;

import com.itwill.controller.MemberDaoImpl;
import com.itwill.model.Member;

//MVC 아키텍쳐에서 View(UI : User Interface)역할을 담당하는 클래스.
public class MemberMain {

	private Scanner scanner = new Scanner(System.in);
	private MemberDaoImpl dao = MemberDaoImpl.getInstance(); // 컨트롤러

//	private MemberDao dao = MemberDaoImpl.getInstance(); 라고 해도 됨.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***회원 관리 프로그램***");
		// MemberMain 타입 객체의 인스턴스 멤버(필드,메서드)를 사용하기 위해 호출.
		MemberMain app = new MemberMain();

		boolean run = true; // 프로그램 종료할 때 false로 변경

		while (run) {
			int menu = app.selectMainMenu();

			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewMember();
				break;
			case 2:
				app.readAllMembers();
				break;
			case 3:
				app.readMemberByIndex();
				break;
			case 4:
				app.updateMember();
				break;

			default:
				System.out.println("0~4 범위의 정수로 다시 입력해주세요");
			}
		}
		System.out.println("\n***프로그램 종료***");
	}

	private void updateMember() {
		System.out.println("\n----비밀번호 변경----");

		System.out.print("수정할 인덱스 입력 >> ");
		int index = Integer.parseInt(scanner.nextLine());

		Member member = dao.read(index);

		if ((member == null)&& index < dao.MAX_LENGTH) {
			System.out.println("정보가 없습니다.");
		} else if (member == null) {
			
		} else {
			System.out.println("수정 전 : " + member);

			System.out.print("새 비밀번호 입력 >> ");
			String password = scanner.nextLine();

			// view에서 컨트롤러의 기능을 사용해서 비밀번호 업데이트
			int result = dao.update(index, password);
			if (result == 1) {
				System.out.println("수정 후 : " + member);
			} else {
				System.out.println("실패했습니다. 다시 시도해주십시오.");
			}
		}
	}

	private void readMemberByIndex() {
		System.out.println("\n----인덱스 검색 기능----");

		System.out.print("인덱스 입력 >> ");
		int index = Integer.parseInt(scanner.nextLine());

		// view에서 컨트롤러의 기능을 사용해서 해당 인덱스의 회원 정보를 가져옴.
		Member m = dao.read(index);
		if (m != null) {
			System.out.println(m);
		} else if (index<0 || index>dao.MAX_LENGTH){
			
		} else {
			System.out.println("회원 정보가 없습니다.");
		}
	}

	private void readAllMembers() {
		System.out.println("\n----회원 목록----");
		Member[] members = dao.read(); // 뷰에서 컨트롤러 기능을 사용, 출력할 데이터를 가져옴.
		// members에 dao의 정보들 들어감
		for (Member m : members) {
			System.out.println(m);
		}
	}

	private void saveNewMember() {
		System.out.println("\n----새 회원 정보 저장----");

		System.out.print("ID를 입력하세요 : ");
		String id = scanner.nextLine();

		System.out.print("PassWord를 입력하세요 : ");
		String password = scanner.nextLine();

		Member member = new Member(id, password);

		int result = dao.create(member); // View 객체에서 Controller 객체의 기능을 사용.

		if (result == 1) {
			System.out.println("회원 정보 저장 성공");
		} else {
			System.out.println("회원 정보 저장 실패");
		}

	}

	int selectMainMenu() { // 안 쓰면 퍼블릭, private 써	도 됨
		System.out.println("----------------------------------------------");
		System.out.println("[0]종료 [1]입력 [2]목록 [3]인덱스 검색 [4]수정");
		System.out.println("----------------------------------------------");
		System.out.print("입력 >> ");
		int menu = Integer.parseInt(scanner.nextLine());
		return menu;
	}

}
