CREATE DATABASE sso DEFAULT CHARACTER SET=UTF8;

CREATE TABLE IF NOT EXISTS user (
    uid int(5) unsigned not null auto_increment primary key,
    username varchar(10) not null,
    password varchar(100) not null,
    lastIp varchar(15) default '',
    lastTime datetime
);

INSERT INTO user(username, password) values("yulei", "yulei");

CREATE TABLE IF NOT EXISTS tgt (
	id varchar(5) not null primary key,
	uid int(5) not null,
	ticket varchar(100) not null,
    ip varchar(15) not null,
    grantTime datetime not null
);