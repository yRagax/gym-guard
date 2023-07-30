package com.gymguard.Workout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutMapper workoutMapper;

    @GetMapping("/workouts")
    public List<Workout> getAll() {
        List<Workout> workoutList = new ArrayList<>();
        workoutRepository.getAll().forEach(workoutEntity -> workoutList.add(workoutMapper.map(workoutEntity)));
        return workoutList;
    }

    @GetMapping("/workouts/{id}")
    public Workout getById(@PathVariable("id") int id) {
        return workoutMapper.map(workoutRepository.getById(id));
    }

    @PostMapping("/workouts")
    public int save(@RequestBody WorkoutEntity workoutEntity) {
        return workoutRepository.save(workoutEntity);
    }
}
