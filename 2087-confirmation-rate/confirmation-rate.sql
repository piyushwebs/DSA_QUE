# Write your MySQL query statement below
select signups.user_id,
ROUND((count(case when action='confirmed' then 1 end)/(case when count(confirmations.action) = 0 then 1 else count(confirmations.action) end)),2) as confirmation_rate from signups 
left join 
confirmations 
on signups.user_id = confirmations.user_id
group by signups.user_id
;