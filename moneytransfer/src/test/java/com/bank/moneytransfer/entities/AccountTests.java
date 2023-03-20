package com.bank.moneytransfer.entities;

import com.bank.moneytransfer.utils.UtilFactories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AccountTests {

    private Account account;
    private Card card;

    public  AccountTests(){
        this.account = UtilFactories.createAccount();
        this.card = new Card();
        this.card.setCardNumber("1234567890123456");
        this.card.setCardCVV("123");
        this.card.setCardValidTill("12/29");
        this.card.setCurrency("RUS");
        this.card.setValue(100);

        this.account.addNewCard(this.card);
    }

    @Test
    @DisplayName("accountIDTest")
    public void accountIDTest(){

        Assertions.assertEquals(true, this.account.getID() > 0);
    }

    @Test
    @DisplayName("addNewCardTest")
    public void addNewCardTest(){

        Assertions.assertEquals(true, this.account.addNewCard(new Card()));
    }

    @Test
    @DisplayName("cardContainsTest")
    public void cardContainsTest(){

        Assertions.assertEquals(true, this.account.cardContains(this.card.getCardNumber()));
    }

    @Test
    @DisplayName("cardContainsTest")
    public void getCardMethodTest(){

        final Card card1 = this.account.getCard(this.card.getCardNumber()).get();

        Assertions.assertNotNull(card1);
        Assertions.assertEquals(this.card, card1);
    }

    @Test
    @DisplayName("cardLengthTest")
    public void cardLengthTest(){

        final int length = this.account.getCards().size();

        Assertions.assertEquals(1, length);
    }
}
