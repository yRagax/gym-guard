package com.gymguard.Workout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class WorkoutRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Workout> getAll() {
        return jdbcTemplate.query("SELECT * FROM workout", BeanPropertyRowMapper.newInstance(Workout.class));
    }

    public Workout getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM workout WHERE id=? LIMIT 1", BeanPropertyRowMapper.newInstance(Workout.class), id);
    }

    public int save(Workout workout) {
        return jdbcTemplate.update("INSERT INTO workout(template_id, `date`, volume) VALUES(?, ?, ?)",
                workout.getTemplateId(), new Timestamp(new Date().getTime()), workout.getVolume());
    }
}
