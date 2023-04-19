with RECURSIVE hours as (
    select 0 as n
    union all
    select n + 1 from hours where n < 23)

select hours.n as hour, count(animal_outs.datetime) as count
from hours left join animal_outs on hours.n = hour(animal_outs.datetime)
group by hour
order by hour