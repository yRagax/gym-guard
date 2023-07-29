package com.gymguard.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/templates")
    public List<Template> getAll() {return templateService.getAll();}

    @GetMapping("/templates/{id}")
    public Template getById(@PathVariable("id") int id) {
        return templateService.getById(id);
    }
}