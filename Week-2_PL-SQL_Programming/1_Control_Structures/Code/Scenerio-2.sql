BEGIN
    FOR rec IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
        -- Set IsVIP flag to TRUE
        UPDATE Customers
        SET IsVIP = 'TRUE' -- Assuming IsVIP is a VARCHAR2 column; use 1 if it's a NUMBER
        WHERE CustomerID = rec.CustomerID;
    END LOOP;
END;