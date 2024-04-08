package com.itwill.list05;

import java.util.ArrayList;

public class ListMain05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Member> members = new ArrayList<Member>();

		// members에 원소 저장.
		members.add(new Member("admin", "7845"));// Member m = new Member("",""); 일케 안하고 아규먼트 자리에 걍 추가해도 ㄱㅊ
		members.add(new Member("guest", "1234"));
		members.add(new Member("itwill", "0314"));
		members.add(new Member("TEST", "test"));
		members.add(new Member("guest", "0513"));
		
		//향상된 for문을 사용해서 members의 원소들을 출력
		for (Member m : members) {
			System.out.println(m);
		}
		
		
		//회원 id에 est가 포함된 회원 정보를 다른 리스트에 저장하고 출력 (대소문자 구분 X)
		ArrayList<Member> est = new ArrayList<>();
		for (Member m : members) {
			if (m.getId().toLowerCase().contains("est")) {
				est.add(m);
			}
		}
		System.out.println(est);
		
		//members에서 첫번째로 등장하는 id가 guest인 회원 삭제 
		
//		for (int i = 0; i<members.size();i++) {
//			if (members.get(i).getId()=="guest") {
//				members.remove(i);
//				break;
//			}
//		}
		
		//for문을 안 써도,, ->해시코드랑 이퀄스 오버라이드 해서!!
		//이퀄스 오버라이드 안 하면 주소값 비교라서 밑의 코드 안됨.
		members.remove(new Member("guest", null)); //equals를 사용. 오브젝트를 리무브.
		
		System.out.println(members);
		
		
		
	}

}
