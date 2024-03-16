package com.example.exams.service;

import com.example.exams.dtos.ClassDto;
import com.example.exams.dtos.SubjectDto;
import com.example.exams.dtos.TeacherDto;

import java.time.LocalDateTime;
import java.util.Set;

public interface TeacherService {
    TeacherDto addTeacher(TeacherDto teacherDto,String createdBy, LocalDateTime createdAt);

//    SubjectDto assignSubjects(Long teacherId, Long subjectId, TeacherDto teacherDto, SubjectDto subjectDto);

//    TeacherDto assignSubjectToTeacher(Long teacherId, Long subjectId, Long classId);


    //    A teacher can be associated with multiple subjects through a many-to-many relationship.
//    A subject can belong to only one class through a many-to-one relationship.
//    A class can have multiple subjects through a one-to-many relationship.
    TeacherDto assignSubjectToTeacher(Long teacherId, Long subjectId, Set<Long> classIds);

    TeacherDto getTeacher(Long id);
}
