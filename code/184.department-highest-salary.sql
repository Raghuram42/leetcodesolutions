/* Write your T-SQL query statement below */
WITH CTE_MAXS AS
(SELECT D.Id, D.Name AS Department, MAX(Salary) AS Salary FROM Employee E
INNER JOIN Department D ON
D.Id = E.DepartmentId
GROUP BY D.Id, D.Name)
SELECT Department, E.Name AS Employee, E.Salary FROM Employee E 
INNER JOIN CTE_MAXS M ON
M.Id = E.DepartmentId AND E.Salary = M.Salary;