package com.example.exams.repository;

import com.example.exams.entity.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exams,Long> {
}
