package com.bank.moneytransfer.exception;

public class RecipientCardException extends TransactionException{
    public RecipientCardException(int transactionID, String message) {
        super(transactionID, message);
    }
}
