/*建库*/
CREATE DATABASE IF NOT EXISTS saasmall DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use saasmall;

/*客户表*/
create table if not exists customer (id int primary key ,name varchar(30),password varchar(160),avatar varchar(50),mobile varchar(20));

/*客户表示例*/
insert into customer values (1,'youko','12345','takasakiYuu','15586396168');



