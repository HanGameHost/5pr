package com.example.demo.Model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, SOTRUDNIK;

    @Override
    public String getAuthority() {
        return name();
    }
}
