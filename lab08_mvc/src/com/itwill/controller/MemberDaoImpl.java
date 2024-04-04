package com.itwill.controller;

import com.itwill.model.Member;
//MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스. -> 싱클턴으로 구현!!!
public class MemberDaoImpl implements MemberDao {
	//-------singleton 구현 start
	private static MemberDaoImpl instance = null; //만들어진 객체의 주소값을 저장하는 변수, 인스턴스
	
	private MemberDaoImpl () {} //오직 이 클래스 안에서만 사용 가능.
	
	public static MemberDaoImpl getInstance() { //객체가 없을 때 호출해야하니까 스태틱!!!
		if (instance ==null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}
	//이 메서드 자체는 여러번 호출될 수 있지만, 객체 생성은 딱 한 번만!!
	//-------singleton 구현!!!
	
	//회원 정보를 저장할 배열 선언.
	private Member[] members= new Member[MAX_LENGTH]; //Dao에서 선언햇엇기 때문에 아무런 문제 없이 바로 쓸 수 잇듬.(프라이빗도 아님)
	
	//회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열인덱스)
	private int count=0 ;  //배열에 원소가 추가될 때마다 ++.
	

	@Override
	public int create(Member member) {
		if (count < MAX_LENGTH) {
			members[count] = member;
			count++;
			return 1;
		} else {
			return 0;
		}
		
	}

	@Override
	public Member[] read() {
		//배열 members의 원소들 중 null이 아닌 원소들로만 이루어진 배열을 리턴(새로배열만들어서리턴)
		if (count<MAX_LENGTH) {					 //굳이 if else로 안나눠도댐..
			Member[] mem = new Member[count];
			for (int i = 0 ; i<count ; i++) {
				mem[i] = members[i];
			}
			return mem;
		} else {
			return members;
		}
	}
	
	//새로운 배열을 만들어야하는 이유 - 반환 타입이 멤버 배열이라 무조건 배열은 리턴해야하는데
	// 원래 있는 members를 변형하지 않는 이상(null인 뒷부분 자르기), 새로운 배열을 만들어야함
	//원래 잇는 배열 변형하는 법은 안 배움-
	
	@Override
	public Member read(int index) {
		if (0<=index && index <MAX_LENGTH ) {//count보다 작다로 하는게 나을듯
			return members[index];
		} else {
			System.out.println("인덱스 범위가 잘못되었습니다.");
			return null;
		}
	}

	@Override
	public int update(int index, String password) {
		if (0<=index && index <count && (password !=null)) {
			members[index].setPassword(password);
			return 1;
		} else {
			return 0;
		}
	}

}
