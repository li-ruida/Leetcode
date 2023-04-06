select
    user_id,
    count(user_id) followers_count
from Followers
group by user_id
order by user_id