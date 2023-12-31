package com.gymguard.Workout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workout {
    private String name;
    private Timestamp date;
    private int volume;
}
