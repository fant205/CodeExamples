package ru.learn.spring.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.learn.spring.jdbc.model.Personalization;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class JdbcService {

    private JdbcTemplate jdbcTemplate;

    public Personalization find(String appName) {
        String sql = "select * from Personalization where appName = '" + appName + "'";
        List<Personalization> list = jdbcTemplate.query(sql, new RowMapper<Personalization>() {
            @Override
            public Personalization mapRow(ResultSet rs, int rowNum) throws SQLException {
                Personalization p = new Personalization();
                p.setLogin(rs.getString("login"));
                p.setJson(rs.getString("json"));
                p.setAppName(rs.getString("appName"));
                p.setId(rs.getInt("id"));
                return p;
            }
        });
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
