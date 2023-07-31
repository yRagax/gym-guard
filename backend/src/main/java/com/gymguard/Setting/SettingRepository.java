package com.gymguard.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SettingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Setting> getAll() {
        return jdbcTemplate.query("SELECT * FROM setting", BeanPropertyRowMapper.newInstance(Setting.class));
    }

    public Setting getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM setting WHERE id=? LIMIT 1", BeanPropertyRowMapper.newInstance(Setting.class), id);
    }
}
