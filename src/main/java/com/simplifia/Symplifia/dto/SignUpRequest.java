package com.simplifia.Symplifia.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String fullName;
    private String phoneNumber;
    private String password;
    private String role;
    private String bankName;
    private String bankAccount;
    private Long selectedBuilding;
}
