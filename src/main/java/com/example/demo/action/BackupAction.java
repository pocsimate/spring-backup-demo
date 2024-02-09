package com.example.demo.action;

import com.example.demo.dto.BackupDto;
import com.example.demo.dto.BackupListDto;
import com.example.demo.exception.BackupException;
import com.example.demo.model.Backup;
import com.example.demo.model.enums.BackupMode;
import com.example.demo.process.BackupProcessHandler;
import com.example.demo.repository.BackupRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BackupAction {

    public static final String BACKUP_SH = "/usr/local/bin/backup.sh";
    public static final String RESTORE_SH = "/usr/local/bin/restore.sh";

    private final BackupRepository backupRepository;

    public BackupAction(BackupRepository backupRepository) {
        this.backupRepository = backupRepository;
    }

    public BackupDto createBackup() {
        LocalDateTime sysDate = LocalDateTime.now();

        boolean isProcessStatusOk = BackupProcessHandler.runBackupProcess(BACKUP_SH, sysDate.toString());
        if (isProcessStatusOk) {

            Backup backup = new Backup(BackupMode.MANUAL, sysDate, "ADMIN", "dump_".concat(sysDate.toString().concat(".sql")));
            Backup savedBackup = backupRepository.save(backup);

            return new BackupDto(savedBackup.getId(), savedBackup.getBackupMode(), savedBackup.getCreatedAt(),
                    savedBackup.getCreatedBy(), savedBackup.getFileName());
        } else {
            throw new BackupException("Backup could not be created, see logs for details"); // TODO: view + save logs
        }
    }

    public String loadBackup(Long id) {
        Backup backup = retrieveBackupById(id);
        boolean isProcessStatusOk = BackupProcessHandler.runBackupProcess(RESTORE_SH, backup.getFileName());

        if (isProcessStatusOk) {
            return "Backup loaded successfully";
        } else {
            throw new BackupException("Backup could not be loaded, see logs for details");
        }
    }

    public BackupListDto listBackups() {
        List<Backup> backups = backupRepository.findAll();

        List<BackupDto> backupDtoList = new ArrayList<>();

        for (Backup backup : backups) {
            backupDtoList.add(new BackupDto(backup.getId(), backup.getBackupMode(), backup.getCreatedAt(),
                    backup.getCreatedBy(), backup.getFileName()));
        }

        return new BackupListDto(backupDtoList);
    }

    private Backup retrieveBackupById(Long id) {
        return backupRepository.findById(id)
                .orElseThrow(() -> new BackupException("Backup does not exist"));
    }
}
