-- spring_04_jdbc, spring_05_tx에서 필요한 table
CREATE TABLE mem(
    num number(10),
    name varchar2(30),
    age number(10),
    loc varchar2(30)
);

CREATE SEQUENCE mem_num_seq
increment by 1
start with 1
nocycle;

ALTER TABLE mem
ADD CONSTRAINT mem_num_pk PRIMARY KEY(num);
