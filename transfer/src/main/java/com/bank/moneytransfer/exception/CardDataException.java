package com.bank.moneytransfer.exception;

public class CardDataException extends TransactionException{
    public CardDataException(int transactionID, String message) {
        super(transactionID, message);
    }
}
