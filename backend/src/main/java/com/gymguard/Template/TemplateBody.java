package com.gymguard.Template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateBody {
    private int id;
    private int exerciseId;
    private int sets;
}
