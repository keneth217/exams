package com.example.exams.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {
    private Long markId;
    private String admNo;
    private String subjectCode;
    private String studentClass;
    private String totalMarks;
    private String actualScore;
    private String grade;
    private String termName;
    private String studentAdmNo;
    private String teacherCode;

}
