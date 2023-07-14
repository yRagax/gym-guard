package com.gymguard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    private int id;
    private String name;
    private String muscleGroup;
    private String type;
}
