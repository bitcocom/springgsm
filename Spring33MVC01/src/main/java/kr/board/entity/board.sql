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










