create table board(
  num int not null auto_increment,
  title varchar(100) not null,
  content varchar(2000) not null,
  writer varchar(50) not null,
  indate datetime default now(),
  count int default 0,
  primary key(num)
);

insert into board(title, content, writer)
values('스프링게시판','스프링게시판','박매일');

select * from board;