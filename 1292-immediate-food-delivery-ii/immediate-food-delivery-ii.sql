# Write your MySQL query statement below
select Round((count( case when order_date = customer_pref_delivery_date then 1 end )/count(customer_id))*100,2) as Immediate_percentage from delivery 
where(
    customer_id,order_date
) in( select customer_id,min(order_date) from delivery 
group by customer_id);