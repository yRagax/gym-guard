package com.gymguard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExerciseRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Exercise> getAll() {
        return jdbcTemplate.query("SELECT * FROM exercise", BeanPropertyRowMapper.newInstance(Exercise.class));
    }
}
