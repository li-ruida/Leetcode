
#183. 从不订购的客户

select Name as Customers from Customers
where Customers.Id not in (
    select CustomerId from Orders
);