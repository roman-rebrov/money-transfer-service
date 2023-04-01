package com.bank.moneytransfer.service;

import com.bank.moneytransfer.entity.*;
import com.bank.moneytransfer.repository.TransferRepositoryImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.File;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

public class TransferServiceTests {

    private TransferServiceImpl service;
    private Card card;
    private Card recipientCard;
    private TransferRequest transfer;
    private int sum = 100;
    private File loggerFile = new File("testService.txt");

    public TransferServiceTests() {
        this.card = Mockito.mock(Card.class);
        this.recipientCard = Mockito.mock(Card.class);
        this.transfer = Mockito.mock(TransferRequest.class);
        final TransferAmount amount = Mockito.mock(TransferAmount.class);

        Mockito.when(amount.getCurrency()).thenReturn("RUS");
        Mockito.when(amount.getValue()).thenReturn(this.sum);


        final String cardFromNumber = "1234567890123456";
        final String cardToNumber = "6543210987654321";


        Mockito.when(this.recipientCard.getCardNumber()).thenReturn(cardToNumber);
        Mockito.when(this.recipientCard.putMoney(this.sum)).thenReturn(this.sum);

        Mockito.when(this.card.getCardNumber()).thenReturn(cardFromNumber);
        Mockito.when(this.card.getCardCVV()).thenReturn("123");
        Mockito.when(this.card.getCardValidTill()).thenReturn("12/29");
        Mockito.when(this.card.getCurrency()).thenReturn("RUS");
        Mockito.when(this.card.getValue()).thenReturn(100);

        Mockito.when(this.card.isAmount(any(Integer.class))).thenReturn(true);
        Mockito.when(this.card.withdrawMoney(this.sum)).thenReturn(this.sum);

        Mockito.when(this.transfer.getCardFromNumber()).thenReturn(cardFromNumber);
        Mockito.when(this.transfer.getCardToNumber()).thenReturn(cardToNumber);
        Mockito.when(this.transfer.getAmount()).thenReturn(amount);
        Mockito.when(this.transfer.getCardFromValidTill()).thenReturn("12/29");
        Mockito.when(this.transfer.getCardFromCVV()).thenReturn("123");
    }


    @BeforeEach
    public void createService() {

        final TransferRepositoryImpl repository = Mockito.mock(TransferRepositoryImpl.class);
        this.service = new TransferServiceImpl(repository);
        this.service.setLOGGER_PATH(this.loggerFile.getPath());

        final Transaction newTransaction = Mockito.mock(Transaction.class);
        Mockito.when(newTransaction.getID()).thenReturn(1);
        Mockito.when(newTransaction.isTransfer()).thenReturn(true);

        Mockito.when(repository.getCardByNumber(this.transfer.getCardFromNumber())).thenReturn(Optional.ofNullable(this.card));
        Mockito.when(repository.getCardByNumber(this.transfer.getCardToNumber())).thenReturn(Optional.ofNullable(this.recipientCard));

        Mockito.when(repository.getTransactionByID(any(Integer.class))).thenReturn(Optional.ofNullable(newTransaction));

    }

    @AfterEach
    public void afterTest() {
        if (this.loggerFile.isFile()) {
            this.loggerFile.delete();
        }
    }

    @Test
    @DisplayName("postTransferTest")
    public void postTransferTest() {

        final TransferMessage transferMessageResult = this.service.postTransfer(this.transfer);

        Assertions.assertNotNull(transferMessageResult);
        Assertions.assertNotNull(transferMessageResult.getOperationId());
        Assertions.assertEquals(true, transferMessageResult.getOperationId().length() > 0);

    }

    @Test
    @DisplayName("postConfirmOperationTest")
    public void postConfirmOperationTest() {
        final TransferConfirmOperationRequest confirmOperation = Mockito.mock(TransferConfirmOperationRequest.class);

        Mockito.when(confirmOperation.getCode()).thenReturn("0000");
        Mockito.when(confirmOperation.getOperationId()).thenReturn("1");

        final TransferMessage result = this.service.postConfirmOperation(confirmOperation);

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getOperationId());
        Assertions.assertEquals("1", result.getOperationId());
    }
}
