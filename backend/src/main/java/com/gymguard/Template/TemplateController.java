package com.gymguard.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateController {

    @Autowired
    TemplateRepository templateRepository;

    @GetMapping("/templates")
    public List<Template> getAll() {return templateRepository.getAll();}
}
