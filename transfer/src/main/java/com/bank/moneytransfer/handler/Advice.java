package com.bank.moneytransfer.handler;

import com.bank.moneytransfer.exception.InputDataException;
import com.bank.moneytransfer.exception.TransactionConfirmOperationException;
import com.bank.moneytransfer.exception.TransactionErrorMessage;
import com.bank.moneytransfer.exception.TransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

@RestControllerAdvice
public class Advice {

    private Logger logger = Logger.getLogger("Advice_Logger");

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<TransactionErrorMessage> transferErrorMessage(TransactionException ex) {

        this.logger.info(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransactionErrorMessage message = new TransactionErrorMessage();
        message.setMessage("SERVER ERROR");
        message.setID(ex.getTransactionID());

        return new ResponseEntity<TransactionErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InputDataException.class)
    public ResponseEntity<TransactionErrorMessage> inputDataErrorMessage(InputDataException ex) {

        this.logger.info(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransactionErrorMessage message = new TransactionErrorMessage();
        message.setMessage("Incorrect data");
        message.setID(ex.getTransactionID());

        return new ResponseEntity<TransactionErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransactionConfirmOperationException.class)
    public ResponseEntity<TransactionErrorMessage> confirmOperationErrorMessage(TransactionConfirmOperationException ex) {

        this.logger.info(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransactionErrorMessage message = new TransactionErrorMessage();
        message.setMessage(ex.getMessage());
        message.setID(ex.getTransactionID());

        return new ResponseEntity<TransactionErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
