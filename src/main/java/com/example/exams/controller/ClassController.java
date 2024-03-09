package com.example.exams.controller;

import com.example.exams.dtos.ClassDto;
import com.example.exams.dtos.SubjectDto;
import com.example.exams.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/classes")
public class ClassController {
    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/add")
    public ResponseEntity<ClassDto> addTeacher(@RequestBody ClassDto classDto ){
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy="keneth";
        return new ResponseEntity<>(classService.addClass(classDto,createdBy,createdAt), HttpStatus.CREATED);

    }
}
