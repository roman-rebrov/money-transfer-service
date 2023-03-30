package com.bank.moneytransfer.repository;

import com.bank.moneytransfer.entitie.Account;
import com.bank.moneytransfer.entitie.Card;
import com.bank.moneytransfer.entitie.Transaction;

import java.util.Optional;

public interface TransferRepository {
    void addTransaction (Transaction transaction);
    Optional<Transaction> getTransactionByID (int id);
    Optional<Card> getCardByNumber (String cardNumber);
    boolean addAccount(Account newAccount);
}
