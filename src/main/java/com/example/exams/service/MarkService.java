package com.example.exams.service;

import com.example.exams.dtos.MarkDto;
import com.example.exams.dtos.StudentsDto;
import com.example.exams.repository.MarksRepository;

import java.time.LocalDateTime;

public interface MarkService {
    MarkDto  enterMarks(MarkDto markDto ,String grade, String createdBy, LocalDateTime createdAt);

    MarkDto updateMark(String studentAdmNo, String subjectCode, String studentClass, String teacherCode, String termName, MarkDto updateMark);



}
