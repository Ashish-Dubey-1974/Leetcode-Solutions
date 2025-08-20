select t1.name
from salesperson t1
where t1.sales_id not in(
    select t2.sales_id
    from orders t2
    join company t3 on t3.com_id=t2.com_id
    where t3.name = 'RED'
);