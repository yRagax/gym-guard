package com.gymguard.Workout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutController {

    @Autowired
    WorkoutRepository workoutRepository;

    @GetMapping("/workouts")
    public List<Workout> getAll() {
        return workoutRepository.getAll();
    }

    @GetMapping("/workouts/{id}")
    public Workout getById(@PathVariable("id") int id) {
        return workoutRepository.getById(id);
    }

    @PostMapping("/workouts")
    public int save(@RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }
}
