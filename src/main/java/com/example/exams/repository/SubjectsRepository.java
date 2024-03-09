package com.example.exams.repository;

import com.example.exams.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subjects,Long> {
}
