package com.bank.moneytransfer.util;

import com.bank.moneytransfer.entity.Card;
import com.bank.moneytransfer.entity.TransferRequest;

public class Verifications {

    public static boolean cardVerify(TransferRequest transfer, Card card) {

        if (transfer == null || card == null) {
            return false;
        }

        final String cardNumber = transfer.getCardFromNumber();

        if (!card.getCardNumber().equals(cardNumber)) {
            return false;
        }

        final String validTill = transfer.getCardFromValidTill();

        if (!card.getCardValidTill().equals(validTill)) {
            return false;
        }

        final String cvv = transfer.getCardFromCVV();

        if (!card.getCardCVV().equals(cvv)) {
            return false;
        }

        return true;
    }
}
