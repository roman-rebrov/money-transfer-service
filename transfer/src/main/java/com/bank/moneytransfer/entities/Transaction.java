package com.bank.moneytransfer.entities;


import com.bank.moneytransfer.utils.DateTime;

public class Transaction {

    private static int IDCounter = 1;

    private final int ID;
    private final String date;
    private final String time;
    private final String cardFromNumber;
    private final String cardToNumber;
    private final String currency;
    private final int amount;
    private final int commission;
    private boolean transfer = false;



    public Transaction (
            String cardFromNumber,
            String cardToNumber,
            String currency,
            int amount,
            int commission
    ){
        this.ID = IDCounter++;
        this.date = DateTime.getDate();
        this.time = DateTime.getTime();
        this.cardFromNumber = cardFromNumber;
        this.cardToNumber = cardToNumber;
        this.currency = currency;
        this.amount = amount;
        this.commission = commission;
    }

    public int getID() {
        return ID;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void successfulTransfer(){
        this.transfer = true;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public int getAmount() {
        return amount;
    }

    public int getCommission() {
        return commission;
    }

}
