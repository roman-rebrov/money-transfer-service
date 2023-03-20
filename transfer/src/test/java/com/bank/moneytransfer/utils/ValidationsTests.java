package com.bank.moneytransfer.utils;

import com.bank.moneytransfer.entities.TransferAmount;
import com.bank.moneytransfer.entities.TransferConfirmOperationRequest;
import com.bank.moneytransfer.entities.TransferRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ValidationsTests {


    public TransferConfirmOperationRequest createConfirmOperationRequest(){

        final TransferConfirmOperationRequest confirmOperationRequest = Mockito.mock(TransferConfirmOperationRequest.class);

        Mockito.when(confirmOperationRequest.getOperationId()).thenReturn("1");
        Mockito.when(confirmOperationRequest.getCode()).thenReturn("0000");


        return confirmOperationRequest;

    }

    public TransferRequest createTransferRequest(){
        final TransferRequest request = Mockito.mock(TransferRequest.class);
        final TransferAmount amount = Mockito.mock(TransferAmount.class);

        Mockito.when(amount.getValue()).thenReturn(1);
        Mockito.when(amount.getCurrency()).thenReturn("RUS");


        Mockito.when(request.getCardFromNumber()).thenReturn("1234567890123456");
        Mockito.when(request.getCardFromValidTill()).thenReturn("01/33");
        Mockito.when(request.getCardFromCVV()).thenReturn("123");
        Mockito.when(request.getAmount()).thenReturn(amount);
        Mockito.when(request.getCardToNumber()).thenReturn("1234567890123456");


        return request;
    }

    @Test
    @DisplayName("transferRequestValidTest")
    public void transferRequestValidTest(){
        final TransferRequest request = this.createTransferRequest();

        final boolean result = Validations.transferRequestValid(request);
        Assertions.assertTrue(result);

    }

    @Test
    @DisplayName("NoValidCardToNumberTest")
    public void NoValidCardToNumberTest(){

        final TransferRequest request = this.createTransferRequest();

        Mockito.when(request.getCardToNumber()).thenReturn("123456789012345678");

        final boolean result = Validations.transferRequestValid(request);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("NoValidCardFromNumberTest")
    public void NoValidCardFromNumberTest(){

        final TransferRequest request = this.createTransferRequest();

        Mockito.when(request.getCardFromNumber()).thenReturn("123456789012345678");

        final boolean result = Validations.transferRequestValid(request);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("NoValidCardFromCVVTest")
    public void NoValidCardFromCVVTest(){

        final TransferRequest request = this.createTransferRequest();

        Mockito.when(request.getCardFromCVV()).thenReturn("1234");

        final boolean result = Validations.transferRequestValid(request);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("NoValidCardFromValidTillTest")
    public void NoValidCardFromValidTillTest(){

        final TransferRequest request = this.createTransferRequest();

        Mockito.when(request.getCardFromValidTill()).thenReturn("24/325");

        final boolean result = Validations.transferRequestValid(request);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("NoValidRequestAmountTest")
    public void NoValidRequestAmountTest(){

        final TransferRequest request = this.createTransferRequest();

        final TransferAmount amount = Mockito.mock(TransferAmount.class);

        Mockito.when(amount.getValue()).thenReturn(0);
        Mockito.when(request.getAmount()).thenReturn(amount);


        final boolean result = Validations.transferRequestValid(request);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("confirmRequestValidationTest")
    public void confirmRequestValidationTest(){

        final TransferConfirmOperationRequest request = this.createConfirmOperationRequest();


        final boolean result = Validations.transferConfirmRequestValid(request);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("noValidCodeConfirmRequestTest")
    public void noValidCodeConfirmRequestTest(){

        final TransferConfirmOperationRequest request = this.createConfirmOperationRequest();

        Mockito.when(request.getCode()).thenReturn("000");

        final boolean result = Validations.transferConfirmRequestValid(request);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("noValidIDConfirmRequestTest")
    public void noValidIDConfirmRequestTest(){

        final TransferConfirmOperationRequest request = this.createConfirmOperationRequest();

        Mockito.when(request.getOperationId()).thenReturn(null);

        final boolean result = Validations.transferConfirmRequestValid(request);
        Assertions.assertFalse(result);
    }
}
