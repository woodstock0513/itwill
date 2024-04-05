package com.itwill.string;

public class StringEx {

	public static void main(String[] args) {
		// String
		// 주민번호에서 성별을 표시하는 위치의 문자열 찾기
		String ssn = "990405-1832545";
		System.out.println(ssn.charAt(7));

		// 문자열 자르기
		String date = "2024-04-05";
		String[] array = date.split("-");
		for (String s : array) {
			System.out.println(s);
		}

		// ex3. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
		// 결과: JavaScript Servlet Spring
		String[] languages = { "Java", "SQL", "JavaScript", "HTML", "CSS", "Servlet", "Spring" };
		// TODO

		for (String str : languages) {
			if (str.length() >= 5) {
				System.out.print(str + " ");
			}
		}
		System.out.println();

		// ex4. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력. //equals 이용
		// 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
		// 결과: 2
		String[] names = { "오쌤", "John", "홍길동", "Gildong", "홍길동" };
		// TODO

		boolean hong = false;
		// int index로 해서 index 찾는게 나은듯
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동")) {
				System.out.println(i);
				hong = true;
				break;
			}
		}
		if (hong == false) {
			System.out.println("-1");
		}

		// ex5. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력. //ignore..contain..
		// 결과: TEST test TeSt tEsT
		String[] tests = { "TEST", "test", "TeSt", "tEsT", "테스트" };
		// TODO

		String[] ex = new String[tests.length];

//		tests[i].toLowerCase().contains("est");
//		걍 이렇게 하면 됨

		for (int i = 0; i < tests.length; i++) {
			ex[i] = tests[i].toLowerCase();
			if (ex[i].contains("est")) {
				System.out.print(tests[i] + " ");
			}
		}

		System.out.println();

		// ex6. 아래의 "YYYY-MM-DD" 형식의 문자열에서 년/월/일 정보를 "int" 타입 변수에 저장하고 출력.//split..
		// 결과: year=2023, month=10, day=4
		String today = "2024-04-05";
		// TODO
		String[] cal = today.split("-");
		int[] arr = new int[cal.length];
//1안
		for (int i = 0; i < cal.length; i++) {
			arr[i] = Integer.parseInt(cal[i]);
		}
		System.out.println("year=" + arr[0] + ", month=" + arr[1] + ", day=" + arr[2]);
//2안
		int year = Integer.parseInt(cal[0]);
		int month = Integer.parseInt(cal[1]); //04여도 걍 4 해줌
		int day = Integer.parseInt(cal[2]);
		System.out.println("year=" + year + ", month=" + month + ", day=" + day);
	}

}
