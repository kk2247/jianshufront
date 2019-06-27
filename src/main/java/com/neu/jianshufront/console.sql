create table user_action(
    id int primary key auto_increment,
    uid varchar(50),
    action varchar(30),
    time varchar(50),
    pid varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;