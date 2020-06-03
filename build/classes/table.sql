create table users(

    id varchar2(30) not null,
    pw varchar2(30) not null,
    name varchar2(30) not null,
    email varchar2(30),
    address varchar2(200),
    regdate date default sysdate
);
alter table users add CONSTRAINT users_pk primary key (id);



create table board(

    bno number(10,0) not null,
    writer varchar2(50) not null,
    title varchar2(200),
    content varchar2(2000),
    regdate date default sysdate,
    hit number(10, 0) default 0

);
alter table board add CONSTRAINT board_bno_pk PRIMARY KEY (bno);
create SEQUENCE board_seq INCREMENT by 1 start with 1;
