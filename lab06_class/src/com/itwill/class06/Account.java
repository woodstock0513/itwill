package com.itwill.class06;

/**
 * 클래스에 대한 문서 주석
 * 은행 계좌 정보.
 * 속성 : 계좌 번호, 잔고. //변수-필드
 * 기능 : 입금, 출금, 이체, 정보출력. // 메서드
 */
public class Account {
	//field
	int accountNo; // 계좌번호
	int balance=0;// 잔고
	
	
	//constructor : 아규먼트 2개를 갖는 생성자
	public Account (int accountNo, int balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	
	
	// method 4개
	/**
	 * deposit(입금). 현재 잔고에 입금액을 더하고 입금 후의 잔액을 리턴.
	 * @param amount : 입금액 int
	 * @return 입금 후 잔고(balance) int
	 */
	public int deposit(int amount) {
		return balance += amount;
	}
	
	/**
	 * withdraw(출금). 현재 잔고에서 출금액을 빼고, 출금 후의 잔고를 리턴.
	 * @param amount 출금액 int
	 * @return 출금 후 잔액 int
	 */
	public int withdraw (int amount) {
		return balance -= amount;
	}
	
	
	/**
	 * transfer(이체). 내 계좌의 잔고에서는 이체금액을 빼고 이체할 계좌(to)의 잔고에 이체금액을 더한다. 
	 * @param to : 이체할 계좌. Account type
	 * @param amount 이체할 금액 int
	 * @return true
	 */
	public boolean transfer(Account to, int amount) {
		this.withdraw(amount);
		to.deposit(amount);
		return true;
	}
	
	
	/**
	 * 계좌 정보 출력
	 */
	public void info() {
		System.out.println("----계좌 정보----");
		System.out.println("계좌 번호 : "+accountNo);
		System.out.println("잔고 : "+balance);
	}
}
