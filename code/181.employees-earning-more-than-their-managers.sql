/* Write your T-SQL query statement below */
SELECT E.Name AS Employee FROM Employee E LEFT JOIN Employee EM ON EM.ID = E.ManagerId WHERE E.Salary > EM.Salary;