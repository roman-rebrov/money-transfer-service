package com.bank.moneytransfer.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransactionTests {

    private Transaction transaction;
    private String cardFromNumber = "1234567890123456";
    private String cardToNumber = "6543210987654321";
    private String currency = "RUS";
    private int amount = 200;
    private int commission = 1;

    public TransactionTests() {
        this.transaction = new Transaction(
                this.cardFromNumber,
                this.cardToNumber,
                this.currency,
                this.amount,
                this.commission
        );
    }

    @Test
    @DisplayName("transactionObjectTest")
    public void transactionObjectTest() {

        this.transaction.successfulTransfer();

        Assertions.assertTrue(this.transaction.isTransfer());

        Assertions.assertEquals(this.cardFromNumber, this.transaction.getCardFromNumber());
        Assertions.assertEquals(this.cardToNumber, this.transaction.getCardToNumber());
        Assertions.assertEquals(this.amount, this.transaction.getAmount());
        Assertions.assertEquals(this.commission, this.transaction.getCommission());
        Assertions.assertEquals(true, this.transaction.getID() > 0);
    }
}
