package com.example.demo.repository;

import com.example.demo.model.ChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {
}
