-- 공지사항
create table Gongji(
gongji_no number(38) primary key,  -- 공지번호
title varchar2(200),  -- 제목
writer varchar2(20), -- 작성자
gongji_cont varchar2(4000), -- 내용
Gongji_register date default sysdate, -- 등록날짜
hit number(38) default 0, 
foreign key(writer) references admin(admin_name) on delete cascade -- 관리자계정이 삭제되면 컬럼도 같이 삭제
);

-- 공지사항  시퀀스
create sequence gongji_no start with 1 increment by 1 nocache;
