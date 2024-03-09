package com.example.exams.dtos;


import com.example.exams.entity.Classes;
import com.example.exams.entity.Students;
import com.example.exams.entity.Teachers;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
    private Long id;
    @Column(name = "subject_code")
    private int subjectCode;
    private String subjectName;
    private String  subjectCategory;
    private String subjectAlias;
//    private int totalScore;
//    private int outOf;
//    private Set<Teachers> teachers;
    private Set<Classes> classes;
}
