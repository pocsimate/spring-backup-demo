package com.example.demo.repository;

import com.example.demo.model.Backup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackupRepository extends JpaRepository<Backup, Long> {

}
