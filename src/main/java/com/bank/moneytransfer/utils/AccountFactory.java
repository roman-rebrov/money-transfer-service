package com.bank.moneytransfer.utils;

import com.bank.moneytransfer.entities.Account;

public class AccountFactory {

    public static Account createAccount(){
        final Account newAccount = new Account();

        return newAccount;
    }
}
