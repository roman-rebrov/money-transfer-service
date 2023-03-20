package com.bank.moneytransfer.controllers;

import com.bank.moneytransfer.entities.TransferRequest;
import com.bank.moneytransfer.entities.TransferConfirmOperationRequest;
import com.bank.moneytransfer.entities.TransferMessage;
import com.bank.moneytransfer.services.TransferService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/")
public class TransferController {

    public TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping("transfer")
    public TransferMessage postTransfer(@RequestBody TransferRequest transfer){

        return this.service.postTransfer(transfer);
    }


    @PostMapping("confirmOperation")
    public TransferMessage postConfirmOperation(@RequestBody TransferConfirmOperationRequest confirmOperation){

        return this.service.postConfirmOperation(confirmOperation);
    }

}
