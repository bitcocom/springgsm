drop table board;

create table board(
  num int not null auto_increment,
  title varchar(100) not null,
  content varchar(2000) not null,
  writer varchar(50) not null,
  indate datetime default now(),
  count int default 0,
  primary key(num)
)

select * from board;

insert into board(title, content, writer)
values('스프링 게시판 연습','스프링 게시판 연습','관리자');

insert into board(title, content, writer)
values('스프링 게시판 연습','스프링 게시판 연습','박매일');

insert into board(title, content, writer)
values('스프링 게시판 연습','스프링 게시판 연습','홍길동');

drop table member;

create table member(
  idx int auto_increment primary key,
  username varchar(200) not null unique,
  password varchar(200) not null,
  name varchar(50) not null,
  email varchar(50) not null unique
);

insert into member(username, password, name, email)
values('gsm01','gsm01','관리자','admin@gsm,kr');

insert into member(username, password, name, email)
values('gsm02','gsm02','박매일','park@gsm,kr');

insert into member(username, password, name, email)
values('gsm03','gsm03','홍길동','hong@gsm,kr');

select * from member;







