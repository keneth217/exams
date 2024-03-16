package com.example.exams.controller;

import com.example.exams.dtos.ClassDto;
import com.example.exams.dtos.SubjectDto;
import com.example.exams.dtos.TeacherDto;
import com.example.exams.exceptions.ResourceNotFoundExceptions;
import com.example.exams.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/save")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacherDto ){
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy="keneth";
        return new ResponseEntity<>(teacherService.addTeacher(teacherDto,createdBy,createdAt), HttpStatus.CREATED);
    }
    @PostMapping("{teacherId}/assign/{subjectId}/{classId}")
    public ResponseEntity<TeacherDto> assignSubject(@PathVariable Long teacherId,
                                                    @PathVariable Long subjectId,
                                                    @PathVariable Long classId) {
        TeacherDto assignedTeacher = teacherService.assignSubjectToTeacher(teacherId, subjectId, Collections.singleton(classId));
        return ResponseEntity.ok(assignedTeacher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable Long id){
       TeacherDto teacherDto=teacherService.getTeacher(id);
        return ResponseEntity.ok(teacherDto);
    }
}
