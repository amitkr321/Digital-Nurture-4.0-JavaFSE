CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    DeptID IN NUMBER,
    BonusPercentage IN NUMBER
) AS
BEGIN
    -- Update salary with the given bonus percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * (BonusPercentage / 100))
    WHERE DepartmentID = DeptID;
END;
/
