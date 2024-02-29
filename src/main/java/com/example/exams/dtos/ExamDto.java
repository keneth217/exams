package com.example.exams.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamDto {
    private Long id;
    private String examName;
    private String  termName;
    private int totalMarks;
}
