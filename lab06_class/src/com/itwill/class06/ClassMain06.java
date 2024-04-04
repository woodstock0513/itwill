package com.itwill.class06;

public class ClassMain06 {

	public static void main(String[] args) {
		// Account type 객체 생성
		Account acc = new Account(172601, 0);
		Account acc2 = new Account(69198, 1000);

		// acc에 10000 입금
		System.out.println("입금 후 잔액: " + acc.deposit(10_000));

		// acc에서 5000 출금
		acc.withdraw(5000);
		acc.info();

		// acc에서 acc2로 2000원 이체
		acc.transfer(acc2, 2_000);

		acc.info();
		acc2.info();

		// acc2에서 acc로 4000원 이체
		acc2.transfer(acc, 4_000);

		acc.info();
		acc2.info();

	}

}
