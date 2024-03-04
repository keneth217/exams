package com.example.exams.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Students extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "adm_no")
    private String admNo;
    private String studentName;
    private  String studentClass;
    private String gender;
    private  String termName;
    private String termAdmitted;
    private String phone;
@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="students_subjects",
            joinColumns = {
            @JoinColumn(name="student_adm",referencedColumnName="adm_no")
            },
            inverseJoinColumns = {
            @JoinColumn(name="subject_code",referencedColumnName="subject_code")
            }
    )
    private Set<Subjects> subjects;
}
