package com.example.exams.repository;

import com.example.exams.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teachers,Long> {
}
