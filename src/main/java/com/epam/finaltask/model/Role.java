package com.epam.finaltask.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public enum Role {
    ADMIN(
            List.of(
                    Permission.ADMIN_READ,
                    Permission.ADMIN_UPDATE,
                    Permission.ADMIN_CREATE,
                    Permission.ADMIN_DELETE
            )
    ),
    MANAGER(
            List.of(
                    Permission.MANAGER_UPDATE
            )
    ),
    USER(
            List.of(
                    Permission.USER_READ,
                    Permission.USER_UPDATE,
                    Permission.USER_CREATE,
                    Permission.USER_DELETE
            )
    );

    private List<Permission> permissions;

    private Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException();
    }
}
