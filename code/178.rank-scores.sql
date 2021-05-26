/* Write your T-SQL query statement below */
SELECT Score, DENSE_Rank() OVER(Order by Score Desc) AS Rank FROM Scores;