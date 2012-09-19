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
	uid int(5) not null auto_increment primary key,
	sid varchar(100) not null,
	ticket varchar(100) not null,

);