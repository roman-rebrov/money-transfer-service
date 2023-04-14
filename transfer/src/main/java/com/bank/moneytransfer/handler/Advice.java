package com.bank.moneytransfer.handler;

import com.bank.moneytransfer.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

@RestControllerAdvice
public class Advice {

    private Logger logger = Logger.getLogger("Advice_Logger");


    @ExceptionHandler(SenderCardException.class)
    public ResponseEntity<TransactionErrorMessage> senderCardNotExist(SenderCardException ex) {

        this.logger.info(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransactionErrorMessage message = new TransactionErrorMessage();
        message.setMessage("Sender card is not exist");
        message.setID(ex.getTransactionID());

        return new ResponseEntity<TransactionErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(RecipientCardException.class)
    public ResponseEntity<TransactionErrorMessage> recipientCardNotExist(RecipientCardException ex) {

        this.logger.info(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransactionErrorMessage message = new TransactionErrorMessage();
        message.setMessage("Recipient card is not exist");
        message.setID(ex.getTransactionID());

        return new ResponseEntity<TransactionErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(CardDataException.class)
    public ResponseEntity<TransactionErrorMessage> incorrectCardData(CardDataException ex) {

        this.logger.info(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransactionErrorMessage message = new TransactionErrorMessage();
        message.setMessage("Invalid card data");
        message.setID(ex.getTransactionID());

        return new ResponseEntity<TransactionErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(AmountException.class)
    public ResponseEntity<TransactionErrorMessage> invalidAmount(AmountException ex) {

        this.logger.info(ex.getMessage() + " transactionID: " + ex.getTransactionID());

        final TransactionErrorMessage message = new TransactionErrorMessage();
        message.setMessage("This amount is missing on the card");
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
