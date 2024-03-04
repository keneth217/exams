package com.example.exams.repository;

import com.example.exams.entity.Marks;
import com.example.exams.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Long> {
    Optional<Marks> findByAdmNo(String admNo);
    boolean existsByAdmNoAndSubjectCode(String admNo, String SubjectCode);
    Marks findByAdmNoAndSubjectCode(String admNo, String subjectCode);
}
