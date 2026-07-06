# Write your MySQL query statement below
select prices.product_id,(case when ROUND(sum(prices.price*unitssold.units)/(case when sum(unitssold.units) is null then 1 else sum(unitssold.units) end),2) is null then 0 else  ROUND(sum(prices.price*unitssold.units)/(case when sum(unitssold.units) is null then 1 else sum(unitssold.units) end),2) end) as average_price from prices 
left join 
unitssold 
on prices.product_id = unitssold.product_id and prices.start_date<=unitssold.purchase_date and prices.end_date>=unitssold.purchase_date
group by prices.product_id
;