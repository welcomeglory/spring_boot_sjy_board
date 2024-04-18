create table users(
    username VARCHAR2(50) primary key,
    password VARCHAR2(100) not null,
    enabled CHAR(1) default '1'
);

create table authorities(
    username varchar2(50) not null,
    authority VARCHAR2(50) not null,
    constraint fk_authorities_users FOREIGN key(username) REFERENCES users(username)
);

insert into users(username,password) VALUES ('admin','admin');
insert into users(username,password) VALUES ('user','user');
insert into users(username,password) VALUES ('member','member');
  
insert into authorities(username,authority) values('admin','ROLE_USER');
insert into authorities(username,authority) values('member','ROLE_MANAGER');
insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_MANAGER');
insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_ADMIN');
insert into authorities(username,authority) values('user','ROLE_USER');