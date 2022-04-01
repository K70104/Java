drop database if exists ebook;
create database ebook character set 'utf8mb4';
use ebook;

-- table structure for category
drop table if exists category;
create table category (id int(11) primary key auto_increment, name varchar(20));

-- records of category
insert into category values (1, '历史');
insert into category values (2, '艺术');
insert into category values (3, '计算机');
insert into category values (4, '数学');
insert into category values (5, '小说');

-- table structure for student
drop table if exists student;
create table student (id int(11) primary key auto_increment, name varchar(20));

-- records of student
insert into student values (1, '王昭君');
insert into student values (2, '李白');
insert into student values (3, '貂蝉');
insert into student values (4, '小乔');
insert into student values (5, '韩信');

-- table structure for book
drop table if exists book;
create table book (
    id int(11) primary key auto_increment,
    name varchar(20),
    author varchar(20),
    price decimal(10, 2),
    category_id int(11),
    constraint fk_book_category_id foreign key (category_id) references category (id));

-- records of book
insert into book values (1, '深入理解java虚拟机', '周志明', 57.90, 3);
insert into book values (2, '西游记', '吴承恩', 30.68, 5);
insert into book values (3, '儒林外史', '吴敬梓', 18.80, 5);
insert into book values (4, '聊斋志异', '蒲松龄', 21.00, 5);
insert into book values (5, '史记', '司马迁', 278.20, 1);
insert into book values (6, '资治通鉴', '司马光', 524.00, 1);
insert into book values (7, 'java核心技术 卷i：基础知识', 'cay s. horstmann', 92.50, 3);
insert into book values (8, 'java核心技术卷ii：高级特性', 'cay s. horstmann', 111.20, 3);
insert into book values (9, 'java多线程编程核心技术', '高洪岩', 47.50, 3);
insert into book values (10, '诗经', '孔子', 22.00, 2);
insert into book values (11, '唐诗三百首', '蘅塘居士', 49.30, 2);
insert into book values (12, '唐诗三百首', '蘅塘居士', 55.00, 2);
insert into book values (13, '西游记', '吴承恩', 47.50, 5);
insert into book values (14, '唐诗三百首', '蘅塘居士', 56.50, 2);

-- table structure for borrow_info
drop table if exists borrow_info;
create table borrow_info (
    id int(11) primary key auto_increment,
    book_id int(11),
    student_id int(11),
    start_time timestamp null,
    end_time timestamp null,
    constraint fk_borrow_info_book_id foreign key (book_id) references book (id),
    constraint fk_borrow_info_student_id foreign key (student_id) references student (id));

-- records of borrow_info
insert into borrow_info values (1, 1, 1, '2018-11-07 18:50:43', '2018-12-07 18:51:01');
insert into borrow_info values (2, 7, 1, '2019-07-10 10:21:00', '2019-09-10 10:21:00');
insert into borrow_info values (3, 8, 1, '2019-09-10 10:21:00', '2019-10-10 10:21:00');
insert into borrow_info values (4, 2, 2, '2019-03-02 16:37:00', '2019-04-02 16:37:00');
insert into borrow_info values (5, 4, 2, '2019-03-12 14:25:00', '2019-04-12 14:25:00');
insert into borrow_info values (6, 10, 2, '2019-07-13 16:21:00', '2019-10-13 16:21:00');
insert into borrow_info values (7, 11, 2, '2019-06-09 09:40:00', '2019-07-09 09:40:00');
insert into borrow_info values (8, 13, 2, '2019-01-03 15:11:00', '2019-04-03 15:11:00');
insert into borrow_info values (9, 7, 3, '2019-05-15 13:13:00', '2019-06-15 13:13:00');
insert into borrow_info values (10, 8, 3, '2019-04-27 13:53:00', '2019-05-27 13:53:00');
insert into borrow_info values (11, 9, 3, '2019-06-01 11:32:00', '2019-07-01 11:32:00');
insert into borrow_info values (12, 3, 4, '2019-07-01 09:40:00', '2019-08-01 09:40:00');
insert into borrow_info values (13, 4, 4, '2019-06-19 11:40:00', '2019-07-19 11:40:00');
insert into borrow_info values (14, 5, 4, '2019-06-25 09:23:00', '2019-09-25 09:23:00');
insert into borrow_info values (15, 10, 4, '2019-08-27 15:30:00', '2019-09-27 15:30:00');
insert into borrow_info values (16, 5, 5, '2019-01-23 14:20:00', '2019-04-23 14:20:00');
insert into borrow_info values (17, 6, 5, '2019-03-09 10:45:00', '2019-04-09 10:45:00');
insert into borrow_info values (18, 10, 5, '2019-06-17 11:32:00', '2019-09-17 11:32:00');

Process finished with exit code 0


/*
select sex, avg(salary) from emp group by sex;

select depart, sum(salary) from emp group by depart;

select depart, sum(salary) form emp group by depart having order by (salary) desc limit 1;

select * from emp as e1, emp as e2 where s1.name = s2.name;

select depart, avg(salary) from emp where sex = 'male' and salary > 10000 group by depart;


select depart, sum(salary) from salary, staff
where staff.staff_id = staff.staff_id
          and month = '2016-09'
group by depart_id;


select depart_name, count(staff_id) from depart, staff
where depart.depart_id = staff.depart_id
group by depart.depart_id;


select month, sum(salary) from salary, staff
where salary.staff_id = staff.staff_id
group by depart_id by month;
（问题a）：求每个部门'2016-09'月份的部门薪水总额
（问题b）：求每个部门的部门人数，要求输出部门名称和人数
（问题c）：求公司每个部门的月支出薪资数，要求输出月份和本月薪资总数
select dep.name, sum( sal.salary ) from salary sal
                                            join staff sta on sal.staff_id = sta.staff_id
                                            join depart dep on sta.depart_id = dep.depart_id
where year ( sal.month ) = 2016
  and month ( sal.month ) = 9
group by dep.depart_id

select dep.name, count( sta.staff_id ) from staff sta
                                                join depart dep on dep.depart_id = sta.depart_id
group by sta.depart_id;
说明：查询要求的信息有部门，有人数，人数只能从员工表中获取，所以关联表为部门表/员工表。按照部门id分组查询员工id的行数
select dep.name, sal.month, sum( sal.salary) from depart dep
                                                      join staff sta on dep.depart_id = sta.depart_id
                                                      join salary sal on sta.staff_id = sal.staff_id
group by dep.depart_id, sal.month;
说明：按照题目要求，查询信息有部门/月/每个部门每月薪资总额，其中薪水信息再薪水表中，
每个员工可以有多条薪资记录（不同时间）。所以需要按照部门分组，再按照月份分组，查询分组的部门在不同月份下的总薪水
*/
