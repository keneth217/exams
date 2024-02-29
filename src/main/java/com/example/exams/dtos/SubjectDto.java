package com.example.exams.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectDto {
    private Long id;
    private int subjectCode;
    private String subjectName;
    private String  subjectCategory;
    private String subjectAlias;
    private int totalScore;
    private int outOf;
}
