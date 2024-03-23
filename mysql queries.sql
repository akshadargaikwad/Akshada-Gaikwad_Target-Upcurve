select e.lastname,d.department_name,d.department_id
from employees e
join departments d 
on e.department_id=d.department_id;

select distinct j.job_title,d.location_id
from employees e
join jobs j on e.job_id=j.job_id
join departments d on e.department_id=d.department_id
where d.department_id=30;

select e.lastname,d.department_name,l.location_id,l.city 
from employees e
join departments d on e.department_id=d.department_id
join locations l on d.location_id=l.location_id
where e.commission_pct is not null;

select e.lastname,d.department_name 
from employees e
join departments d 
on e.department_id=d.department_id
where e.lastname like '%a%';

select e.lastname,j.job_title,e.department_id,d.department_name
from employees e
join jobs j on e.job_id=j.job_id
join departments d on e.department_id=d.department_id
join locations l on d.location_id=l.location_id
where l.city='Toronto';

select e.lastname as Employee , e.employee_id as "Emp#",m.lastname as Manager,e.manager_id as "Manager#"
from employees e
left join employees m
on e.manager_id=m.employee_id;

select e.lastname as Employee , e.employee_id as "Emp#", m.lastname as Manager, e.manager_id as "Manager#"
from employees e
left join employees m on e.manager_id=m.employee_id
order by e.employee_id;

select e1.lastname as "Employee Lastname", e1.department_id as "Department Number",e2.lastname as "Co-worker Lastname"
from employees e1
join employees e2 on e1.department_id=e2.department_id
where e1.employee_id=103;

select e.firstname as name,j.job_title as job,d.department_name as "department name", e.salary,j.grade
from employees e
join jobs j on e.job_id=j.job_id
join departments d on e.department_id=d.department_id;

select firstname,lastname,hire_date
from employees
where hire_date>(select hire_date from employees where lastname="Davies");

select e1.firstname as Employee, e1.hire_date as "Emp hired", e2.firstname as manager,e2.hire_date as "Manager hired"
from employees e1
join employees e2 on e1.manager_id =e2.employee_id
where e1.hire_date<e2.hire_date;

select max(salary) as Maximum,min(salary) as Minimumn,sum(salary) as Sum, avg(salary) as Average 
from employees ;

select job_id, max(salary) as Maximumn,min(salary) as Minimum,sum(salary) as sum, avg(salary) as average
from employees
group by job_id;

select j.job_title, count(*) as "Number of People" from jobs as j,employees as e
join e.job_id on j.job_id
group by job_id;

select count(DISTINCT MANAGER_ID) from employees ;

select max(salary)-min(salary) as Difference from employees;

select manager_id, min(salary) as "Lowest Salary" from employees
where manager_id is not null
group by manager_id
having min(salary)>=60000
order by "Lowest Salary" desc;


select d.department_name,l.location_id, count(*) as "No of employees", round(avg(salary),2) as salary from employees e
join departments d on e.department_id=d.department_id
join locations l on d.location_id=l.location_id
group by d.department_name,l.location_id; 

select e.lastname,e.hire_date from employees as e
where e.department_id=(select department_id from employees where lastname='Zlotkey')
and lastname!='Zlotkey';

select employee_id, lastname from employees 
where salary>(select avg(salary) from employees)
order by salary asc;

select employee_id, lastname
from employees
where department_id in (select department_id from employees where lastname like '%u%');

select lastname,department_id,job_id 
from employees
where department_id in (select department_id from departments where location_id=1700);

select e.lastname,e.salary 
from employees as e
join employees m on e.manager_id=m.employee_id
where m.lastname='King';

select e.department_id,e.lastname,e.job_id 
from employees as e
where e.department_id in (select department_id from departments where department_name='Executive');

select e.employee_id,e.lastname,e.salary 
from employees as e
join employees e2 on e.department_id=e2.department_id
where e.salary>(select avg(salary) from employees )
and e2.lastname like '%u%';

select distinct department_id from employees;

select * from employees order by firstname desc;

select firstname,lastname,salary, salary*0.15 as PF from employees;

select employee_id, firstname,lastname,salary from employees
order by salary asc;

select sum(salary) as 'Total Payable Salary' from employees;

select max(salary) as "Maximum Salary" , min(salary) as "Minimum Salary" from
employees;

select count(*) as "Total No of Employees" from employees;

select count(distinct job_id) as "no of jobs available " from employees;

select UPPER(firstname) from employees;

select substring(firstname,1,3) from employees;

select concat(firstname,' ',lastname) as "Employee name" 
from employees;

select trim(firstname) from employees;

select length(concat(firstname,lastname)) from employees;

select firstname from employees where firstname regexp '[0-9]';

select * from employees limit 10;

select employee_id,lastname,round(salary/12,2) from employees;

select firstname,lastname, salary 
from employees
where salary  not between 10000 and 15000;

