use spring82019;

insert into role(code,name) values('MANAGER','MANAGER');
insert into role(code,name) values('STAFF','STAFF');

insert into user(username,password,fullname,status)
values('nguyenvan a','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Nguyen Van A',1);
insert into user(username,password,fullname,status)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Nguyen Van B',1);
insert into user(username,password,fullname,status)
values('nguyenvanc','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Nguyen Van C',1);
insert into user(username,password,fullname,status)
values('nguyenvand','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Nguyen Van D',1);

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);
INSERT INTO user_role(userid,roleid) VALUES (3,2);
INSERT INTO user_role(userid,roleid) VALUES (4,2);