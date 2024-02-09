package com.example.demo.dto;

import java.util.List;

public class BackupListDto {

    public BackupListDto(List<BackupDto> backups) {
        this.backups = backups;
    }

    private List<BackupDto> backups;

    public List<BackupDto> getBackups() {
        return backups;
    }

    public void setBackups(List<BackupDto> backups) {
        this.backups = backups;
    }
}
