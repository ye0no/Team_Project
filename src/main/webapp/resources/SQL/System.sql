


alter session set "_oracle_script"=true;

create user web2 identified by 2222;

grant connect, resource to web2;


-- 테이블 스페이스 생성
create tablespace web2 datafile 'C:\app\user\product\21c\oradata\XE\web2.dbf'
size 300M;

alter user web2 default tablespace web2;

alter user web2 quota unlimited on web2;