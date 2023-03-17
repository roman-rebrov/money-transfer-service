package com.bank.moneytransfer.utils;

import com.bank.moneytransfer.entities.TransferRequest;
import com.bank.moneytransfer.entities.TransferConfirmOperationRequest;

public class Validations {

    public static boolean transferRequestValid(TransferRequest transfer) {

        if (transfer == null) {
            return false;
        }
        if ( transfer.getCardFromNumber() == null || !(transfer.getCardFromNumber().length() == 16)){
            return false;
        }
        if ( transfer.getCardToNumber() == null || !(transfer.getCardToNumber().length() == 16)){
            return false;
        }
        if (transfer.getCardFromCVV() == null || !(transfer.getCardFromCVV().length() == 3)){
            return false;
        }
        if (transfer.getCardFromValidTill() == null || !(transfer.getCardFromValidTill().length() == 5)){
            return false;
        }
        if (transfer.getAmount() == null) {
            return false;
        }
        if (transfer.getAmount().getCurrency() == null || !(transfer.getAmount().getCurrency().length() == 3)){
            return false;
        }
        if (transfer.getAmount().getValue() < 1){
            return false;
        }
        return true;
    }

    public static boolean transferConfirmRequestValid(TransferConfirmOperationRequest confirmOperation) {

        if (confirmOperation == null) {
            return false;
        }
        if (confirmOperation.getCode() == null || !(confirmOperation.getCode().length() == 4)) {
            return false;
        }
        if (confirmOperation.getOperationId() == null) {
            return false;
        }

        return true;
    }
}
