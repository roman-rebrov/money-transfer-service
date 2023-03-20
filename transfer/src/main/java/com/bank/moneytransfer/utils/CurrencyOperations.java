package com.bank.moneytransfer.utils;

public class CurrencyOperations {

    private static final int commissionPercentage = 1;

    public static int calculateCommission(int sum) {
        return (sum / 100) * commissionPercentage;
    }

    public static int getCommissionPercentage(){
        return commissionPercentage;
    }
}
