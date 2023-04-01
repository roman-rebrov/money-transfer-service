package com.bank.moneytransfer.entity;

import java.util.Optional;

public class Account {

    private static int IDCounter = 1;

    private final int ID;
    private Card card = null;

    public Account() {
        this.ID = IDCounter++;
    }

    public boolean addNewCard(Card newCard) {
            this.card = newCard;
            return true;
    }

    public Card getCard() {
        return this.card;
    }

    public Optional<Card> getCard(final String cardNumber) {
        if (this.card.equals(cardNumber)) {
            return Optional.of(this.card);
        }
        return Optional.of(null);
    }

    public boolean cardContains(String cardNumber) {
        return this.card.equals(cardNumber);
    }

    public int getID() {
        return ID;
    }
}
