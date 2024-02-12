package com.example.demo.rest;

import com.example.demo.action.BackupAction;
import com.example.demo.dto.BackupDto;
import com.example.demo.dto.BackupListDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    /*
     TODO: when loading backup - the backup metadata should not be deleted, or maybe the table should not be touched
      meaning even exclude from dump
    */
}
