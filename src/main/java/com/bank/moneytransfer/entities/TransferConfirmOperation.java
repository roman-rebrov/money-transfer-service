package com.bank.moneytransfer.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public class TransferConfirmOperation {

    @NotBlank
    private String operationId;

    @NotBlank
    @Max(4)
    private String code;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TransferConfirmOperation{" +
                "operationId='" + operationId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
