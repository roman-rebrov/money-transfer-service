package com.bank.moneytransfer.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Account {

    private static long IDCounter = 1;

    private final long ID;
    private final Map<String, Card> cards = new HashMap<>();

    public Account(){
        this.ID = IDCounter++;
    }

    public boolean addNewCard (Card newCard){
        if (!cards.containsKey(newCard.getCardNumber())) {
            String cardNumber = newCard.getCardNumber();
            this.cards.put(cardNumber, newCard);
            return true;
        }else {
            return false;
        }
    }

    public Optional<Card> getCard(final String cardNumber) {
        if (this.cards.containsKey(cardNumber)) {
            return Optional.of(this.cards.get(cardNumber));
        }
        return Optional.of(null);
    }

    public boolean cardContains(String cardNumber){
        return this.cards.containsKey(cardNumber);
    }
}
