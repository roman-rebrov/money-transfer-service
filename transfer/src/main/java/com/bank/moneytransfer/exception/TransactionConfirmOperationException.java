package com.bank.moneytransfer.exception;

public class TransactionConfirmOperationException extends TransactionException {

    public TransactionConfirmOperationException(int transactionID, String message) {
        super(transactionID, message);
    }

}
