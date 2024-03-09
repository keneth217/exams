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
public class Teachers  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tCode;
    private String tName;
    private String tphone;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="teacher_subjects",
            joinColumns =   @JoinColumn(name="teacher_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="subject_id",referencedColumnName = "id")
    )
    private Set<Subjects> subjects = new HashSet<>();

}
