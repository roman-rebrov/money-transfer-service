package com.bank.moneytransfer.service;

import com.bank.moneytransfer.entity.TransferConfirmOperationRequest;
import com.bank.moneytransfer.entity.TransferMessage;
import com.bank.moneytransfer.entity.TransferRequest;

public interface TransferService {
    TransferMessage postTransfer(TransferRequest transfer);
    TransferMessage postConfirmOperation(TransferConfirmOperationRequest confirmOperation);
    void setLoggerPath(String loggerPath);
}
