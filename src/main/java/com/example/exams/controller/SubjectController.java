package com.example.exams.controller;

import com.example.exams.dtos.ClassDto;
import com.example.exams.dtos.SubjectDto;
import com.example.exams.dtos.TeacherDto;
import com.example.exams.service.SubjectService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@RestController
@RequestMapping("api/subjects")
public class SubjectController {
    private final SubjectService subjectService ;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @PostMapping("/add")
    public ResponseEntity<SubjectDto> addTeacher(@RequestBody SubjectDto subjectDto ){
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy="keneth";
        return new ResponseEntity<>(subjectService.addSubject(subjectDto,createdBy,createdAt), HttpStatus.CREATED);

    }
    @PutMapping("{subjectId}/subjects/{classId}")
    public ResponseEntity<SubjectDto> assignSubject(@PathVariable Long subjectId, @PathVariable Long classId
                                                   ) {

        SubjectDto assigneClass = subjectService.assignClassToSubject(subjectId, classId);
        return ResponseEntity.ok(assigneClass);

    }
    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getTeacher(@PathVariable Long id){
        SubjectDto subjectDto=subjectService.getClassAssigned(id);
        return ResponseEntity.ok(subjectDto);
    }
}
