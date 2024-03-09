package com.example.exams.dtos;

import com.example.exams.entity.Subjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private Long id;
    private String tCode;
    private String tName;
    private String tphone;
    private Set<Subjects> subjects;
}
