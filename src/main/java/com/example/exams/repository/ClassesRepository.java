package com.example.exams.repository;

import com.example.exams.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClassesRepository extends JpaRepository<Classes,Long> {
    Optional<Classes> findById(Long classId);
}
