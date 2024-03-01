package com.example.exams.dtos;


import lombok.*;

import java.util.Set;

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

    public SubjectDto(Long id, String subjectAlias, String subjectName, String subjectCategory, int subjectCode, int outOf, int totalScore) {
    }
//    private Set<Students> students;
}
