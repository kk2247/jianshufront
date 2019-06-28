create table my_user(
    id int primary key auto_increment,
    account varchar(50),
    password varchar(30),
    email varchar(50) unique ,
    collect_num int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;