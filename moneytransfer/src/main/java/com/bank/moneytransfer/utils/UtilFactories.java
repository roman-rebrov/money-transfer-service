package com.bank.moneytransfer.utils;

import com.bank.moneytransfer.entities.Account;
import com.bank.moneytransfer.entities.Card;
import com.bank.moneytransfer.entities.Transaction;
import com.bank.moneytransfer.entities.TransferRequest;

public class UtilFactories {

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
        newCard.setValue(value);

        final Account newAccount = new Account();
        newAccount.addNewCard(newCard);

        return newAccount;
    }

    public static Transaction createTransaction(TransferRequest transfer) {
        return new Transaction(
                transfer.getCardFromNumber(),
                transfer.getCardToNumber(),
                transfer.getAmount().getCurrency(),
                transfer.getAmount().getValue(),
                CurrencyOperations.calculateCommission(transfer.getAmount().getValue())
        );
    }
}
