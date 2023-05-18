package ru.learn.security.repository;

import org.springframework.stereotype.Repository;
import ru.learn.security.model.Role;
import ru.learn.security.model.User;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository {

    private final Map<Long, User> users = new HashMap<>();

    public InMemoryUserRepository() {
        users.put(1L, createUser(1L, "admin", "admin", List.of("ROLE_ADMIN")));
        users.put(2L, createUser(2L, "user", "user", List.of("ROLE_USER")));
    }

    private User createUser(Long id, String login, String password, List<String> roles) {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setRoles(roles.stream().map(it -> {
            Role role = new Role();
            role.setId(1L);
            role.setName(it);
            return role;
        }).collect(Collectors.toList()));
        return user;
    }

    public Optional<User> findByLogin(String login) {
        return users.values().stream()
                .filter(it -> Objects.equals(it.getLogin(), login))
                .findFirst();
    }

}
