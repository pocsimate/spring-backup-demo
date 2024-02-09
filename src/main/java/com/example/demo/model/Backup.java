package com.example.demo.model;

import com.example.demo.model.enums.BackupMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Backup {

    public Backup() {
    }

    public Backup(BackupMode backupMode, LocalDateTime createdAt, String createdBy, String fileName) {
        this(null, backupMode, createdAt, createdBy, fileName);
    }

    public Backup(Long id, BackupMode backupMode, LocalDateTime createdAt, String createdBy, String fileName) {
        this.id = id;
        this.backupMode = backupMode;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.fileName = fileName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
