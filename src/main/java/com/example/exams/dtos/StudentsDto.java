package com.example.exams.dtos;

import com.example.exams.entity.Subjects;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsDto {
    private Long id;
    private String admNo;
    private String studentName;
    private  String studentClass;
    private String gender;
    private  String termName;
    private String termAdmitted;
    private String phone;
//    private Set<Subjects> subjects;
//    private Set<Subjects> subjects;

}
