create database customerdb;
use customerdb;

create table if not exists customer(
id int primary key auto_increment,
first_name varchar(50),
last_name varchar(50),
email varchar(50)
);