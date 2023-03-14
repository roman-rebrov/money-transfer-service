package com.bank.moneytransfer.services;

import com.bank.moneytransfer.entities.Transaction;
import com.bank.moneytransfer.entities.Transfer;
import com.bank.moneytransfer.entities.TransferConfirmOperation;
import com.bank.moneytransfer.entities.TransferMessage;
import com.bank.moneytransfer.repositories.TransferRepository;
import com.bank.moneytransfer.utils.CurrencyOperations;
import org.springframework.stereotype.Service;



@Service
public class TransferService {

    private TransferRepository repository;
    private String accessCode = "0000";

    private Transaction createTransaction(Transfer transfer){
        return new Transaction(
                transfer.getCardFromNumber(),
                transfer.getCardToNumber(),
                transfer.getAmount().getCurrency(),
                transfer.getAmount().getValue(),
                CurrencyOperations.calculateCommission(transfer.getAmount().getValue())
        );
    }



    public TransferMessage postTransfer(Transfer transfer) {
        final Transaction newTransaction = this.createTransaction(transfer);



        return null;
    }

    public TransferMessage postConfirmOperation (TransferConfirmOperation confirmOperation){

        if (this.accessCode.equals(confirmOperation.getCode())){

        }else {

        }

        return null;
    }

}
