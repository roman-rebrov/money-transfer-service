package com.bank.moneytransfer.entity;


public class TransferAmount {

    private String currency;

    private int value;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TransferAmount{" +
                "currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}
