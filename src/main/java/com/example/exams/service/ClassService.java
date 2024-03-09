package com.example.exams.service;

import com.example.exams.dtos.ClassDto;

import java.time.LocalDateTime;

public interface ClassService {
    ClassDto addClass(ClassDto classDto, String createdBy, LocalDateTime createdAt);
}
