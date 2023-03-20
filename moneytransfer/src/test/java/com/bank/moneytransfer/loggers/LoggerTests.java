package com.bank.moneytransfer.loggers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

public class LoggerTests {

    private final File file = new File("test.txt");


    @AfterEach
    public void deleteFile(){
        if (this.file.isFile()){
            this.file.delete();
        }
    }


    @Test
    @DisplayName("logger writing test")
    public void loggerWriting(){

        final Logger logger = Loggers.getLogger();
        logger.setPath(this.file.getPath());

        final boolean result = logger.write("test");

        Assertions.assertTrue(result);
        Assertions.assertTrue(this.file.isFile());

    }
}
