(select u.name as results
from users u inner join movierating r on u.user_id = r.user_id
group by r.user_id
order by count(*) desc, u.name
limit 1)

union all

(select m.title as results
from movies m inner join movierating r on m.movie_id = r.movie_id
where r.created_at like "2020-02%"
group by r.movie_id
order by avg(r.rating) desc, m.title
limit 1)