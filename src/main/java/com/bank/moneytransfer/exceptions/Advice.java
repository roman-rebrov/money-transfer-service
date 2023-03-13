package com.bank.moneytransfer.exceptions;

import com.bank.moneytransfer.entities.TransferErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TransferErrorMessage transferErrorMessage(){
        final TransferErrorMessage message = new TransferErrorMessage();
        message.setMessage("");

        return message;
    }
}
