BEGIN
    FOR rec IN (SELECT LoanID, CustomerID, DueDate 
                FROM Loans 
                WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        -- Print reminder message
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.CustomerID || 
                             ', your loan ID ' || rec.LoanID || 
                             ' is due on ' || TO_CHAR(rec.DueDate, 'YYYY-MM-DD'));
    END LOOP;
END;