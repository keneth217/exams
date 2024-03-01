package com.example.exams.service.impl;

import com.example.exams.dtos.TeacherDto;
import com.example.exams.entity.Teachers;
import com.example.exams.mapper.TeacherMapper;
import com.example.exams.repository.TeacherRepository;
import com.example.exams.service.TeacherService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TeacherServiceImplementatiom implements TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherServiceImplementatiom(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    /**
     * @param teacherDto
     * @param createdBy
     * @param createdAt
     * @return
     */
    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto, String createdBy, LocalDateTime createdAt) {
        Teachers teachers=TeacherMapper.mapToteacher(teacherDto);

        teachers.setCreatedAt(createdAt);
        teachers.setCreatedBy(createdBy);
        Teachers savedTeacher=teacherRepository.save(teachers);
        return TeacherMapper.mapToTeacherDto(savedTeacher);
    }
}
