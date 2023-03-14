package com.bank.moneytransfer.exceptions;

import com.bank.moneytransfer.entities.TransferErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {

    @ExceptionHandler(TransferException.class)
    public ResponseEntity<TransferErrorMessage> transferErrorMessage(TransferException ex){

        System.out.println(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransferErrorMessage message = new TransferErrorMessage();
        message.setMessage("SERVER_ERROR");
        message.setID(ex.getTransactionID());

        return new ResponseEntity<TransferErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InputDataException.class)
    public ResponseEntity<TransferErrorMessage> inputDataErrorMessage(InputDataException ex) {

        System.out.println(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransferErrorMessage message = new TransferErrorMessage();
        message.setMessage("Incorrect data");
        message.setID(ex.getTransactionID());

        return new ResponseEntity<TransferErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }
    

}
