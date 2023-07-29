package com.gymguard.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemplateRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TemplateHead> getAllHead() {
        return jdbcTemplate.query("SELECT * FROM template", BeanPropertyRowMapper.newInstance(TemplateHead.class));
    }

    public TemplateHead getByIdHead(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM template WHERE id=?", BeanPropertyRowMapper.newInstance(TemplateHead.class), id);
    }

    public List<TemplateBody> getBody(int id) {
        return jdbcTemplate.query("SELECT * FROM template_?", BeanPropertyRowMapper.newInstance(TemplateBody.class), id);
    }
}