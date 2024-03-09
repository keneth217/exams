package com.example.exams.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Marks extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long markId;
    private String admNo;
    private String subjectCode;
    private String teacherCode;
    private String studentClass;
    private String totalMarks;
    private String actualScore;
    private String grade;
    private String termName;
//    @OneToOne
////    @JoinColumn(name = "student_adm",referencedColumnName = "adm_no")
//    @JoinColumn(name = "student_adm")
//    private Students studentAdm;
}
