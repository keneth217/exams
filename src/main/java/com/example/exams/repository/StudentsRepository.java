package com.example.exams.repository;

import com.example.exams.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {
    Optional<Students> findByAdmNo(String admNo);
    Optional<Students> deleteByAdmNo(String admNo);
}
