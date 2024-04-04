package com.itwill.inheritance02;

public class InheritanceMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BusinessPerson per1 = new BusinessPerson();
		System.out.println(per1.getName() + " : " + per1.getCompany()); // name,company 변수 모두 생성되었음을 확인 가능.

		BusinessPerson per2 = new BusinessPerson("SAMSUNG");
		System.out.println(per2.getName() + " : " + per2.getCompany()); //person은 기본, bp는 company생성자.
		
		BusinessPerson per3 = new BusinessPerson("dy", "hi");
		System.out.println(per3.getName() + " : " + per3.getCompany());
		

	}

}
