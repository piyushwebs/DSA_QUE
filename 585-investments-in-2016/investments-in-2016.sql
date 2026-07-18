# Write your MySQL query statement below
select  ROUND(sum(I1.tiv_2016),2) as tiv_2016 from 
    Insurance as I1 
    where Exists
    (
        select 1
        from 
        Insurance as I2
        where I1.tiv_2015 = I2.tiv_2015 and I1.pid<>I2.pid
    )
    AND (I1.lat,I1.lon) NOT in
    (
         select  lat,lon
         from Insurance 
         where I1.pid<>pid 
    );