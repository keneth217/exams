package com.example.exams.service;

import com.example.exams.dtos.ClassDto;
import com.example.exams.dtos.SubjectDto;

import java.time.LocalDateTime;

public interface SubjectService {
    SubjectDto addSubject(SubjectDto subjectDto, String createdBy, LocalDateTime createdAt);

    SubjectDto getClassAssigned(Long id);

//    SubjectDto assignClassToSubject(Long subjectId, Long classId, SubjectDto subjectDto, ClassDto classDto);

   SubjectDto assignClassToSubject(Long subjectId, Long classId);

//    SubjectDto assignClassToSubject(Long subjectId, Long classId);
}
