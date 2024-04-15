package com.itwill.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaMain04 {

	public static void main(String[] args) {
		// 사원들의 리스트
		List<Employee> employees = Arrays.asList(new Employee(101, "김지현", "개발1팀", "과장", 700),
				new Employee(102, "이동준", "개발2팀", "부장", 800), new Employee(103, "이승행", "개발1팀", "대리", 500),
				new Employee(104, "정윤정", "개발2팀", "부장", 1_000), new Employee(105, "김동환", "인사팀", "회장", 30_000),
				new Employee(106, "노형진", "인사팀", "차장", 900), new Employee(107, "오쌤", "총무팀", "대리", 300));

		// 모든 직원들의 정보를 한 줄에 한명씩 출력
		System.out.println("--------ex1.----------");
//		for (int i = 0;i<employees.size();i++) {
//			System.out.println(employees.get(i));
//		}

//		employees.forEach((x)->System.out.println(x));

		employees.forEach(System.out::println);

		// 개발팀에서 일하는 직원들의 급여 합계
		System.out.println("--------ex2-3.----------");

		double sum = 0.0; // 급여 합계를 저장하기 위한 변수
		int count = 0; // 개발팀 직원을 저장하기 위한 변수
		for (Employee e : employees) { // 모든 직원에 대해 반복
			if (e.getDept().contains("개발")) { // 직원의 부서 이름이 개발을 포함
				sum += e.getSalary(); // sum에 급여를 더한다.
				count++;
			}
		}
		System.out.println("sum = " + sum);
		System.out.println("mean = " + sum / count);

		// stream //mapToDouble(Employee::getSalary)로도 사용 가능.
		sum = employees.stream().filter((x) -> x.getDept().contains("개발")).mapToDouble((x) -> x.getSalary()).sum();
		System.out.println("sum = " + sum);
		double mean = employees.stream().filter((x) -> x.getDept().contains("개발")).mapToDouble((x) -> x.getSalary())
				.average().orElseThrow();
		// 평균을 계산할 수 없을 때에는 예외 발생
		System.out.println("mean = " + mean);

//		내풀이
//		List<Employee> work =employees.stream().filter((x)->x.getDept().contains("개발")).toList();
//		System.out.println(work);
//		
//		List<Double> money = new ArrayList<>();
//		for (int i = 0;i<employees.size();i++) {
//			if (employees.get(i).getDept().contains("개발")) {
//				money.add(employees.get(i).getSalary());
//			}
//		}
//		double sum = money.stream().reduce(0.0, (a, b) -> a + b);
//		
//		System.out.println(sum);

//		List<Double> mon = employees.stream().filter(work.get)

		// 개발팀에서 일하는 직원들의 급여 평균
//		double mean = sum / money.size();

		// 직급이 부장인 직원들의 급여 합계, 평ㄱㄴ
//		List<Employee> work2 = employees.stream().filter((x)->x.getJobTitle().equals("부장")).toList();
		System.out.println("--------ex4-5.----------");
		sum = 0.0;
		count = 0;

		for (Employee e : employees) { // 모든 직원에 대해 반복
			if (e.getJobTitle().equals("부장")) { // 직원의 부서 이름이 개발을 포함
				sum += e.getSalary(); // sum에 급여를 더한다.
				count++;
			}
		}
		System.out.println("sum = " + sum);
		System.out.println("mean = " + sum / count);

		sum = employees.stream().filter((x) -> x.getJobTitle().equals("부장")).mapToDouble((x) -> x.getSalary()).sum();

		mean = employees.stream().filter((x) -> x.getJobTitle().equals("부장")).mapToDouble((x) -> x.getSalary())
				.average().orElseThrow();

		System.out.println("sum = " + sum);
		System.out.println("mean = " + sum / count);

		// 급여가 1000이상인 직원들의 정보를 한 줄에 한 명씩 출력
		System.out.println("--------ex6.----------");
		employees.stream().filter((x) -> x.getSalary() >= 1000).forEach(System.out::println);

		// 개발 1팀 직원들의 급여를 10% 인상하고 인상된 급여의 평균
		System.out.println("--------ex7.----------");
		mean = employees.stream().filter((x) -> x.getDept().equals("개발1팀")).mapToDouble((x) -> x.getSalary() * 1.1)
				.average().orElseThrow();
		System.out.println("mean = " + mean);

		// ex8. 직원들 중에서 대리는 몇명인지 구하기
		count = 0;
		for (Employee e : employees) {
			if (e.getJobTitle().equals("대리")) {
				count++;
			}
		}
		System.out.println("대리 = "+count);
		
		long empcount = employees.stream().filter((x)->x.getJobTitle().equals("대리")).count();
		System.out.println("대리 = "+empcount);
		
	}

}
