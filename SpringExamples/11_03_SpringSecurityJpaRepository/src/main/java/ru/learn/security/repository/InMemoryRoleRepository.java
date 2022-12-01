package ru.learn.security.repository;

import org.springframework.stereotype.Repository;
import ru.learn.security.model.Role;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryRoleRepository {
    private final Map<Long, Role> roles = new HashMap<>();

    public InMemoryRoleRepository() {
        roles.put(1L, createRole(1L, "ROLE_ADMIN"));
        roles.put(2L, createRole(2L, "ROLE_USER"));
    }

    private Role createRole(Long id, String name) {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        return role;
    }
}
