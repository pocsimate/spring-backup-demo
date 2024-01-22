package com.example.demo.dto;

import java.util.List;

public class ChangeLogListDto {

    public ChangeLogListDto(List<ChangeLogDto> changeLogs) {
        this.changeLogs = changeLogs;
    }

    private List<ChangeLogDto> changeLogs;

    public List<ChangeLogDto> getChangeLogs() {
        return changeLogs;
    }

    public void setChangeLogs(List<ChangeLogDto> changeLogs) {
        this.changeLogs = changeLogs;
    }
}
