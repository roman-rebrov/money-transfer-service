package com.bank.moneytransfer.service;

import com.bank.moneytransfer.entitie.*;
import com.bank.moneytransfer.exception.InputDataException;
import com.bank.moneytransfer.exception.TransactionConfirmOperationException;
import com.bank.moneytransfer.exception.TransactionException;
import com.bank.moneytransfer.logger.Logger;
import com.bank.moneytransfer.logger.Loggers;
import com.bank.moneytransfer.repository.TransferRepository;
import com.bank.moneytransfer.repository.TransferRepositoryImpl;
import com.bank.moneytransfer.utils.CurrencyOperations;
import com.bank.moneytransfer.utils.UtilFactories;
import com.bank.moneytransfer.utils.Validations;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService{

    private final TransferRepository repository;

    private final Logger logger;

    private String loggerPath = "transactionLoggers.txt";

    private final String accessCode = "0000";


    public TransferServiceImpl(TransferRepositoryImpl repository) {
        this.repository = repository;
        this.logger = Loggers.getLogger();
        this.logger.setPath(this.loggerPath);
    }


    private boolean verifyCardData(TransferRequest transfer, Card card) {

        if (transfer == null || card == null) {
            return false;
        }

        final String cardNumber = transfer.getCardFromNumber();

        if (!card.getCardNumber().equals(cardNumber)) {
            return false;
        }

        final String validTill = transfer.getCardFromValidTill();

        if (!card.getCardValidTill().equals(validTill)) {
            return false;
        }

        final String cvv = transfer.getCardFromCVV();

        if (!card.getCardCVV().equals(cvv)) {
            return false;
        }

        return true;
    }


    private void createLogging(Transaction transaction) {

        final StringBuilder builder = new StringBuilder();
        builder.append("card From: " + transaction.getCardFromNumber() + ", ");
        builder.append("card To: " + transaction.getCardToNumber() + ", ");
        builder.append("amount: " + transaction.getAmount() + ", ");
        builder.append("commission: " + transaction.getCommission() + ", ");

        if (transaction.isTransfer()) {
            builder.append("operation: successful transaction");
        } else {
            builder.append("operation: failed transaction");
        }

        this.logger.write(builder.toString());

    }

    @Override
    public TransferMessage postTransfer(TransferRequest transfer) {

        // create Transaction
        final Transaction newTransaction = UtilFactories.createTransaction(transfer);
        repository.addTransaction(newTransaction);


        // Validation transfer object
        if (!Validations.transferRequestValid(transfer)) {
            this.createLogging(newTransaction);
            throw new InputDataException(newTransaction.getID(), "Incorrect enter data");
        }

        // Find cards
        final Optional<Card> cardFrom = repository.getCardByNumber(newTransaction.getCardFromNumber());
        final Optional<Card> cardTo = repository.getCardByNumber(newTransaction.getCardToNumber());

        // Check cards
        if (cardFrom.isEmpty() || cardTo.isEmpty()) {
            this.createLogging(newTransaction);
            throw new TransactionException(newTransaction.getID(), "Any cord is not exist");
        }

        final Card from = cardFrom.get();
        final Card to = cardTo.get();

        // verify data
        final boolean verify = this.verifyCardData(transfer, from);

        if (!verify) {
            throw new TransactionException(newTransaction.getID(), "Incorrect card data");
        }

        // Check amount of the card
        final int transferAmount = newTransaction.getAmount();
        if (!from.isAmount(transferAmount + newTransaction.getCommission())) {
            this.createLogging(newTransaction);
            throw new TransactionException(newTransaction.getID(), "this amount is missing on the card");
        }

        // Money exchange
        final int withdrawMoney = from.withdrawMoney(transferAmount);
        from.withdrawMoney(CurrencyOperations.calculateCommission(withdrawMoney));
        to.putMoney(withdrawMoney);


        // confirm successful transaction
        newTransaction.successfulTransfer();

        // Logging
        this.createLogging(newTransaction);

        // create response message
        final TransferMessage transferMessage = new TransferMessage();
        transferMessage.setOperationId(String.valueOf(newTransaction.getID()));

        return transferMessage;
    }


    @Override
    public TransferMessage postConfirmOperation(TransferConfirmOperationRequest confirmOperation) {

        // Request data validation
        if (!Validations.transferConfirmRequestValid(confirmOperation)) {
            throw new InputDataException(0, "Incorrect enter data");
        }

        // Check access code
        if (this.accessCode.equals(confirmOperation.getCode())) {

            try {
                final int operationID = Integer.parseInt(confirmOperation.getOperationId());

                // Find and checking transaction object
                final Optional<Transaction> result = repository.getTransactionByID(operationID);
                if (result.isEmpty()) {
                    throw new TransactionConfirmOperationException(0, "This transaction is not exist");
                }
                final Transaction transaction = result.get();

                // Transaction verification
                if (transaction.isTransfer()) {
                    final TransferMessage message = new TransferMessage();
                    message.setOperationId(String.valueOf(transaction.getID()));
                    return message;
                } else {
                    throw new TransactionConfirmOperationException(transaction.getID(), "Failed transaction");
                }

            } catch (NumberFormatException exception) {
                throw new InputDataException(0, "Incorrect enter data");
            }
        } else {
            throw new TransactionConfirmOperationException(0, "Incorrect access code");
        }

    }

    @Override
    public void setLoggerPath(String loggerPath) {
        this.logger.setPath(loggerPath);
    }

}
