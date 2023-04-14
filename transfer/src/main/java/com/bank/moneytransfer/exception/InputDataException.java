package com.bank.moneytransfer.exception;

public class InputDataException extends TransactionException {

    public InputDataException(int transactionID, String message) {
        super(transactionID, message);
    }
}