package com.example.exams.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentsDto {
    private Long id;
    private String admNo;
    private String studentName;
    private  String studentClass;
    private String gender;
    private  String termName;
    private String termAdmitted;
    private String phone;
//    private String subjects;
//    private List<SubjectDto> subjects;
}
