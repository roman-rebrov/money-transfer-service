package com.bank.moneytransfer.exception;

public class AmountException extends TransactionException{
    public AmountException(int transactionID, String message) {
        super(transactionID, message);
    }
}