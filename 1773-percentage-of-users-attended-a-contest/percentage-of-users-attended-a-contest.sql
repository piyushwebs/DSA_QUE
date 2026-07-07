# Write your MySQL query statement below
select  register.contest_id, Round(((count(register.user_id)/(select count(user_id) from users as count_user))*100),2) as percentage from register
left join 
users
on register.user_id = users.user_id
group by register.contest_id
order by percentage desc,
 contest_id ;