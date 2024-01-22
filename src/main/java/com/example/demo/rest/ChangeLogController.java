package com.example.demo.rest;

import com.example.demo.dto.ChangeLogDto;
import com.example.demo.dto.ChangeLogListDto;
import com.example.demo.model.ChangeLog;
import com.example.demo.repository.ChangeLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/changelog")
public class ChangeLogController {

    private final ChangeLogRepository changeLogRepository;

    public ChangeLogController(ChangeLogRepository changeLogRepository1) {
        this.changeLogRepository = changeLogRepository1;
    }

    @GetMapping
    public ResponseEntity<ChangeLogListDto> getChangeLogList() {
        List<ChangeLog> changeLogList = changeLogRepository.findAll();
        List<ChangeLogDto> changeLogDtoList = new ArrayList<>();

        for (ChangeLog changeLog : changeLogList) {
            changeLogDtoList.add(new ChangeLogDto(changeLog.getId(),
                    changeLog.getAdministratorUsername(),
                    changeLog.getCustomerId(),
                    changeLog.getAction(),
                    changeLog.getEndpoint(),
                    changeLog.getTimestamp()));
        }

        return new ResponseEntity<>(new ChangeLogListDto(changeLogDtoList), HttpStatus.OK);
    }
}
