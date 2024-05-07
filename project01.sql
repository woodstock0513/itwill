create table movies(
Movie_No number(1) primary key,
Movie_Name varchar2 (20 char),
Movie_Info varchar2 (100char)
);

create table times(
TIME_NO number(3) generated as identity primary key,
Movie_Name varchar2(20char),
MOVIE_DATE date
);

alter table times add movie_no number(1) references movies(movie_no);

update times set movie_no = 3 where movie_name = '웡카';

select movie_name, movie_date from times where movie_no = 1;

create table seats (
SEAT_ID number(3) generated as identity primary key,
SEAT_NO number (2),
TIME_NO number(3),
state varchar2(10 char)
);

create table members(
MEMBER_NO number(3) generated as identity primary key,
MEMBER_ID varchar2(20 char),
MEMBER_NAME varchar2(10 char),
MEMBER_PW varchar2(30 char),
MEMBER_BIRTH date,
MEMBER_PHONE varchar2(15 char)
);

create table reservations (
RESERVATION_NO number(3) generated as identity primary key,
MEMBER_NO  number(3),
MOVIE_NAME varchar2(20char),
MOVIE_DATE date,
SEAT_NO number (2),
RESERVATION_TIME timestamp(6) default systimestamp
);

drop table seats;

-- select memno from members where LOWER(memid) = 'admin';

-- insert into reservations (memno,mname,mdate,seatno) select memno, mname, mdate, seatno from times where timenum = ?;

insert into members (memid, memname, mempw, membirth, memphone) values ('admin', 'dayoung','moon1234','20020513','010-1234-5678' );

insert into seats (seat_no, time_no, state) values(1,1,'ON');
insert into seats (seat_no, time_no, state) values(2,1,'ON');
insert into seats (seat_no, time_no, state) values(3,1,'ON');
insert into seats (seat_no, time_no, state) values(4,1,'ON');
insert into seats (seat_no, time_no, state) values(5,1,'ON');
insert into seats (seat_no, time_no, state) values(1,2,'ON');
insert into seats (seat_no, time_no, state) values(2,2,'ON');
insert into seats (seat_no, time_no, state) values(3,2,'ON');
insert into seats (seat_no, time_no, state) values(4,2,'ON');
insert into seats (seat_no, time_no, state) values(5,2,'ON');
insert into seats (seat_no, time_no, state) values(1,3,'ON');
insert into seats (seat_no, time_no, state) values(2,3,'ON');
insert into seats (seat_no, time_no, state) values(3,3,'ON');
insert into seats (seat_no, time_no, state) values(4,3,'ON');
insert into seats (seat_no, time_no, state) values(5,3,'ON');
insert into seats (seat_no, time_no, state) values(1,4,'ON');
insert into seats (seat_no, time_no, state) values(2,4,'ON');
insert into seats (seat_no, time_no, state) values(3,4,'ON');
insert into seats (seat_no, time_no, state) values(4,4,'ON');
insert into seats (seat_no, time_no, state) values(5,4,'ON');
insert into seats (seat_no, time_no, state) values(1,5,'ON');
insert into seats (seat_no, time_no, state) values(2,5,'ON');
insert into seats (seat_no, time_no, state) values(3,5,'ON');
insert into seats (seat_no, time_no, state) values(4,5,'ON');
insert into seats (seat_no, time_no, state) values(5,5,'ON');
select * from seat;

select * from movies;

insert into movies values (1,'ROBOT DREAM','도그와 로봇의 감동적인 이별 이야기');
insert into movies values (2, '쿵푸팬더4','진정한 용의 전사가 된 포의 마지막 모험');
insert into movies values (3,'웡카','찰리와 초콜릿 공장 그 이전 이야기! 윌리 웡카의 초콜릿가게 세우기 대장정');

insert into times (movie_name,movie_date) values('ROBOT DREAM','202405122000');
insert into times (movie_name,movie_date)  values ('쿵푸팬더4','202405121530');
insert into times (movie_name,movie_date)  values ('웡카','202405111720');
insert into times (movie_name,movie_date) values('ROBOT DREAM','202405102000');
insert into times (movie_name,movie_date)  values ('웡카','202405121040');

select * from times;

select times.mname, times.mdate, movies.movno
from times, movies
where times.mname = movies.mname;



commit;

