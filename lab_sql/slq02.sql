/*
기본 Query 문장
select 컬럼이름, (할일)... from 테이블 이름
테이블에서 모든 컬럼을 검색할 때 사용:
select * from 테이블이름;
*/

-- emp: 직원테이블, dept: 부서테이블
-- 직원테이블에서 사번(empno)과 직원 이름(ename)을 검색:
select empno, ename from emp; -- 컬럼 순서는 맘대로 하면 됨
select ename, empno from emp; --이 두 코드 결과는 다르게 나옴

-- 직원 테이블에서 모든 컬럼 검색
select * from emp; --컬럼 이름 다 써도 되긴 함..
-- (그러면 출력 순서를 바꿀 수 있어서 쓸 데가 있긴 함)
-- 다 쓸 때 job의 경우 명령어가 있어서 색은 파랑으로 나오지만, 어쨌든 컬럼으로 인식함.

-- 컬럼 이름에 별명(alias) 주기 : 컬럼이름 as "별명";
-- 별명이 공백이 없는 단어인 경우(한 단어) "" 없어도 됨.
-- 하지만 공백 있으면 "" 필수.
-- '' 안됨. 무조건!! 큰따옴표 "" 만 사용해야 함!!!!!
-- (주의) SQL에서 문자열은 ''만 사용함!! ''는 char,문자열꺼임. ㅇㅇ
-- 컬럼 이름이 맘에 안 들때, 너무 약자라서 이해가 안 갈 때, 한글로 바꾸고 싶을 때 등등

-- 부서테이블에서 부서번호, 부서이름 검색
select deptno as "부서 번호", dname as "부서 이름" from dept;

select deptno as "부서 번호", dname from dept; --별명 하나만 줘도 됨

-- 연결 연산자(||) (or 아님 주의 )
-- 2개 이상의 컬럼(또는 문자열)을 합쳐서 하나의 컬럼으로 출력하기 위해 사용

select deptno || '-' || dname as "부서"from dept; -- 별명 아니니까 큰 따옴표 쓰면 안됨!!!!! 주의!!
-- 위의 모든 내용을 다 합쳐서, 부서로 바꾸겠다는 뜻. 하나하나 별명 주는거 아님.
-- '부서번호-부서이름' 형식의 문자열을 "부서"라는 컬럼으로 출력!

-- 부서 테이블을 검색해서 'A부서는 B도시에 있습니다.' 형식으로 출력
select dname ||' 부서는 ' || loc ||' 도시에 있습니다.' as "부서 지역 설명"from dept;

-- 직원 테이블을 검색해서 'A의 급여는 B' 형식으로 출력
select ename || '의 급여는 ' || sal as "직원 급여" from emp;

----------------------20240422-----------------------

-- 검색 결과를 정렬해서 출력:
-- select 컬럼이름, ...  from 테이블 이름 order by 컬럼이름 [asc,desc];  어센드나 디센드 둘 중 하나 골라서 작성
-- asc : 오름차순 정렬. 기본값. -> 생략가능
-- desc : 내림차순 정렬. 생략불가. 

-- 부서테이블에서 부서 이름을 오름차순 정렬해서 출력:
select * from dept order by dname;

-- 부서테이블에서 부서 이름을 내림차순 정렬해서 출력:
select * from dept order by dname desc;

-- order by 연습
-- 직원 테이블에서 사번, 이름, 급여를 검색, 사번 오름차순 정렬:
select empno, ename, sal from emp order by empno;

-- 직원 테이블에서 사번, 이름, 급여를 검색, 급여 내림차순 정렬:
select empno, ename, sal from emp order by sal desc;

-- 직원 테이블에서 부서번호, 사번, 이름을 검색 (1) 부서번호 오름차순, (2) 사번 오름차순 정렬: 문장 하나로 가자잇
select deptno, empno, ename from emp order by deptno, empno asc;

-- 직원 테이블에서 부서번호, 사번, 이름 ,급여를 검색 (1) 부서번호 오름차순, (2) 급여 내림차순 정렬:
select deptno, empno, ename, sal from emp order by deptno, sal desc;

-- 중복되지 않는 결과 출력:
select job from emp; -- job들이 중복 상관없이 전부 출력 -> 14개의 행(record)
select distinct job from emp;  --> 5개의 행. job의 종류들만 출력. 각 직업이 몇명인진 모름
select DISTINCT job from emp order by job;

-- 중복되지 않는 부서 번호, 업무 출력. (1) 부서번호 오름차순 (2) 업무 오름차순
select distinct deptno, job from emp order by deptno, job;  --> 2개 합쳐서 중복 아닌 것들만 제외. 9개의 행