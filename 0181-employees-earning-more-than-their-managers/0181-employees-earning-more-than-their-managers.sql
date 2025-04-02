select e.name as employee
from employee e
join employee m
on m.id=e.managerId
where m.salary<e.salary;