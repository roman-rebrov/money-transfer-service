package com.bank.moneytransfer.logger;

import com.bank.moneytransfer.entity.Transaction;
import com.bank.moneytransfer.util.DateTime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Loggers {

    public static Logger getLogger() {

        return new Logger() {

            private File file;


            @Override
            public boolean write(String log) {
                if (file == null) {
                    return false;
                }
                try (
                        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
                ) {

                    final StringBuilder logBuilder = new StringBuilder("[ ");
                    logBuilder.append(DateTime.getDate() + " ");
                    logBuilder.append(DateTime.getTime() + " == ");
                    logBuilder.append(log);
                    logBuilder.append(" ]\r\n");

                    writer.append(logBuilder.toString());
                    return true;

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            public void setPath(String path) {
                this.file = new File(path);
            }

            @Override
            public void log(Transaction transaction) {
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

                this.write(builder.toString());

            }
        };
    }
}
