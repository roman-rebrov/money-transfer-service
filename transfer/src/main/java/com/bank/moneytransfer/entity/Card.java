package com.bank.moneytransfer.entity;


public class Card {

    private String cardNumber;
    private String cardCVV;
    private String cardValidTill;
    private String currency;
    private int value;

    public int putMoney(int sum) {
        this.value = this.value + sum;
        return sum;
    }

    public int withdrawMoney(int sum) {
        this.value = this.value - sum;
        return sum;
    }

    public boolean isAmount(int sum) {
        return this.value >= sum;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardValidTill() {
        return cardValidTill;
    }

    public void setCardValidTill(String cardValidTill) {
        this.cardValidTill = cardValidTill;
    }

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
}
