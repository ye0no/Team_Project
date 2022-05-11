-- admin 테이블 생성
create table admin(
admin_no number(38),
admin_id varchar2(30) primary key,
admin_pwd varchar2(200) not null, -- 관리자 비번 암호화
admin_name varchar2(20) not null,
admin_date date
);


-- 관리자 이름 unique로 값 받기
alter table admin add unique (admin_name);



select *from admin order by admin_no desc;

delete from admin;

create sequence admin_no_seq start with 1 increment by 1 nocache;