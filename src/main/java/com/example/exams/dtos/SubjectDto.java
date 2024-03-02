package com.example.exams.dtos;


import com.example.exams.entity.Students;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
    private Long id;
    private int subjectCode;
    private String subjectName;
    private String  subjectCategory;
    private String subjectAlias;
    private int totalScore;
    private int outOf;
    private Set<Students> student;

//    private Set<Students> students;
}
