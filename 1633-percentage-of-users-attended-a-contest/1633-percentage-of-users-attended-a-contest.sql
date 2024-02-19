select r.contest_id, round((count(*) / (select count(*) from users)) * 100, 2) as percentage
from users u inner join register r on u.user_id = r.user_id
group by contest_id
order by percentage desc, r.contest_id