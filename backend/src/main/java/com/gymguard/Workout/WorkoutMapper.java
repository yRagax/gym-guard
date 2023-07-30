package com.gymguard.Workout;

import com.gymguard.Template.TemplateHead;
import com.gymguard.Template.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkoutMapper {

    @Autowired
    private TemplateRepository templateRepository;

    public Workout map(WorkoutEntity workoutEntity) {
        Workout workout = new Workout();
        workout.setDate(workoutEntity.getDate());
        workout.setVolume(workoutEntity.getVolume());
        TemplateHead templateHead = templateRepository.getByIdHead(workoutEntity.getTemplateId());
        workout.setName(templateHead.getName());
        return workout;
    }
}
