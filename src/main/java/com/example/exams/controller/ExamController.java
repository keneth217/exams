package com.example.exams.controller;

import com.example.exams.dtos.ExamDto;
import com.example.exams.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/exams")
public class ExamController {
    private ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }
    @PostMapping("/save")
    public ResponseEntity<ExamDto> addExam(@RequestBody ExamDto examDto){
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy="keneth";
        return  new ResponseEntity<>(examService.addExam(examDto,createdBy,createdAt), HttpStatus.CREATED);
    }
}
