/*
오라클 함수(function)
1. 단일 행 함수
행이 하나씩 함수의 아규먼트로 전달되고 , 행마다 하나씩 결과가 리턴
ex) to_date, to_char, lower, upper
2. 다중 행 함수
여러 개의 행들이 함수의 아규먼트로 전달되고, 하나의 결과가 리턴
ex) 통계관련 함수 : count, sum, avg, max, min, variance, stddev
*/

-- 단일 행 함수 예 : 모든 행의 문자열을 소문자로 바꾸기
select ename , lower(ename) from emp;
-- lower 호출하면서 아규먼트로 ename을 줌 -> 행 하나씩 아규먼트로 넘어감

-- to_char(...) : 다른 타입의 값을 문자열로 변환. (ㅇㅖ) 날짜 -> 문자열
select hiredate, to_char(hiredate,'YYYY/MM/DD') as "문자열형식", to_char(hiredate,'YYYY') as "년도" from emp;
-- tp_char은 문자열 형식 제공해야!! 아규먼트 2개~

-- nvl(변수,값): 변수(컬럼이름)가 null이면 두번째 아규먼트(값)을 리턴, null이 아니면 원래 값을 리턴
-- nvl2(변수, 값1, 값2) : 변수가 null아 아니면 값1 리턴, 변수가 null이면 값2 리턴
select comm, nvl(comm,-10), nvl2(comm,comm,-10),  nvl2(comm,'true', 'false') from emp;

-- 다중 행 함수 예 :
-- count(컬럼) : null이 아닌 행의 개수 리턴
select count(empno), count(mgr), count(comm) from emp;

--테이블의 행의 개수
select count(*) from emp;

-- 이름이 대소문자 구분없이 'a'로 시작하는 직원들의 모든 정보
select * from emp where lower(ename) like 'a%'; --or 전부 대문자로 바꿔서 비교

-- 사번, 이름, 급여, 수당, 연봉을 검색
 select ename, sal, comm, nvl2(comm, sal*12+comm, sal*12) as "연봉" from emp;
                      -- sal*12 + nvl(comm,0) 이렇게 해도 굿. as "" 없으면 컬럼 이름 너무 길어짐.. ㅠㅠ

-- 통계함수 : 합계, 평균, 최댓값, 최솟값, 분산, 표준편차 ... 
select sum(sal), avg(sal), max(sal), min(sal), variance(sal), stddev(sal) from emp;

select sum(comm), avg(comm) from emp;
--> 모든 통계 함수들은 null을 제외하고 계산함

-- 단일 행 함수와 다중 행 함수는 함께 사용할 수 없다!! - 행 개수가 안 맞음
select sal from emp;



select * from nls_session_parameters where parameter = 'NLS_DATE_FORMAT';
alter session set NLS_DATE_FORMAT = 'YY/MM/DD';
select hiredate from emp where hiredate = '81/11/17';
alter session set NLS_DATE_FORMAT = 'RR/MM/DD';
select hiredate from emp where hiredate = '81/11/17';
select sal from emp where sal between 1300 and 1500;
select instr(ename,'S') from emp;



/*
그룹별 쿼리
(예) 부서별 직원수, 부서별 급여 평균
<문법>
select 컬럼, 함수호출
from  테이블
where 조건식(1)
group by 컬럼(그룹을 묶을 수 있는 변수)
having 조건식(2)
order by 컬럼(정렬 기준), ...;
조건식(1) : 그룹으로 묶기 전에, 행들을 선택할 조건
조건식(2) : 그룹으로 묶은 후에 행들을 선택할 조건
*/


--부서별 급여 평균
select deptno, round(avg(sal),2) as "평균"-- 그룹으로 같이 묶인 컬럼들만 ㄱㄴ
from emp
group by deptno
order by deptno;

--부서별 급여 평균, 표준편차
select deptno, round(avg(sal),2) as "평균", round(stddev(sal),2) as 표준편차
from emp
group by deptno
order by deptno;

-- 업무별 업무, 직원수 , 급여 최댓값, 최솟값, 평균을 업무 오름차순으로 출력
select job, count(job), max(sal), min(sal), round(avg(sal),2) as AVG
from emp
group by job
order by job;

-- 부서별/업무별로 부서번호, 업무, 직원수, 급여 평균을 출력. 정렬순서 : 부서번호, 업무
select deptno, job, count(job), round(avg(sal),2) as AVG
from emp
group by deptno, job
order by deptno, job;

-- 입사연도 별 사원수를 검색. 
select to_char(hiredate,'YYYY') as year, count(hiredate)
from emp
group by to_char(hiredate,'YYYY') -- 별명 사용 불가
order by year; --별명 사용 가능

-- 부서별 급여 평균 검색. 급여평균이 2000이상인 부서만 검색
select deptno, round(avg(sal),2) as AVG
from emp
group by deptno
having round(avg(sal),2) >=2000
order by deptno;

-- mgr 컬럼이 null이 아닌 직원들 중에서 부서별 급여평균을 검색. 부서번호 오름차순
select deptno, round(avg(sal),2) as AVG
from emp
where (mgr is not null)
group by deptno
order by deptno;

-- president 제외한 업무 별 사원수를 검색. 업무별 사원수가 3명 이상인 업무들만 검색, 업무 오름차순 정렬
select job, count(*) as COUNT
from emp
where (job != 'PRESIDENT')
group by job
having count(job) >= 3
order by job;

--입사연도, 부서별 사원 수, (1989 제외)
-- 연도별, ,부서별 사원 수가 2명 이상인 경우만 출력
-- 정렬순서  :  연도, 부서
select to_char(hiredate,'YYYY') as YEAR, deptno, count(*)
from emp
where (to_char(hiredate,'YYYY') != '1980')
group by to_char(hiredate,'YYYY'), deptno
having count(*) >= 2
order by to_char(hiredate,'YYYY'), deptno;