select a.author_id, b.author_name, a.category, sum(c.sales * a.price) as total_sales
from book a join book_sales c on a.book_id = c.book_id join author b on a.author_id = b.author_id
where c.sales_date like "2022-01%"
group by b.author_name, category
order by a.author_id, category desc