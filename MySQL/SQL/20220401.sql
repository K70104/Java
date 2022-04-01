

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
