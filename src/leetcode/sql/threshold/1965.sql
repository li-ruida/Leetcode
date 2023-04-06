with tmp as(
    select employee_id from employees
    union all
    select employee_id from salaries
)
select
    employee_id
from tmp t
group by employee_id having count(employee_id)=1 order by 1
# group by 1 按照第一列分组 ,可以类比到group by 2