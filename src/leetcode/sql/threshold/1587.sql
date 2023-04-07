select name, sum(amount) as balance
from Transactions
         left join Users on Transactions.account = Users.account
group by Transactions.account
having balance > 10000
#
select u.name,sum(t.amount) balance
from  Users u,Transactions t
where u.account = t.account
group by u.account
having balance >10000