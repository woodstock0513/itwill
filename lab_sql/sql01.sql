select sysdate from dual;
-- 한 줄 주석 hi~
/*
블럭 주석
*/
--sql 키워드(명령어)는 대소문자를 구분하지 않는다.
-- sql 문장은 세미콜론으로 끝남.
-- 단축키ctrl+enter
--(1) 현재 커서가 있는 위치의 한 문장을 실행
--(2) 드래그로 선택한 부분(문장)을 실행  세미콜론 주의
-- 단축키 F5 : 스크립트(파일)전체 실행

--bonus 테이블의 모든 레코드를 검색:
select * from bonus; -- 아무것도 없어도 아무것도 안 뜸

--dept 테이블에서 모든 레코드를 검색:
select * from dept; -- 뜸

--sql 문장에서 키워드 (select, from)와 테이블, 컬럼 이름은 대소문자를 구분하지 않는다.
--테이블에 저장되는 문자열은 대소문자를 구분한다.

--sql 문장을 작성하는 관습들.. 은 여러가지가 잇다.
select * from DEPT;
SELECT * FROM DEPT;
SELECT * FROM dept; -- 이런식