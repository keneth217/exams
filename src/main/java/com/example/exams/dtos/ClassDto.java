package com.example.exams.dtos;


import lombok.Data;

@Data
public class ClassDto {

    private Long id;
    private String currentClass;
    private String nextClass;
    private int population;
}
