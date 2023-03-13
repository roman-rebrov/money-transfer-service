package com.bank.moneytransfer.controllers;

import com.bank.moneytransfer.entities.Transfer;
import com.bank.moneytransfer.entities.TransferConfirmOperation;
import com.bank.moneytransfer.entities.TransferMessage;
import com.bank.moneytransfer.services.TransferService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/")
public class TransferController {

    private TransferService service;


    @PostMapping("transfer")
    public TransferMessage postTransfer(@Valid @RequestBody Transfer transfer){
//        TransferMessage message = new TransferMessage();
//        message.setOperationId("123456");
        return this.service.postTransfer(transfer);
    }

    @PostMapping("confirmOperation")
    public TransferMessage postConfirmOperation(@Valid @RequestBody TransferConfirmOperation confirmOperation){

//        System.out.println(confirmOperation.toString());
//        TransferMessage message = new TransferMessage();
//        message.setOperationId("12345");
        return this.service.postConfirmOperation(confirmOperation);
    }

}
