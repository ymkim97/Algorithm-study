select p.product_name, sum(o.unit) as unit
from products p inner join orders o on p.product_id = o.product_id
where order_date like "2020-02%"
group by product_name
having unit >= 100