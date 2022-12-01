package ru.learn.security.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;
    private String login;
    private String password;
    private List<Role> roles;
}
