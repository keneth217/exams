package com.example.exams.service;

import com.example.exams.dtos.StudentsDto;
import com.example.exams.dtos.TeacherDto;

import java.time.LocalDateTime;

public interface TeacherService {
    TeacherDto addTeacher(TeacherDto teacherDto,String createdBy, LocalDateTime createdAt);
}
