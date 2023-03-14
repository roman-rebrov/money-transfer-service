package com.bank.moneytransfer.loggers;

public interface Logger {
    public boolean write(String log);
    public void setPath(String dir);
}
