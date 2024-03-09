package com.example.exams.repository;

import com.example.exams.entity.Marks;
import com.example.exams.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Long> {

    Optional<Marks> findByAdmNo(String AdmNo);
//    boolean existsByAdmNoAndSubjectCode(String student_adm, String SubjectCode);
//    Marks findByAdmNoAndSubjectCode(String student_adm, String subjectCode);
}
