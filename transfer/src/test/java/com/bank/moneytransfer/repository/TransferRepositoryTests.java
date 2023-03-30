package com.bank.moneytransfer.repository;

import com.bank.moneytransfer.entitie.Account;
import com.bank.moneytransfer.entitie.Card;
import com.bank.moneytransfer.entitie.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class TransferRepositoryTests {

    private TransferRepositoryImpl repository;
    private String cardNumber = "1234567890123456";


    private Transaction createTransaction() {
        final Transaction transaction = Mockito.mock(Transaction.class);

        return transaction;
    }

    private Account createAccount() {
        final Account account = Mockito.mock(Account.class);

        return account;
    }

    @BeforeEach
    public void createRepository() {
        this.repository = new TransferRepositoryImpl();

    }

    @Test
    @DisplayName("addAccountMethodTest")
    public void addAccountMethodTest() {

        final boolean addedAccountResult = this.repository.addAccount(this.createAccount());

        Assertions.assertTrue(addedAccountResult);
        Assertions.assertFalse(this.repository.addAccount(null));
    }

    @Test
    @DisplayName("getCardByNumberTest")
    public void getCardByNumberTest() {
        final Account account = this.createAccount();
        final Card card = Mockito.mock(Card.class);

        Mockito.when(account.getCard(this.cardNumber)).thenReturn(Optional.of(card));
        Mockito.when(account.cardContains(this.cardNumber)).thenReturn(true);

        this.repository.addAccount(account);

        final Optional<Card> result = this.repository.getCardByNumber(this.cardNumber);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(card, result.get());
    }

    @Test
    @DisplayName("getTransactionByIDTest")
    public void getTransactionByIDTest() {
        final Transaction transaction = this.createTransaction();
        Mockito.when(transaction.getID()).thenReturn(1);

        this.repository.addTransaction(transaction);

        final Optional<Transaction> result = this.repository.getTransactionByID(transaction.getID());

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(transaction, result.get());
    }
}
