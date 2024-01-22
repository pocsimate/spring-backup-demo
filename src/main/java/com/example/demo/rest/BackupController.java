package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/backup")
public class BackupController {

    @GetMapping("/create")
    public String createBackup() {
        try {
            String command = "docker exec -i mdb mariadb-dump --databases demo -uroot -pPassword123! > dbspring.sql";

            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                return "Backup created successfully!";
            } else {
                return "Error creating backup. Exit code: " + exitCode;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error creating backup: " + e.getMessage();
        }
    }
}
