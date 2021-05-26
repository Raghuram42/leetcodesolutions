/* Write your T-SQL query statement below */
WITH CTE1 AS 
(SELECT T.* FROM Trips T 
INNER JOIN Users U ON T.Client_Id = U.Users_Id INNER JOIN Users UD ON T.Driver_Id = UD.Users_Id 
AND (U.Banned = 'No' AND UD.Banned = 'No')
AND T.Request_at BETWEEN '2013-10-01' AND '2013-10-03')
,CTE2 AS(SELECT  Request_at, COUNT(1) AS NM
FROM 
CTE1
GROUP BY Request_at)
, CTE3 AS (
SELECT  Request_at, COUNT(1) AS DE
FROM 
CTE1
WHERE Status <> 'completed'
GROUP BY Request_at)
SELECT F.Request_at AS Day,ISNULL(ROUND(CAST((S.DE*1.00/F.NM) AS FLOAT),2,0) ,0.00) AS [Cancellation Rate]
FROM CTE2 F LEFT JOIN CTE3 S
ON F.Request_at = S.Request_at;