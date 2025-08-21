# Write your MySQL query statement below
select t1.project_id, round(avg(t2.experience_years),2) as average_years
from project t1
join employee t2
on t1.employee_id = t2.employee_id
group by t1.project_id