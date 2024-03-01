package com.example.exams.service.impl;

import com.example.exams.dtos.ExamDto;
import com.example.exams.entity.Exams;
import com.example.exams.mapper.ExamMapper;
import com.example.exams.repository.ExamRepository;
import com.example.exams.service.ExamService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExamServiceImplementation implements ExamService {
    private ExamRepository examRepository;

    public ExamServiceImplementation(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    /**
     * @param examDto
     * @param createdBy
     * @param createdAt
     * @return
     */
    @Override
    public ExamDto addExam(ExamDto examDto, String createdBy, LocalDateTime createdAt) {
        Exams exams= ExamMapper.mapToExams(examDto);
        exams.setCreatedAt(createdAt);
        exams.setCreatedBy(createdBy);
        Exams savedExam=examRepository.save(exams);
        return ExamMapper.mapToExamDto(savedExam);
    }
}
