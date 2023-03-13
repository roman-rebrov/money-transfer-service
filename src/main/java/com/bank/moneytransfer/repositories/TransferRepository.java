package com.bank.moneytransfer.repositories;

import com.bank.moneytransfer.entities.Account;
import com.bank.moneytransfer.entities.Transaction;

import java.util.HashMap;
import java.util.Map;

public class TransferRepository {

    private final Map<Integer, Transaction> transactions = new HashMap<>();
    private final Map<String, Account> accounts = new HashMap<>();

    public TransferRepository(){

    }
}
