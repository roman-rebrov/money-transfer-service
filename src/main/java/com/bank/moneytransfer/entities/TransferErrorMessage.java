package com.bank.moneytransfer.entities;

public class TransferErrorMessage {
    private String message;
    private int di;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDi() {
        return di;
    }

    public void setDi(int di) {
        this.di = di;
    }
}
