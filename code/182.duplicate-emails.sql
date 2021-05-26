/* Write your T-SQL query statement below */
SELECT Email FROM Person
GROUP BY EMAIL
Having Count(Id) > 1;