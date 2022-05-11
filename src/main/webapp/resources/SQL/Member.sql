select * from member;

drop table member;

create table member(
id varchar2(50) primary key,
pw varchar2(100) not null,
name varchar2(100) not null,
jumin1 varchar2(20),
jumin2 varchar2(20),
jumin3 varchar2(20),
gender varchar2(30),
email varchar2(100),
tel varchar2(50),
mem_state number(38),  -- 가입이면 1 탈퇴 0
mem_date date,
mem_delcont varchar2(4000), -- 탈퇴사유
mem_deldate date -- 탈퇴날짜
);


update member set pw='81dc9bdb52d04dc20036dbd8313ed055' where id='1234'; -- 비번 1234 를 암호화


insert into member(id,pw,name,jumin1,jumin2,jumin3,gender,email,tel,mem_state,mem_date)
values('1234','1234','hi','1997','01','23','남자','tjddyd1060@naver.com','01023411234',1,sysdate);


drop table member;
