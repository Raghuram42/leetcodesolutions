CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    RETURN (
        /* Write your T-SQL query statement below. */
        SELECT TOP 1 E.Salary FROM (SELECT Salary, DENSE_Rank() OVER (ORDER BY Salary Desc) AS Rank FROM Employee) E WHERE E.Rank = @N
    );
END