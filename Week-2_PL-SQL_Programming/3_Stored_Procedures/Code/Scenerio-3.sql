CREATE OR REPLACE PROCEDURE TransferFunds (
    SourceAccountID IN NUMBER,
    TargetAccountID IN NUMBER,
    TransferAmount IN NUMBER
) AS
    SourceBalance NUMBER;
BEGIN
    -- Check source account balance
    SELECT Balance INTO SourceBalance
    FROM Accounts
    WHERE AccountID = SourceAccountID;

    IF SourceBalance < TransferAmount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    ELSE
        -- Deduct the amount from the source account
        UPDATE Accounts
        SET Balance = Balance - TransferAmount
        WHERE AccountID = SourceAccountID;

        -- Add the amount to the target account
        UPDATE Accounts
        SET Balance = Balance + TransferAmount
        WHERE AccountID = TargetAccountID;
    END IF;
END;
/
