package com.bank.moneytransfer.exception;

public class SenderCardException extends TransactionException{
    public SenderCardException(int transactionID, String message) {
        super(transactionID, message);
    }
}
