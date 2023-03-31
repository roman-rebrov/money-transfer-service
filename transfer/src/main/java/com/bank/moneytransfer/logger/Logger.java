package com.bank.moneytransfer.logger;

import com.bank.moneytransfer.entity.Transaction;

public interface Logger {
    public boolean write(String log);
    public void setPath(String dir);
    public void log(Transaction transaction);
}
