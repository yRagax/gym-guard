package com.gymguard.Exercise;

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

    public List<Exercise> getByFilter(String filter) {
        return jdbcTemplate.query("SELECT * FROM exercise WHERE name LIKE CONCAT('%', ?, '%')", BeanPropertyRowMapper.newInstance(Exercise.class), filter);

    }

    public Exercise getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM exercise WHERE id=? LIMIT 1", BeanPropertyRowMapper.newInstance(Exercise.class), id);
    }
}
