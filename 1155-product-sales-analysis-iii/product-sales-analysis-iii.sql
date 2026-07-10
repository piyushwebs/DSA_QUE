# Write your MySQL query statement below
select s1.product_id,s1.year as first_year,s1.quantity,s1.price from sales as s1
cross join
(select product_id,min(year) as first_year from sales group by product_id) as min_year
on 
min_year.product_id = s1.product_id 
and min_year.first_year = year;
