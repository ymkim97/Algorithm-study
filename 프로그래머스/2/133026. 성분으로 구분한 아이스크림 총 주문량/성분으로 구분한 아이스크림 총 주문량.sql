select i.ingredient_type, sum(f.total_order) as TOTAL_ORDER
from icecream_info i
    inner join first_half f on i.flavor = f.flavor
group by i.ingredient_type
order by total_order