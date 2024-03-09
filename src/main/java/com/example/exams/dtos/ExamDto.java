package com.example.exams.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {
    private Long id;
    private String examName;
    private String  termName;
    private int totalMarks;


}
