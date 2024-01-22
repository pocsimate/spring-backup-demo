package com.example.demo.dto;

import java.time.LocalDateTime;

public  class ChangeLogDto {

    public ChangeLogDto(Long id, String administratorUsername, Long customerId, String action, String endpoint, LocalDateTime timestamp) {
        this.id = id;
        this.administratorUsername = administratorUsername;
        this.customerId = customerId;
        this.action = action;
        this.endpoint = endpoint;
        this.timestamp = timestamp;
    }

    private Long id;
    private String administratorUsername;
    private Long customerId;
    private String action;
    private String endpoint;
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdministratorUsername() {
        return administratorUsername;
    }

    public void setAdministratorUsername(String administratorUsername) {
        this.administratorUsername = administratorUsername;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
