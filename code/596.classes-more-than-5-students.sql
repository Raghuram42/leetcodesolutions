/* Write your T-SQL query statement below */
SELECT class FROM (SELECT DISTINCT  * FROM courses) C
GROUP BY class
HAVING COUNT(student) > 4; 