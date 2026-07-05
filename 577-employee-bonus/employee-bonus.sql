# Write your MySQL query statement below
select Employee.name, bonus.bonus from Employee
Left join 
Bonus
on Employee.empId = Bonus.empId 
where bonus.bonus<1000 or bonus.bonus is null;