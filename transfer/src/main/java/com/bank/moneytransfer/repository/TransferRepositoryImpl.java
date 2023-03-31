package com.bank.moneytransfer.repository;

import com.bank.moneytransfer.entity.Account;
import com.bank.moneytransfer.entity.Card;
import com.bank.moneytransfer.entity.Transaction;
import com.bank.moneytransfer.util.UtilFactories;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TransferRepositoryImpl implements TransferRepository {

    private final Map<Integer, Transaction> transactions = new HashMap<>();
    private final List<Account> accounts = new ArrayList<>();

    public TransferRepositoryImpl() {

        final Account acc1 = UtilFactories.createAccountWithCard(
                "2585541741745566", "850", "12/27", "RUR", 8940000
        );
        final Account acc2 = UtilFactories.createAccountWithCard(
                "3754567210826497", "113", "10/29", "RUR", 556300
        );

        this.accounts.add(acc1);
        this.accounts.add(acc2);

    }

    @Override
    public void addTransaction(Transaction transaction) {
        this.transactions.put(transaction.getID(), transaction);
    }

    @Override
    public Optional<Card> getCardByNumber(String cardNumber) {
        for (Account acc : this.accounts) {
            if (acc.cardContains(cardNumber)) {
                return acc.getCard(cardNumber);
            }
        }

        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Transaction> getTransactionByID(int id) {
        if (this.transactions.containsKey(id)) {
            return Optional.of(this.transactions.get(id));
        }
        return Optional.ofNullable(null);
    }

    @Override
    public boolean addAccount(Account newAccount) {
        if (newAccount != null) {
            this.accounts.add(newAccount);
            return true;
        }
        return false;
    }


}
