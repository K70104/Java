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

--2022-03-15_6-MySQL JDBC编程_作业

--1. 新增貂蝉同学的借阅记录：诗经，从2019年9月25日17:50到2019年10月25日17:50
--2. 查询计算机分类下的图书借阅信息
--3. 修改图书《深入理解Java虚拟机》的价格为61.20
--4. 删除id最大的一条借阅记录

insert into borrow_info values (19, 10, 3, '2019-09-25 17:50:00', '2019-10-25 17:50:00');

-- book：category_id 计算机3
-- borrow_info：book_id
select * from book, borrow_info where book.id = borrow_info.book_id and book.category_id = 3;

update from book set price = 61.20 where name = 深入理解Java虚拟机;

delete from borrow_info where id order by id desc limit 0;



