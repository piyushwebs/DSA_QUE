# Write your MySQL query statement below
select (name) as customers from customers
where ( id ) NOT IN
(
    select customerId from orders
);