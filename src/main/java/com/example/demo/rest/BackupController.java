package com.example.demo.rest;

import com.example.demo.action.BackupAction;
import com.example.demo.dto.BackupDto;
import com.example.demo.dto.BackupListDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backup")
public class BackupController {

    private final BackupAction backupAction;

    public BackupController(BackupAction backupAction) {
        this.backupAction = backupAction;
    }

    @GetMapping("/create")
    public BackupDto createBackup() {
        return backupAction.createBackup();
    }

    @PostMapping("/load/{id}")
    public String loadBackup(@PathVariable Long id) {
        return backupAction.loadBackup(id);
    }

    @GetMapping
    public BackupListDto listBackups() {
        return backupAction.listBackups();
    }
}
