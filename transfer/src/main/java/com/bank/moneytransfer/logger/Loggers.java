package com.bank.moneytransfer.logger;


public class Loggers {

    public static final String LOGGER_PATH = "transactionLoggers.txt";
    public static final String TEST_PATH = "test.txt";

    public static Logger getLogger() {
        return new LoggerImpl();
    }
}
