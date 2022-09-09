#584. 寻找用户推荐人

select name from customer where referee_id != 2 or referee_id is null;

# 注意null与任何值比较都为null