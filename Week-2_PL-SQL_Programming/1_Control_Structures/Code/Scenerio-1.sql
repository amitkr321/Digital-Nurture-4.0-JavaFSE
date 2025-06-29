BEGIN
    FOR rec IN (SELECT CustomerID, InterestRate FROM Customers WHERE Age > 60) LOOP
        -- Apply a 1% discount to the loan interest rate
        UPDATE Customers
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = rec.CustomerID;
    END LOOP;
END;