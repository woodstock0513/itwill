/*
join : 2개 이상의 테이블에서 검색하는 것
join 종류:
1. inner join
2. outer join 
(1) left outer join
(2) right outer join
(3) full outer join

문법 :
1. ANSI 표준문법
select 컬럼
from table1 join종류, table2 on 조건식;   -- 제일 기본!
(where, order by .. 쓸 수 있음)

2. ORACLE 문법
select 컬럼
from table1, table2
where 조건식;
*/

-- inner join과 outer join의 차이점을 설명하기 위해 추가
insert into emp(empno, ename, sal, deptno)
values (1004, '오쌤', 3500, 50);
commit; --table의 변경 내용 영구 저장.


-- 사번, 이름, 부서번호, 부서이름 검색
--> inner join. 표준문법(ansi)
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp
  inner join dept on emp.deptno = dept.deptno;

--> inner join. oracle 문법
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp, dept
where emp.deptno = dept.deptno;

--left (outer) join (표준)
select e.empno, e.ename, e.deptno, d.dname
from emp e left outer join dept d on e.deptno = d.deptno;

--left (outer) join (ORACLE)
select e.empno, e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno (+);

--right (outer) join ansi
select e.empno, e.ename, d.deptno, d.dname
from emp e right outer join dept d on e.deptno = d.deptno; 

--right (outer) join (ORACLE)
select e.empno, e.ename, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;

--full (outer) join ansi 마찬가지로 outer 생략가능
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e full outer join dept d on e.deptno = d.deptno; 

--full (outer) join (ORACLE)
--> 없음. 오라클은 full outer join 문법을 제공하지 않음.. 
-- 대신 집합연산 (합집합union, 교집합intersect, 차집합minus 등)을 사용!
--> left join과 right join의 합집합으로 쓰면 됨
select e.empno, e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno (+)  --여기까지 left join
union --합집합
select e.empno, e.ename, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;  --right join

-- equi-join : join의 조건식이 = 연산자를 사용해서 만들어진 경우
-- non-equi-join : join의 조건식이 부등호를 사용해서 만들어진 경우 (between A and B도 사용가능!)
-- 사번, 이름, 급여, 급여호봉을 검색
-- 표준 문법
select e.empno, e.ename, e.sal, s.grade
from emp e join salgrade s on e.sal between s.losal and s.hisal;
--         join salgrade s on e.sal>=s.losal and e.sal<=s.hisal; 도 가능!

--오라클 문법
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

-- self join : 같은 테이블에서 join하는 것
-- 사번, 이름, 매니저 사번, 매니저 이름 검색
-- 표준 문법
select e1.empno, e1.ename, e1.mgr as MGR_NO, e2.ename as MGR_NAME
from emp e1 join emp e2 on e1.mgr = e2.empno;
-- mgr = null인 값 제외 -> 13개의 결과

--오라클 문법
select e1.empno, e1.ename, e2.empno as MGR_NO, e2.ename as MGR_NAME
from emp e1, emp e2
where e1.mgr = e2.empno;

-- left join
select e1.empno, e1.ename, e1.mgr, e2.ename as MGR_NAME
from emp e1 left outer join emp e2 on e1.mgr = e2.empno;
--> e1에 있는 모든 자료 다 출력 -> null인 애들도 나옴

select e1.empno, e1.ename, e1.mgr, e2.ename as MGR_NAME
from emp e1, emp e2
where e1.mgr = e2.empno(+);





-- ex1. 직원 이름, 직원 근무 도시를 검색. 근무 도시 오름차순 정렬.
select e.ename, d.loc
from emp e, dept d
where e.deptno = d.deptno
order by d.loc;

select e.ename, d.loc
from emp e join dept d on e.deptno = d.deptno
order by d.loc;

-- ex2. 직원 이름, 매니저 이름, 급여, 급여 등급을 검색.
--      정렬순서: (1)매니저, (2)급여 등급. 테이블 3개
select e1.ename, e2.ename as MGR_NAME, e1.sal, s.grade
from emp e1, emp e2, salgrade s
where e1.mgr = e2.empno and e1.sal between s.losal and s.hisal
order by e2.ename, s.grade;

select e1.ename, e2.ename as MGR_NAME, e1.sal, s.grade
from emp e1
join emp e2 on e1.mgr = e2.empno
join salgrade s on e1.sal between s.losal and s.hisal
order by e2.ename, s.grade;

/*이해를 위한 연습용 코드
select e1.*,e2.*,d.*
from emp e1 full join emp e2 on e1.mgr = e2.empno
full join dept d on e1.deptno = d.deptno;

select e1.*,e2.*,s.*
from emp e1 left join emp e2 on e1.mgr = e2.empno
join salgrade s on e1.sal between s.losal and s.hisal;

select e1.*,e2.*,d.*
from emp e1 
join dept d on e1.deptno = d.deptno
left join emp e2 on e1.mgr = e2.empno;
*/

-- ex3. 직원 이름, 부서 이름, 급여, 급여 등급을 검색.
--      정렬 순서: (1)부서 이름, (2)급여 등급
select e.ename, d.dname,e.sal, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno and e.sal between s.losal and s.hisal
order by d.dname, s.grade;

select e.ename, d.dname, e.sal, s.grade
from emp e join dept d on e.deptno = d.deptno
join salgrade s on e.sal between s.losal and s.hisal
order by d.dname, s.grade;

-- ex4. 부서 이름, 부서 위치, 부서의 직원수를 검색. 부서 번호 오름 차순.
-- group by 사용!
select d.dname, d.loc, count(*) --(*) 쓰는게 간편!
from emp e, dept d
where e.deptno = d.deptno
group by  d.dname, d.loc, d.deptno;
order by d.deptno;

select d.dname, d.loc, count(e.ename)  -- rightjoin으로 쓸 때에는 count(*)나 d.어쩌고 쓰면 안됨.
-- d.어쩌고는 내용이 있으니까 그걸 읽어버리기 때문(e.어쩌고가 null이라서 0이어야하는데!)
from emp e right join dept d on e.deptno = d.deptno
group by d.dname, d.loc, d.deptno
order by d.deptno;

-- ex5. 부서 번호, 부서 이름, 부서 직원수, 부서의 급여 최솟값, 
--      부서의 급여 최댓값 검색. 부서 번호 오름 차순.
select d.deptno, d.dname, count(d.dname), min(e.sal), max(e.sal)
from emp e, dept d
where e.deptno = d.deptno
group by d.deptno, d.dname
order by d.deptno;

select d.deptno, d.dname, count(e.ename), min(e.sal), max(e.sal)
from emp e join dept d on e.deptno = d.deptno
join salgrade s on e.sal between s.losal and s.hisal
group by d.deptno, d.dname
order by d.deptno;

-- ex6. 부서 번호, 부서 이름, 사번, 이름, 매니저 사번, 매니저 이름, 
--      급여, 급여 등급을 검색. 급여가 3000 이상인 직원들만 검색.
--      정렬 순서: (1) 부서 번호, (2) 사번 오름차순.
select e1.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e2.ename, e1.sal, s.grade
from emp e1, emp e2, dept d, salgrade s
where e1.mgr = e2.empno(+) and e1.sal between s.losal and s.hisal and e1.deptno = d.deptno(+) and e1.sal>=3000
order by d.deptno, e1.empno;

select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e2.ename as MGR_NAME, e1.sal, s.grade
from emp e1 full join emp e2 on e1.mgr = e2.empno
full join dept d on e1.deptno = d.deptno    
join salgrade s on e1.sal between s.losal and s.hisal
where e1.sal>=3000
order by d.deptno, e1.empno;

