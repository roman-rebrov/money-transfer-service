package com.bank.moneytransfer.repository;

import com.bank.moneytransfer.entity.Account;
import com.bank.moneytransfer.entity.Card;
import com.bank.moneytransfer.entity.Transaction;

import java.util.Optional;

public interface TransferRepository {
    void addTransaction (Transaction transaction);
    Optional<Transaction> getTransactionByID (int id);
    Optional<Card> getCardByNumber (String cardNumber);
    boolean addAccount(Account newAccount);
}
