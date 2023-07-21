package com.gymguard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Template {
    private int id;
    private String name;
    private List<String> exerciseNameList;
    private List<Integer> setsList;
}
