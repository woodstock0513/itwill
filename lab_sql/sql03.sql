/*
조건 검색 where
테이블에서 데이터 검색 : 
(1) projection : 테이블에서 원하는 컬럼(들)을 선택
(2) selection : 테이블에서 조건을 만족하는 행(들)을 검색

문법 : select 컬럼이름, ... from 테이블이름 where 조건식 order by 컬럼이름, ... ;
select ~ from ~ where ~ order by ~;

조건식 - TF 구분을 할 수 잇어야. and, or 사용 ㄱㄴ
-> 비교연산자, 논리연산자 사용!!

조건식에서 사용되는 연산자들 :
 (1) 비교연산자 : =,  !=, >, <, >=, <=, is null, is not null, ... (주의) != null 이 아니라 is not null
 (2) 논리연산자 : and, or, not

*/

-- 직원 테이블에서 10번 부서에서 근무하는 직원들의 부서번호, 사번, 이름을 출력, 사번 오름차순
select deptno, empno, ename from emp where deptno = 10 order by empno;

-- 직원 테이블에서 수당이 null이 아닌 직원들의 사번, 부서번호, 이름, 급여, 수당을 출력, 사번 오름차순
select empno, deptno, ename, sal, comm from emp where comm is not null order by empno;
--> SQL의 null 여부 비교를 할 때에는, = 나 !=을 사용하면 안됨.
-- 실행은 되는데, 원하는 결과는 나오지 않음..
--> SQL에서 null 여부 비교를 할 떄에는 is null, is not null 을 사용하자!!!!

-- 직원 테이블에서 급여가 2000이상인 직원들의 이름, 업무, 급여를 출력, 급여 내림차순
select ename, job, sal from emp where sal>=2000 order by sal desc;

-- 직원 테이블에서 급여가 2000이상 3000이하인 직원들의 이름, 업무, 급여를 출력, 급여 내림차순
select ename, job, sal from emp where sal>=2000 and sal<=3000 order by sal desc;
-- 2000<= sal <= 3000 하면 안됨. 나눠서 써야함!!!
--> 논리 연산자로 & 또는 &&를 사용할 수 없음.

select ename, job, sal from emp where sal between 2000 and 3000 order by sal desc;
-- 컬럼이름 between A and B

--직원 테이블에서 10번 또는 20번 부서에서 근무하는 직원들의 부서번호, 이름, 급여를 검색. 부서번호 오름차순
select deptno, ename, sal from emp where deptno = 10 or deptno = 20 order by deptno;
--> where deptno = 10 or 20 으로 쓰면 안됨!!!
--> where deptno in (10,20) 으로도 쓸 수 있음!! 부서번호가 저 안에 있으면 (10 or 20) T , 아니면 F

-- 직원 테이블에서 업무가 clerk인 직원들의 업무, 이름, 급여를 출력 이름순 정렬
select job, ename, sal from emp where job = 'CLERK' order by ename; --대소문자구분함!! 잘 지켜서 작성
--> SQL에서 문자열을 비교할 때 =, != 연산자를 사용하고, 작은 따옴표('')를 사용한다. 대소문자를 구분해야한다.

-- 직원 테이블에서 업무가 clerk 또는 manager인 직원들의 업무, 이름, 급여를 출력 업무, 급여 순 정렬
select job, ename, sal from emp where job in ('CLERK', 'MANAGER') order by job, sal;
--> in은 or 을 간단하게 쓴 것이라고 생각하면 됨. 둘 중 하나만 만족하면 ㅇㅋ

-- 직원 테이블에서 20번 부서에서 근무하는 clerk의 모든 정보를 검색
select * from emp where deptno = 20 and job = 'CLERK';

-- 직원 테이블에서 clerk, analyst, manager가 아닌 직원들의 사번, 업무, 이름, 급여를 출력 사번순 정렬
select empno, job, ename, sal from emp where job != 'CLERK' and job  != 'ANALYST' and job != 'MANAGER' order by empno;
select empno, job, ename, sal from emp where job not in ('CLERK', 'ANALYST','MANAGER') order by empno;

-- 숫자 타입 뿐만 아니라 문자열과 날짜 타입도 대소비교가 가능함.
-- (예) a < b  2024/04/21 < 2024/04/22

-- 입사 날짜가 1987.1.1 이후인 직원들의 모든 정보
select * from emp where hiredate > '1987-01-01' order by hiredate;
--> (암묵적(자동) 타입 변환) 날짜 타입을 비교할 때 날짜vs문자열이면 날짜 타입이 문자열로 바뀜 -> 문자열 비교(?)인 것임
-- 암묵적인 타입 변환이 일어났다.. '2002/05/13'을 날짜라고 굳이 말 안해줘도 알아서..

select * from emp where hiredate > to_date('1987/01/01') order by hiredate;
--> 명시적 타입 변환. to_date('문자열') : 문자열을 날짜 타입으로 변환

-- like 검색 : 특정 문자열로 시작하거나, 특정 문자열이 포함된 값을 찾는 검색
-- 이름이 'A'로 시작하는 직원들의 모든 정보 
select * from emp where ename like 'A%'; --A 뒤의 글자수 상관 X -> %

/*
like 검색에서 사용하는 와일드카드:
(1) % : 글자 수 제한 없음
(2) _ (underscore,언더바) : 언더바 개수만큼 어떤 문자가 있어도 됨. (문자수 제한 용도 늑김)
*/

select * from emp where job like '_LERK';

--이름에 A가 포함된 직원들의 모든 정보
select * from emp where ename like '%A%';
--대소문자는 구분함!!!!! 대소문자 항상 주의!!!

--30번 부서에 근무하고 업무 이름에 'SALES'가 포함되어 있는 직원들의 사번,부서번호,이름, 업무, 급여, 수당 출력. 사번 오름차순
select empno, deptno, ename, job, comm from emp where deptno = 30 and job like '%SALES%' order by empno;

