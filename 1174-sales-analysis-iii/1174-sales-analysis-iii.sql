select t1.product_id,t1.product_name
from product t1
inner join sales t2 on
t1.product_id=t2.product_id
where t1.product_id not in (
    select t1.product_id
    from product t1
    join sales t2
    on t1.product_id = t2.product_id
    where t2.sale_date<"2019-01-01" or t2.sale_date > "2019-03-31")
group by t1.product_id,t1.product_name
