/* Write your T-SQL query statement below */
WITH CTE AS (SELECT Id, Temperature, LAG(Temperature,1) OVER (ORDER BY RecordDate ASC) AS T_m,LAG(RecordDate,1) OVER (ORDER BY RecordDate ASC) AS d_m,RecordDate FROM Weather)
SELECT Id from CTE WHERE Temperature > T_m AND Datediff(day, RecordDate,d_m) = -1; 