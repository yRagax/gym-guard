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
    private JdbcTemplate jdbcTemplate;

    public List<WorkoutEntity> getAll() {
        return jdbcTemplate.query("SELECT * FROM workout", BeanPropertyRowMapper.newInstance(WorkoutEntity.class));
    }

    public WorkoutEntity getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM workout WHERE id=? LIMIT 1", BeanPropertyRowMapper.newInstance(WorkoutEntity.class), id);
    }

    public int save(WorkoutEntity workoutEntity) {
        return jdbcTemplate.update("INSERT INTO workout(template_id, `date`, volume) VALUES(?, ?, ?)",
                workoutEntity.getTemplateId(), new Timestamp(new Date().getTime()), workoutEntity.getVolume());
    }
}
