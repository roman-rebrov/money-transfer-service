package com.bank.moneytransfer.loggers;

import com.bank.moneytransfer.utils.DateTime;

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
        };
    }
}
