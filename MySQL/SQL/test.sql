
create table canteen (
   id int primary key auto_increment, 
   name varchar(20));

 create table canteen_window (
    id int primary key auto_increment, 
    name varchar(20), 
    window_id int, 
    foreign key(window_id) references canteen(id));

 create table canteen_charge (
    id int primary key auto_increment, 
    price int, 
    charge_date datetime, 
    canteen_window_id int, 
    foreign key(canteen_window_id) references canteen_window(id));


insert into canteen_charge values (null, 20, '2022-02-02 12:12:12', 1);
insert into canteen_charge values (null, 15, '2022-02-03 13:13:13', 2);
insert into canteen_charge values (null, 30, '2022-02-04 15:15:15', 3);


-- vehicle violation imformation
create table user (
   id int primary key, 
   name varchar(20));

create table cars (
   id int primary key, 
   name varchar(20), 
   user_id int, 
   foreign key(user_id) references user(id));

create table vehicle_violation_information (
   user_id int,
   cars_id int,
   foreign key(user_id) references user(id),
   foreign key(cars_id) references cars(id));

insert into cars values(123, 'crown', 1);
insert into cars values(357, 'maybach', 2);
insert into cars values(789, 'ford', 1);

insert into vehicle_violation_information values (1, 123), (2, 357);



-- student dormitory information
create table dormitory (id int primary key);

create table student (
   id int primary key,
   name varchar(20),
   dormitory_id int, 
   foreign key(dormitory_id) references dormitory(id));

create table records (
   id int primary key,
   dormitory_id int,
   status bit,
   record_time datetime,
   foreign key(dormitory_id) references dormitory(id));

insert into dormitory values (301), (302);
insert into student values (1, 'zhangsan', 301), (2, 'lisi', 301), (3, 'wangwu', 301), (4, 'zhaoliu', 302);

insert into records values (1, 301, 1, '2021-12-12 12:12:12');
insert into records values (2, 302, 0, '2021-12-12 13:13:13');

mysql> select * from dormitory;
+-----+
| id  |
+-----+
| 301 |
| 302 |
+-----+
2 rows in set (0.00 sec)

mysql> select * from student;
+----+----------+--------------+
| id | name     | dormitory_id |
+----+----------+--------------+
|  1 | zhangsan |          301 |
|  2 | lisi     |          301 |
|  3 | wangwu   |          301 |
|  4 | zhaoliu  |          302 |
+----+----------+--------------+
4 rows in set (0.00 sec)

mysql> select * from records;
+----+--------------+--------+---------------------+
| id | dormitory_id | status | record_time         |
+----+--------------+--------+---------------------+
|  1 |          301 |       | 2021-12-12 12:12:12 |
|  2 |          302 |        | 2021-12-12 13:13:13 |
+----+--------------+--------+---------------------+
2 rows in set (0.00 sec)


-- staff attenance
create table staff (id int primary key, name varchar(20));

create table attenance (
   id int primary key, 
   staff_id int, 
   info_time datetime,
   foreign key(staff_id) references staff(id));

insert into staff values (1, 'zhangsan'), (2, 'lisi');

insert into attenance values (1, 001, '2021-03-03 9:00:00');
insert into attenance values (2, 002, '2021-03-03 9:00:00');


mysql> select * from staff;
+----+----------+
| id | name     |
+----+----------+
|  1 | zhangsan |
|  2 | lisi     |
+----+----------+
2 rows in set (0.00 sec)

mysql> select * from attenance;
+----+----------+---------------------+
| id | staff_id | info_time           |
+----+----------+---------------------+
|  1 |        1 | 2021-03-03 09:00:00 |
|  2 |        2 | 2021-03-03 09:00:00 |
+----+----------+---------------------+
2 rows in set (0.00 sec)