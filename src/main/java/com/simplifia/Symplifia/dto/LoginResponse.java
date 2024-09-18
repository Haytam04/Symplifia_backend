package com.simplifia.Symplifia.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private Integer id;
    private String role;

    public LoginResponse(Integer id, String role) {
        this.id = id;
        this.role = role;
    }
}
