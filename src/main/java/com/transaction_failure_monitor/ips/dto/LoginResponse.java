package com.transaction_failure_monitor.ips.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String message = "Login successful";
    private String type = "Bearer";
    private String token;
    private String username;
    private String roles;
}


