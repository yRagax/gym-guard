package com.gymguard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TemplateRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Template> getAll() {
        return jdbcTemplate.query("SELECT * FROM template", new RowMapper<Template>() {
            @Override
            public Template mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Template template = new Template();
                template.setId(resultSet.getInt("id"));
                template.setName(resultSet.getString("name"));
                List<String> exerciseList = new ArrayList<>();
                List<Integer> setsList = new ArrayList<>();
                jdbcTemplate.query(String.format("SELECT * FROM template_%d", resultSet.getInt("id")),
                        new RowMapper<Integer>() {
                    @Override
                    public Integer mapRow(ResultSet resultSet1, int rowNum1) throws SQLException {
                        exerciseList.add(exerciseRepository.getById(resultSet1.getInt("exercise_id")).getName());
                        setsList.add(resultSet1.getInt("sets"));
                        return 0;
                    }
                });
                template.setExerciseNameList(exerciseList);
                template.setSetsList(setsList);
                return template;
            }
        });
    }
}
