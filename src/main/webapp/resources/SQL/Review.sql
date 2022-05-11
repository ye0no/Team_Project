-- 리뷰 테이블
create table review(
rno number(38) primary key, -- 리뷰 번호
f_num number(38), -- 글 번호
mem_id varchar2(50), -- 작성자
r_point number(5) not null,  -- 점수
r_cont varchar2(4000),  -- 리뷰 내용
regdate date default sysdate, -- 등록날짜
foreign key(f_num) references food(f_num) on delete cascade, -- 글번호 삭제 고려
foreign key(mem_id) references member(id) on delete set null -- 아이디가 삭제되면 null 값 반환
);



/* 소수점 첫번째 반올림 */
select round(avg(r_point),1) from review where f_num=1 ;

-- 시퀀스 번호 생성
create sequence rno start with 1 increment by 1 nocache;
