package com.bank.moneytransfer.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurrencyOperationsTests {

    @Test
    @DisplayName("calculateCommission test")
    public void calculateCommissionTest() {

        final int sum = 100;
        final int expectResult = (sum / 100) * CurrencyOperations.getCommissionPercentage();
        final int result = CurrencyOperations.calculateCommission(sum);

        Assertions.assertEquals(expectResult, result);
    }
}