select firstname,lastname,department_id from employees
where department_id in(30,100)
order by department_id asc;

select firstname,lastname,salary from employees 
where salary not between 10000 and 150000
and department_id in (30,100);

select firstname,lastname,hire_date 
from employees
where  year(hire_date)=1987;

select firstname
from employees
where firstname like '%b%' and firstname like '%c%';


select e.lastname,j.job_title,e.salary 
from employees as e
join jobs j on e.job_id=j.job_id
where j.job_title in('Programmer','Clerk')
and salary not in (4500,10000,15000);

select lastname
from employees
where length(lastname)=6;

select lastname
from employees
where lastname like '__e%';

select distinct(j.job_title)
from employees as e
join jobs as j on e.job_id=j.job_id;

select firstname,lastname,salary, salary*0.15 as PF 
from employees;

select * 
from employees
where lastname in ('BLAKE','SCOTT','KING','FORD');

select count(distinct job_id) 
from employees;

select sum(salary)
from employees;

select min(salary)
from employees;

select max(salary) 
from employees
where job_id=(select job_id from jobs where job_title='Programmer');

select avg(salary) as "Average salary" , count(*) as "no of employees"
from employees
where department_id=90;

select max(salary),min(salary),sum(salary) ,avg(salary)
from employees;

select j.job_title,count(*) as "No of employees"
from employees
join jobs j on employees.job_id=j.job_id
group by job_title;

select (max(salary)-min(salary)) from employees;

select manager_id , min(salary) as "Lowest Salary"
from employees
group by manager_id;

select department_id,sum(salary) as "total salary payable"
from employees
group by department_id;

select job_id , avg(salary)
from employees
where job_id!='Programmer'
group by job_id;

select job_id,sum(salary),max(salary),min(salary),avg(salary)
from employees
where department_id=90
group by job_id;

select job_id ,max(salary) 
from employees
group by job_id
having max(salary)>=4000;

select department_id,avg(salary) 
from employees
group by department_id
having count(*) >10;

select firstname,lastname,salary 
from employees
where salary>(select salary from employees where lastname='Bull');

select firstname,lastname
from employees
where department_id=(select department_id from departments where department_name='IT');

select e.firstname,e.lastname
from employees as e
join departments d on e.department_id=d.department_id
where e.manager_id is not null
and d.location_id in (select location_id from locations where country_id='US'); 

select firstname,lastname
from employees
where employee_id in (select manager_id from employees);

select firstname,lastname,salary
from employees
where salary>(select avg(salary) from employees);

select firstname,latsname,salary
from employees as e
where salary=(select min(salary) from employees where grade=e.grade);

select firstname,lastname, salary
from employees
where salary>(select avg(salary) from employees) and department_id in (select department_id from departments where department_name like 'IT%');

select firstname,lastname,salary
from employees 
where salary>(select salary from employees where lastname='Bell');

select firstname,lastname,salary 
from employees
where salary=(select min(salary) from employees);

select firstname,lastname,salary
from employees
where salary>(select avg(salary) from employees);

select firstname,lastname,salary 
from employees
where salary>all(select salary from employees where job_id='SH_CLERK')
order by salary;

select firstname,lastname,salary
from employees
where salary<all(select salary from employees where job_id='SH_CLERK')
order by salary desc;

select firstname,lastname,salary 
from employees e
where salary=(Select max(salary) from employees where department_id=e.department_id);

select firstname,lastname,salary
from employees e
where salary=(select min(salary) from employees where department_id=e.department_id);

select firstname,lastname,salary
from employees
where salary>(select avg(salary) from employees)
and department_id in (select department_id from departments where department_name like 'IT%');

select firstname,lastname,salary
from employees e
join departments d on e.department_id=d.department_id
where salary>(select avg(salary) from employees)
and d.department_name like 'IT%';

select e.firstname,e.lastname
from employees e
join departments d on e.department_id=d.department_id
where e.manager_id is not null
and d.location_id in (select location_id from locations where country_id='US');

select e.firstname,e.lastname
from employees e
join departments d on e.department_id=d.department_id
where e.manager_id is not null
and d.location_id in (select location_id from locations where country_id='US');

select * from employees
where department_id=(select department_id from (select department_id,count(*) as emp_count from employees group by department_id order by emp_count limit 1) as temp);


SELECT d.department_name, SUM(e.salary) AS "Total Salary Payable"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;

SELECT department_id, MAX(salary) AS "Highest Salary"
FROM employees
GROUP BY department_id;

SELECT department_id, MAX(salary) AS "Highest Salary"
FROM employees
GROUP BY department_id
HAVING salary = MAX(salary);

SELECT job_id, AVG(salary) AS "Average Salary"
FROM employees
WHERE job_id != 'Programmer'
GROUP BY job_id;

SELECT first_name, last_name
FROM employees
WHERE manager_id IS NOT NULL;

