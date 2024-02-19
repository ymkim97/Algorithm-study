select a.query_name, round(sum(rating / position) / count(*), 2) as quality, 
round((select count(*) from queries b where rating < 3 and a.query_name = b.query_name) / count(*) * 100, 2) as poor_query_percentage
from queries a
where query_name is not null
group by query_name