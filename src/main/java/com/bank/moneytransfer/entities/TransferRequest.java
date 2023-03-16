package com.bank.moneytransfer.entities;


public class TransferRequest {


    private String cardFromNumber;
    private String cardFromCVV;
    private String cardFromValidTill;

    private String cardToNumber;

    private TransferAmount amount;

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCW) {
        this.cardFromCVV = cardFromCW;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public TransferAmount getAmount() {
        return amount;
    }

    public void setAmount(TransferAmount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromCW='" + cardFromCVV + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardToNumber='" + cardToNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
