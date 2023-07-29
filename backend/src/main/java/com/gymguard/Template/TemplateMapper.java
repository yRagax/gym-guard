package com.gymguard.Template;

import com.gymguard.Exercise.Exercise;
import com.gymguard.Exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemplateMapper {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Template map(TemplateHead head) {
        List<TemplateBody> templateBodyList = templateRepository.getBody(head.getId());
        Template template = new Template();
        template.setId(head.getId());
        template.setName(head.getName());
        List<String> exerciseNameList = new ArrayList<>();
        List<Integer> setsList = new ArrayList<>();
        templateBodyList.forEach(body -> {
            Exercise exercise = exerciseRepository.getById(body.getExerciseId());
            exerciseNameList.add(exercise.getName());
            setsList.add(body.getSets());
        });
        template.setExerciseNameList(exerciseNameList);
        template.setSetsList(setsList);
        return template;
    }
}
