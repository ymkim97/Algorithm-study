select year(b.sales_date) as year, month(b.sales_date) as month, a.gender, count(distinct a.user_id) as users
from user_info a join online_sale b on a.user_id = b.user_id
where a.gender is not NULL
group by year, month, gender
order by year, month, gender