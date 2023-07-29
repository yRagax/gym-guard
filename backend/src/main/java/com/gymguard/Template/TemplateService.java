package com.gymguard.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private TemplateMapper templateMapper;

    public List<Template> getAll() {
        List<Template> templateList = new ArrayList<>();
        templateRepository.getAllHead().forEach(head -> templateList.add(templateMapper.map(head)));
        return templateList;
    }

    public Template getById(int id) {
        return templateMapper.map(templateRepository.getByIdHead(id));
    }
}
