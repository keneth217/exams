package com.example.exams.dtos;


import com.example.exams.entity.Subjects;
import lombok.Data;

import java.util.Set;

@Data
public class ClassDto {

    private Long id;
    private String currentClass;
    private String nextClass;
    private int population;
//    private Set<Subjects> subjects;
}
