package com.example.exams.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subjects  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject_code")
    private int subjectCode;
    private String subjectName;
    private String  subjectCategory;
    private String subjectAlias;
    private int totalScore;
    private int outOf;


@ManyToMany(mappedBy = "subjects",fetch = FetchType.LAZY)
    private Set<Students> student;


}
