package com.example.exams.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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



//    @OneToMany(mappedBy = "subjects")
//    private Set<Classes> aClass = new HashSet<>();
//
//    @ManyToMany(mappedBy = "subjects")
//    private Set<Teachers> teachers = new HashSet<>();

@ManyToOne
@JoinColumn(name = "class_id")
private Classes aClass;
@JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private Set<Teachers> teachers = new HashSet<>();



}
