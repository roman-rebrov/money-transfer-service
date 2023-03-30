package com.bank.moneytransfer.logger;

public interface Logger {
    public boolean write(String log);

    public void setPath(String dir);
}
