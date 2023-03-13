package com.bank.moneytransfer.utils;

import com.bank.moneytransfer.entities.Account;
import com.bank.moneytransfer.entities.Card;

public class AccountFactory {

    public static Account createAccount() {
        final Account newAccount = new Account();
        return newAccount;
    }

    public static Account createAccountWithCard(
            String cardNumber,
            String cardCVV,
            String cardValidTill,
            String currency,
            int value
    ) {

        final Card newCard = new Card();
        newCard.setCardNumber(cardNumber);
        newCard.setCardCVV(cardCVV);
        newCard.setCardValidTill(cardValidTill);
        newCard.setCurrency(currency);

        final Account newAccount = new Account();
        newAccount.addNewCard(newCard);

        return newAccount;
    }
}
