package com.example.demo.dto;

import com.example.demo.model.enums.BackupMode;

import java.time.LocalDateTime;

public class BackupDto {

    public BackupDto() {
    }

    public BackupDto(Long id, BackupMode backupMode, LocalDateTime createdAt, String createdBy, String fileName) {
        this.id = id;
        this.backupMode = backupMode;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.fileName = fileName;
    }

    private Long id;
    private BackupMode backupMode;
    private LocalDateTime createdAt;
    private String createdBy;
    private String fileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BackupMode getBackupMode() {
        return backupMode;
    }

    public void setBackupMode(BackupMode backupMode) {
        this.backupMode = backupMode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
