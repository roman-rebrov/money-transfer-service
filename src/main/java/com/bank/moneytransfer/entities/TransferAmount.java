package com.bank.moneytransfer.entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TransferAmount {
    @NotBlank
    @Min(3)
    private String currency;
    @NotBlank
    @Min(1)
    private int value;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TransferAmount{" +
                "currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}
