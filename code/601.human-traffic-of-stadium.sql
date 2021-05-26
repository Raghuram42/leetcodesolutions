/* Write your T-SQL query statement below */

SELECT S.id, S.visit_date, S.people FROM stadium S
INNER JOIN stadium s2 ON s2.id = S.id+1  AND S.people >= 100 AND s2.people >= 100 
INNER JOIN stadium s3 ON s3.id = S.id+2  AND s3.people >= 100 
UNION
SELECT S.id, S.visit_date, S.people FROM stadium S
INNER JOIN stadium s2 ON s2.id = S.id-1  AND S.people >= 100 AND s2.people >= 100 
INNER JOIN stadium s3 ON s3.id = S.id-2  AND s3.people >= 100
UNION
SELECT S.id, S.visit_date, S.people FROM stadium S
INNER JOIN stadium s2 ON s2.id = S.id-1  AND S.people >= 100 AND s2.people >= 100 
INNER JOIN stadium s3 ON s3.id = S.id+1  AND s3.people >= 100 ;

