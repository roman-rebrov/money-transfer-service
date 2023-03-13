package com.bank.moneytransfer.services;

import com.bank.moneytransfer.entities.Transfer;
import com.bank.moneytransfer.entities.TransferConfirmOperation;
import com.bank.moneytransfer.entities.TransferMessage;
import com.bank.moneytransfer.repositories.TransferRepository;
import org.springframework.stereotype.Service;



@Service
public class TransferService {

    private TransferRepository repository;
    private String accessCode = "0000";

    public TransferMessage postTransfer(Transfer transfer) {



        return null;
    }

    public TransferMessage postConfirmOperation (TransferConfirmOperation confirmOperation){

        if (this.accessCode.equals(confirmOperation.getCode())){

        }else {

        }

        return null;
    }
}
