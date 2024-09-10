package com.simplifia.Symplifia.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private boolean authenticated;
    private Object user;

    public LoginResponse(boolean authenticated, Object user) {
        this.authenticated = authenticated;
        this.user = user;
    }
}
