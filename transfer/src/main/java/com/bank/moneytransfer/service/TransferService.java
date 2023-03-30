package com.bank.moneytransfer.service;

import com.bank.moneytransfer.entitie.TransferConfirmOperationRequest;
import com.bank.moneytransfer.entitie.TransferMessage;
import com.bank.moneytransfer.entitie.TransferRequest;

public interface TransferService {
    TransferMessage postTransfer(TransferRequest transfer);
    TransferMessage postConfirmOperation(TransferConfirmOperationRequest confirmOperation);
    void setLoggerPath(String loggerPath);
}
