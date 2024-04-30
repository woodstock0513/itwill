/*
서브 쿼리 :  SQL문장의 일부로 다른 SQL문장이 포함되는 것
*/

--급여가 평균 이상인 직원
select avg(sal) from emp; --2073.214...
select * from emp where sal>= 2073.21;

--> 서브쿼리 이용!
select * from emp
where sal >= (
    select avg(sal) from emp -- 얘가 서브쿼리. 숫자가 들어갈 위치에 쿼리가 들어감. 괄호로 묶어줘야
);

-- allen보다 적은 급여를 받는 직원들의 사번, 이름, 급여 검색
select empno, ename, sal
from emp
where sal < (
select sal from emp where ename = 'ALLEN'
);

-- allen과 같은 업무를 담당하는 직원들의 사번, 이름, 부서번호, 업무, 급여 검색
select empno, ename, deptno, job, sal 
from emp
where job = (
select job from emp where ename = 'ALLEN'
);

--salesman의 급여 최댓값보다 더 많은 급여를 받는 직원들의  사번, 이름, 급여, 업무 검색
select empno, ename, sal, job
from emp
where sal > (
select max(sal) from emp where job='SALESMAN'
);

-- Ex. WARD의 연봉보다 더 많은 연봉을 받는 직원들의 이름, 급여, 수당, 연봉을 검색.
-- 연봉 = sal * 12 + comm. comm(수당)이 null인 경우에는 0으로 계산.
-- 연봉 내림차순 정렬.
select ename, sal, comm, sal*12+nvl(comm,0) as ANNUAL_SAL
from emp
where sal*12+nvl(comm,0) > (
    select sal*12+nvl(comm,0) from emp where ename = 'WARD'
)
order by ANNUAL_SAL desc;

-- Ex. SCOTT과 같은 급여를  받는 직원들의 이름과 급여를 검색.
select ename, sal
from emp
where sal = (
select sal from emp where ename = 'SCOTT' 
);

-- Ex. 위 결과에서 SCOTT은 제외하고 검색.
select ename, sal
from emp
where sal = (
select sal from emp where ename = 'SCOTT' 
) and ename != 'SCOTT';


-- Ex. ALLEN보다 늦게 입사한 직원들의 이름, 입사날짜를 최근입사일부터 출력.
select ename, hiredate
from emp
where hiredate > (
select hiredate from emp where ename = 'ALLEN'
)
order by hiredate desc;

-- Ex. 매니저가 KING인 직원들의 사번, 이름, 매니저 사번을 검색.
select empno, ename, mgr
from emp
where mgr = (
select empno from emp where ename = 'KING'
);

-- Ex. ACCOUNTING 부서에 일하는 직원들의 이름, 급여, 부서번호를 검색.
--table 2개 이용..
select ename, sal, deptno
from emp
where deptno = (
select deptno from dept where dname = 'ACCOUNTING'
);

-- Ex. CHICAGO에서 근무하는 직원들의 이름, 급여, 부서 번호를 검색.
select ename, sal, deptno
from emp
where deptno = (
select deptno from dept where loc = 'CHICAGO'
);

select ename, sal, emp.deptno
from emp, dept
where emp.deptno = dept.deptno and dept.loc = 'CHICAGO';

