package com.bank.moneytransfer.repositories;

import com.bank.moneytransfer.entities.Account;
import com.bank.moneytransfer.entities.Card;
import com.bank.moneytransfer.entities.Transaction;
import com.bank.moneytransfer.utils.AccountFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TransferRepository {

    private final Map<Integer, Transaction> transactions = new HashMap<>();
    private final List<Account> accounts = new ArrayList<>();

    public TransferRepository(){

        final Account acc1 = AccountFactory.createAccountWithCard(
                "2585541741745566", "850", "12/27", "RUR", 8940000
        );
        final Account acc2 = AccountFactory.createAccountWithCard(
                "3754567210826497", "113", "10/29", "RUR", 556300
        );

        this.accounts.add(acc1);
        this.accounts.add(acc2);

    }

    public void addTransaction (Transaction transaction){
        this.transactions.put(transaction.getID(), transaction);
    }

    public Optional<Card> getCardByNumber (String cardNumber) {
        for (Account acc : this.accounts){
            if (acc.cardContains(cardNumber)){
                return acc.getCard(cardNumber);
            }
        }

        return Optional.of(null);
    }

    public Optional<Transaction> getTransactionByID (int id) {
        if (this.transactions.containsKey(id)){
            return Optional.of(this.transactions.get(id));
        }
        return Optional.of(null);
    }


}
