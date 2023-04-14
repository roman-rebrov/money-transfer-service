package com.bank.moneytransfer.service;

import com.bank.moneytransfer.entity.*;
import com.bank.moneytransfer.exception.*;
import com.bank.moneytransfer.logger.Logger;
import com.bank.moneytransfer.logger.Loggers;
import com.bank.moneytransfer.repository.TransferRepository;
import com.bank.moneytransfer.repository.TransferRepositoryImpl;
import com.bank.moneytransfer.util.CurrencyOperations;
import com.bank.moneytransfer.util.UtilFactories;
import com.bank.moneytransfer.util.Validations;
import com.bank.moneytransfer.util.Verifications;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferRepository repository;
    private final Logger logger;
    private final String ACCESS_CODE = "0000";


    public TransferServiceImpl(TransferRepositoryImpl repository) {
        this.repository = repository;
        this.logger = Loggers.getLogger();
        this.logger.setPath(Loggers.LOGGER_PATH);
    }


    @Override
    public TransferMessage postTransfer(TransferRequest transfer) {

        // create Transaction
        final Transaction newTransaction = UtilFactories.createTransaction(transfer);
        repository.addTransaction(newTransaction);


        // Validation transfer object
        if (!Validations.transferRequestValid(transfer)) {
            this.logger.log(newTransaction);
            throw new InputDataException(newTransaction.getID(), "Incorrect enter data");
        }

        // Find cards
        final Optional<Card> cardFrom = repository.getCardByNumber(newTransaction.getCardFromNumber());
        final Optional<Card> cardTo = repository.getCardByNumber(newTransaction.getCardToNumber());

        // Check cards
        if (cardFrom.isEmpty()) {
            this.logger.log(newTransaction);
            throw new SenderCardException(newTransaction.getID(), "Sender card is not exist");
        }
        if (cardTo.isEmpty()){
            this.logger.log(newTransaction);
            throw new RecipientCardException(newTransaction.getID(), "Recipient card is not exist");
        }

        final Card from = cardFrom.get();
        final Card to = cardTo.get();

        // verify data
        final boolean verify = Verifications.cardVerify(transfer, from);

        if (!verify) {
            throw new CardDataException(newTransaction.getID(), "Invalid card data");
        }

        // Check amount of the card
        final int transferAmount = newTransaction.getAmount();
        if (!from.isAmount(transferAmount + newTransaction.getCommission())) {
            this.logger.log(newTransaction);
            throw new AmountException(newTransaction.getID(), "this amount is missing on the card");
        }

        // Money exchange
        final int withdrawMoney = from.withdrawMoney(transferAmount);
        from.withdrawMoney(CurrencyOperations.calculateCommission(withdrawMoney));
        to.putMoney(withdrawMoney);


        // confirm successful transaction
        newTransaction.successfulTransfer();

        // Logging
        this.logger.log(newTransaction);

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
        if (this.ACCESS_CODE.equals(confirmOperation.getCode())) {

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
    public void setLOGGER_PATH(String LOGGER_PATH) {
        this.logger.setPath(LOGGER_PATH);
    }

}
