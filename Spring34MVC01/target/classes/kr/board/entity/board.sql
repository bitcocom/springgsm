-- 게시판 테이블 설계
drop table board;
create table board(
  num int not null auto_increment, -- 번호(자동증가), 시퀀스
  title varchar(100) not null, -- 제목
  content varchar(2000) not null, -- 내용
  writer varchar(50) not null, -- 작성자
  indate datetime default now(), -- sysdate
  count int default 0, -- 조회수
  primary key(num)
);
-- 게시물 저장
insert into board(title, content, writer)
values('스프링 게시판 만들기','스프링 게시판 만들기','관리자');

insert into board(title, content, writer)
values('스프링 게시판 만들기','스프링 게시판 만들기','박매일');

insert into board(title, content, writer)
values('스프링 게시판 만들기','스프링 게시판 만들기','홍길동');

select * from board;

create table member(
  idx int auto_increment primary key,
  username varchar(255) not null unique,
  password varchar(255) not null,
  name varchar(255) not null,
  email varchar(255) not null unique
);





