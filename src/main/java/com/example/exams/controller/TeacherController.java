package com.example.exams.controller;

import com.example.exams.dtos.TeacherDto;
import com.example.exams.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/save")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacherDto ){
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy="keneth";
        return new ResponseEntity<>(teacherService.addTeacher(teacherDto,createdBy,createdAt), HttpStatus.CREATED);

    }
}
