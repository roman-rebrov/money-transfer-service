package com.bank.moneytransfer.exceptions;

public class TransactionConfirmOperationException extends RuntimeException{

    private final int transactionID;

    public TransactionConfirmOperationException(int transactionID, String message){
        super(message);
        this.transactionID = transactionID;
    }

    public int getTransactionID() {
        return transactionID;
    }
}
