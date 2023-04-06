#分页思想
with tmp as (
        select distinct salary from Employee order by salary desc
)
select if(count(salary)>=2,(select salary from tmp limit 1,1),null)as SecondHighestSalary
from tmp
#找到最高的薪水，把它排除即可
select max(salary) as secondHighestSalary
from Employee
where salary != (select max(salary)
                 from Employee)

