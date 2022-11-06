package ru.learn.spring.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.learn.spring.jdbc.model.Personalization;
import ru.learn.spring.jdbc.service.JdbcService;

/**
 * целевой адрес будет:
 *   https://host:port/02_RestAndJdbcTemplate/jdbc/find
 */
@RestController
@RequestMapping(value = "/jdbc")
public class JdbcController {

    private JdbcService jdbcService;

    @GetMapping("/find")
    public Personalization find(@RequestParam(value = "appName", defaultValue = "") String appName){
        return jdbcService.find(appName);
    }

    @Autowired
    public void setJdbcService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }
}
