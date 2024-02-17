SELECT s.user_id, round(ifnull(avg(c.action = 'confirmed'), 0),2) as confirmation_rate
from signups s left join confirmations c on s.user_id = c.user_id
group by user_id