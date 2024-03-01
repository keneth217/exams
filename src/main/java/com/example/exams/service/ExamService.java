package com.example.exams.service;

import com.example.exams.dtos.ExamDto;
import com.example.exams.dtos.StudentsDto;
import com.example.exams.dtos.SubjectDto;

import java.time.LocalDateTime;

public interface ExamService {
   ExamDto addExam(ExamDto examDto, String createdBy, LocalDateTime createdAt);
}
