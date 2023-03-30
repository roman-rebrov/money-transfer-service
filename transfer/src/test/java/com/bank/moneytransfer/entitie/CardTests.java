package com.bank.moneytransfer.entitie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTests {

    private Card card;
    private String cardNumber = "1234567890123456";
    private String cardCVV = "123";
    private String cardValidTill = "12/29";
    private String cardCurrency = "RUS";
    private int cardValue = 100;

    public CardTests() {
        this.card = new Card();
        this.card.setCardNumber(cardNumber);
        this.card.setCardCVV(cardCVV);
        this.card.setCardValidTill(cardValidTill);
        this.card.setCurrency(cardCurrency);
        this.card.setValue(cardValue);
    }

    @Test
    @DisplayName("cardObjectTest")
    public void cardObjectTest() {

        Assertions.assertEquals(this.cardNumber, this.card.getCardNumber());
        Assertions.assertEquals(this.cardCVV, this.card.getCardCVV());
        Assertions.assertEquals(this.cardValidTill, this.card.getCardValidTill());
        Assertions.assertEquals(this.cardCurrency, this.card.getCurrency());
        Assertions.assertEquals(this.cardValue, this.card.getValue());
    }
}
