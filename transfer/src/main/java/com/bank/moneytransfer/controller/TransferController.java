package com.bank.moneytransfer.controller;

import com.bank.moneytransfer.entitie.TransferRequest;
import com.bank.moneytransfer.entitie.TransferConfirmOperationRequest;
import com.bank.moneytransfer.entitie.TransferMessage;
import com.bank.moneytransfer.service.TransferService;
import com.bank.moneytransfer.service.TransferServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferServiceImpl service) {
        this.service = service;
    }

    @PostMapping("transfer")
    public ResponseEntity postTransfer(@RequestBody TransferRequest transfer) {

        return ResponseEntity.ok(service.postTransfer(transfer));
    }


    @PostMapping("confirmOperation")
    public ResponseEntity postConfirmOperation(@RequestBody TransferConfirmOperationRequest confirmOperation) {

        return ResponseEntity.ok(service.postConfirmOperation(confirmOperation));
    }

}
