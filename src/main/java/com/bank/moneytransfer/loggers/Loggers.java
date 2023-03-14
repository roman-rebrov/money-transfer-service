package com.bank.moneytransfer.loggers;

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

                    writer.append(log);
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
        };
    }
}
