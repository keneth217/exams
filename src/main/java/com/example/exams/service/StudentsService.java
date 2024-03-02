package com.example.exams.service;

import com.example.exams.dtos.StudentsDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentsService {
    StudentsDto addStudent(StudentsDto studentsDto, String createdBy, LocalDateTime createdAt);

//    StudentsDto addStudent(StudentsDto studentsDto);
    StudentsDto getStudentByAdm(String admNo);

//    StudentsDto updateStudent(String admNo);

    StudentsDto updateStudent(
            String admNo,
            String name,
            String phone,
            String studentClass,
            String gender,
            String termname,
            String termadmitted,
            LocalDateTime updatedAt
//            String updatedBY="keneth",
//            LocalDateTime updatedAt = LocalDateTime.now();

    );

    StudentsDto deleteStudent(String admNo);
    List<StudentsDto> getAllStudents();

    List<StudentsDto> searchStudents(String query);
}
