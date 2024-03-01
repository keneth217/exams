package com.example.exams.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDto {
    private Long id;
    private String teacherCode;
    private String teacherName;
    private String tphone;
}
