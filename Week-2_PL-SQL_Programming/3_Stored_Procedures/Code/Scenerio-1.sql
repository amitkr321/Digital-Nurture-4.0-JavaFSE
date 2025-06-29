CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR rec IN (SELECT AccountID, Balance FROM SavingsAccounts) LOOP
        -- Update the balance with 1% interest
        UPDATE SavingsAccounts
        SET Balance = Balance + (Balance * 0.01)
        WHERE AccountID = rec.AccountID;
    END LOOP;
END;
/
