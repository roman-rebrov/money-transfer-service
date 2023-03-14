package com.bank.moneytransfer.exceptions;

import com.bank.moneytransfer.entities.TransferErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {

    @ExceptionHandler()
    public TransferErrorMessage transferErrorMessage(){
        final TransferErrorMessage message = new TransferErrorMessage();
        message.setMessage("");

        return message;
    }
}
