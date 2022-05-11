create table like_table(
 like_no number(38) not null primary key,   -- 좋아요 번호
 f_num number(38) not null,     -- 글번호
 mem_id varchar2(50) not null,   -- 아이디
 like_state number(3) default 0 null, -- 좋아요 1 아니면 0  (체크 여부)
 like_sysdate date default sysdate,
 foreign key(f_num) references food(f_num) on delete cascade,
 foreign key(mem_id) references member(id) on delete cascade
);

-- 자동 증가 시퀀스 생성
create sequence like_no start with 1 increment by 1 nocache;


insert into like_table(like_no,f_num,mem_id) values (1,1,'tjddyd');
insert into like_table(like_no,f_num,mem_id) values (2,1,'tjddyd');

select * from like_table;

drop table like_table;
