# Write your MySQL query statement below
select prices.product_id,coalesce(ROUND(sum(prices.price*unitssold.units)/(sum(unitssold.units)),2),0) as average_price from prices 
left join 
unitssold 
on prices.product_id = unitssold.product_id and prices.start_date<=unitssold.purchase_date and prices.end_date>=unitssold.purchase_date
group by prices.product_id
;