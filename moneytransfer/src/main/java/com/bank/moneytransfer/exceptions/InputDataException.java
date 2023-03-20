package com.bank.moneytransfer.exceptions;

public class InputDataException extends RuntimeException{

    private final int transactionID;

    public InputDataException(int transactionID, String message){
        super(message);
        this.transactionID = transactionID;
    }

    public int getTransactionID() {
        return transactionID;
    }
}
