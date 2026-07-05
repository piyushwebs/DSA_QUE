# Write your MySQL query statement below
select students.student_id,students.student_name,s1.subject_name,count(examinations.subject_name) as attended_exams
from students
cross join 
subjects as s1
left join 
examinations 
on students.student_id = examinations.student_id and s1.subject_name = examinations.subject_name
group by students.student_id,s1.subject_name
order by students.student_id,s1.subject_name; 