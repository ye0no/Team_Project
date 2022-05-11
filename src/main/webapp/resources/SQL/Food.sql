
create table food(
f_num number(38) primary key ,   -- 번호
bsnscond varchar2(50),
bsnsnm varchar2(50) not null,
menu varchar2(300) not null,
addr varchar2(200),
lat varchar2(50),
lng varchar2(50),
tel varchar2(100) not null,
viewcnt number(38) default 0,
rest varchar2(100),
suyong varchar2(100),
food_file1 varchar2(200),
food_file2 varchar2(200),
food_file3 varchar2(200),
category varchar2(50), -- 메뉴 구분
grade number(3,2), -- 평점 담는 값
regdate date
);


alter table food modify grade number(3,2); --평점 ex)4.12

select * from food order by f_num asc;

select * from food order by addr asc;


create sequence f_num start with 1 increment by 1 nocache;





 -- 시퀀스 삭제
drop sequence f_num;

drop table food;

select * from food where menu like '%닭갈비%';

select * from food where addr like '%강원도%';

select * from food where bsnscond='중식';

select * from food where bsnscond='일식';

select * from food where bsnscond='한식';


-- 메뉴별 맛집 리스트 
 select *from food where category='소고기'; 
 
 select *from food where category='해산물';
  
 select *from food where category='국류';
 
 select * from food where category='돼지'; 
 
 select * from food where category='밥';
 
  select *from food where category='닭/오리'; 
  


 

select * from food where addr like '%용산%';

select * from food where category is not null;

select * from food where category is  null;





