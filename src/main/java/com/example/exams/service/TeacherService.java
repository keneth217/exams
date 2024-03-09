package com.example.exams.service;

import com.example.exams.dtos.ClassDto;
import com.example.exams.dtos.SubjectDto;
import com.example.exams.dtos.TeacherDto;

import java.time.LocalDateTime;

public interface TeacherService {
    TeacherDto addTeacher(TeacherDto teacherDto,String createdBy, LocalDateTime createdAt);

//    SubjectDto assignSubjects(Long teacherId, Long subjectId, TeacherDto teacherDto, SubjectDto subjectDto);

    TeacherDto assignSubjectToTeacher(Long teacherId, Long subjectId, Long classId);

    TeacherDto getTeacher(Long id);
}
