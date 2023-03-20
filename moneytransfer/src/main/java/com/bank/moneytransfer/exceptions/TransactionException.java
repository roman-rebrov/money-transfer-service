package com.bank.moneytransfer.exceptions;

public class TransactionException extends RuntimeException{

    private final int transactionID;

    public TransactionException(int transactionID, String message){
        super(message);
        this.transactionID = transactionID;
    }

    public int getTransactionID() {
        return transactionID;
    }
}
