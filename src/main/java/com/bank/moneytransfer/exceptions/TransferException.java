package com.bank.moneytransfer.exceptions;

public class TransferException extends RuntimeException{

    private final int transactionID;

    public TransferException(int transactionID, String message){
        super(message);
        this.transactionID = transactionID;
    }

    public int getTransactionID() {
        return transactionID;
    }
}
