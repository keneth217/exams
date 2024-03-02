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
        Exams exams= ExamMapper.mapDtoToEntity(examDto);

        // Set the totalMarks attribute from the ExamDto
        exams.setTotalMarks(examDto.getTotalMarks());
       String ex=examDto.getExamName();

        String ter= examDto.getTermName();
        int total=examDto.getTotalMarks();
        System.out.println("total marks:" +total);
        if (examRepository.existsByExamNameAndTermName(examDto.getExamName(), examDto.getTermName())) {
            throw new RuntimeException("Exam  with name " +ex+ "and termname " +ter+" already exists");

        } else {
            if (total > 100)
                throw new RuntimeException("total marks  should be less than 100");
            exams.setCreatedAt(createdAt);
        exams.setCreatedBy(createdBy);
        Exams savedExam=examRepository.save(exams);
        return ExamMapper.mapEntityToDto(savedExam);
        }
    }
}
