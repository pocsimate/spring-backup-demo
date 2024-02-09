package com.example.demo.process;

import java.io.IOException;

public class BackupProcessHandler {

    public static boolean runBackupProcess(String command, String argument) {
        boolean isSuccessfulProcess = false;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command, argument);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                isSuccessfulProcess = true;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return isSuccessfulProcess;
    }
}
