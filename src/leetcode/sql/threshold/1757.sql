# 1757. 可回收且低脂的产品
select product_id from Products
where low_fats = 'Y' and recyclable = 'Y';