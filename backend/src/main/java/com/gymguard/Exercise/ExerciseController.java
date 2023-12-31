package com.gymguard.Exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    @GetMapping("/exercises")
    public List<Exercise> getAll() {
        return exerciseRepository.getAll();
    }

    @GetMapping("/exercises/{filter}")
    public List<Exercise> getByFilter(@PathVariable("filter") String filter) {
        return exerciseRepository.getByFilter(filter);
    }
}