SELECT first_name, last_name
FROM employees
WHERE employee_id NOT IN (SELECT supervisor_id FROM employees);

SELECT first_name, last_name
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);


SELECT first_name, last_name
FROM employees
WHERE department_id IN (SELECT department_id FROM departments WHERE location_id IN (SELECT location_id FROM locations WHERE country_id = 'US'));


SELECT first_name, last_name
FROM employees
WHERE salary = (SELECT MIN(salary) FROM employees);

SELECT first_name, last_name
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees)
AND department_id IN (SELECT department_id FROM departments WHERE department_name LIKE 'IT%');

SELECT first_name, last_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE salary > (SELECT AVG(salary) FROM employees)
AND d.department_name LIKE 'IT%';

SELECT salary
FROM employees e1
WHERE n = (SELECT COUNT(DISTINCT salary) FROM employees e2 WHERE e2.salary >= e1.salary);


SELECT e.first_name, e.last_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE e.manager_id IS NOT NULL
AND d.location_id IN (SELECT location_id FROM locations WHERE country_id = 'US');


SELECT first_name, last_name
FROM employees
WHERE employee_id NOT IN (SELECT supervisor_id FROM employees);


SELECT first_name, last_name
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

SELECT first_name, last_name
FROM employees
WHERE department_id IN (SELECT department_id FROM departments WHERE location_id IN (SELECT location_id FROM locations WHERE country_id = 'US'));

SELECT first_name, last_name
FROM employees
WHERE salary = (SELECT MIN(salary) FROM employees);

SELECT first_name, last_name
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees)
AND department_id IN (SELECT department_id FROM departments WHERE department_name LIKE 'IT%');

SELECT first_name, last_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE salary > (SELECT AVG(salary) FROM employees)
AND d.department_name LIKE 'IT%';

SELECT salary
FROM employees e1
WHERE n = (SELECT COUNT(DISTINCT salary) FROM employees e2 WHERE e2.salary >= e1.salary);

SELECT department_name
FROM departments
WHERE department_id NOT IN (SELECT department_id FROM employees WHERE manager_id IS NOT NULL);

SELECT d.department_name, COUNT(*) AS "Number of Employees"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;

SELECT e.department_id, SUM(e.salary) AS "Total Salary"
FROM employees e
GROUP BY e.department_id;

SELECT d.department_name, AVG(e.salary) AS "Average Salary"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;

SELECT job_id, MAX(salary) AS "Highest Salary", MIN(salary) AS "Lowest Salary", SUM(salary) AS "Total Salary", AVG(salary) AS "Average Salary"
FROM employees
GROUP BY job_id;

SELECT e.department_id, j.job_id, SUM(e.salary) AS "Total Salary"
FROM employees e
JOIN jobs j ON e.job_id = j.job_id
GROUP BY e.department_id, j.job_id;

SELECT jh.employee_id, j.job_title, DATEDIFF(jh.end_date, jh.start_date) AS "Days Difference"
FROM job_history jh
JOIN jobs j ON jh.job_id = j.job_id
WHERE jh.department_id = 90;

SELECT d.department_id, d.department_name, COUNT(*) AS "Total Employees"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_id, d.department_name
ORDER BY COUNT(*) DESC;

SELECT d.department_name, CONCAT(e.first_name, ' ', e.last_name) AS "Manager Name", COUNT(*) AS "Total Employees"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name, e.first_name, e.last_name;

SELECT d.department_name, d.manager_id, COUNT(*) AS "Total Employees"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name, d.manager_id
HAVING COUNT(*) > 3;

SELECT d.department_name, l.city, COUNT(*) AS "Total Employees"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
GROUP BY d.department_name, l.city;

SELECT d.department_name, l.city, COUNT(*) AS "Total Employees"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
GROUP BY d.department_name, l.city
HAVING COUNT(*) > 3;

SELECT e.first_name, e.last_name, e.salary
FROM employees e
JOIN (
    SELECT department_id, MAX(salary) AS "max_salary"
    FROM employees
    GROUP BY department_id
) m ON e.department_id = m.department_id AND e.salary = m.max_salary;

SELECT first_name, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

SELECT first_name, last_name
FROM employees
WHERE employee_id NOT IN (SELECT supervisor_id FROM employees);

SELECT *
FROM employees
WHERE department_id = (SELECT department_id FROM (SELECT department_id, COUNT(*) AS emp_count FROM employees GROUP BY department_id ORDER BY emp_count LIMIT 1) AS temp);

SELECT d.department_name, SUM(e.salary) AS "Total Salary Payable"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;

SELECT d.department_name, AVG(e.salary) AS "Average Salary"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;

SELECT job_id, MAX(salary) AS "Highest Salary", MIN(salary) AS "Lowest Salary", SUM(salary) AS "Total Salary", AVG(salary) AS "Average Salary"
FROM employees
GROUP BY job_id;





