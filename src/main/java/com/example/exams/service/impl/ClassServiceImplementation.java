package com.example.exams.service.impl;

import com.example.exams.dtos.ClassDto;
import com.example.exams.entity.Classes;
import com.example.exams.entity.Subjects;
import com.example.exams.mapper.ClasesMapper;
import com.example.exams.mapper.SubjectMapper;
import com.example.exams.repository.ClassesRepository;
import com.example.exams.service.ClassService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClassServiceImplementation implements ClassService {
    private ClassesRepository classesRepository;

    public ClassServiceImplementation(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    /**
     * @param classDto
     * @param createdBy
     * @param createdAt
     * @return
     */
    @Override
    public ClassDto addClass(ClassDto classDto, String createdBy, LocalDateTime createdAt) {
        Classes classes = ClasesMapper.mapToClasses(classDto);
    classes.setCreatedAt(createdAt);
    classes.setCreatedBy(createdBy);
       Classes savedClass= classesRepository.save(classes);
        return ClasesMapper.mapToSubjectsDtos(classes);
    }
}
