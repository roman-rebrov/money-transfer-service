package com.bank.moneytransfer.repositories;

import com.bank.moneytransfer.entities.Account;
import com.bank.moneytransfer.entities.Transaction;
import com.bank.moneytransfer.utils.AccountFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


}
