package com.yusk.bookstore.model;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("admin"),
    MANAGER("manager"),
    CLIENT("client");

    private String role;

    Role(String role) {
        this.role = role.toLowerCase();
    }
}
