package com.example.exams.controller;


import com.example.exams.dtos.Response;
import com.example.exams.dtos.StudentsDto;

import com.example.exams.entity.Students;
import com.example.exams.service.StudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentsController {
    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    //add student api
    @PostMapping("/save")
    public ResponseEntity<StudentsDto> addStudent(@RequestBody StudentsDto studentsDto){
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy="keneth";
        return new ResponseEntity<>(studentsService.addStudent(studentsDto, createdBy,createdAt
        ), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<StudentsDto>> getAllStudents(){
        List<StudentsDto> students =studentsService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{admNo}")
    public ResponseEntity<StudentsDto> getStudentByAdm(@PathVariable String admNo){
        StudentsDto studentsDto=studentsService.getStudentByAdm(admNo);
        return ResponseEntity.ok(studentsDto);
    }
    @PutMapping("/{admNo}/update")
    public ResponseEntity<Response> updateStudentById(@PathVariable String admNo,
                                                         @RequestBody StudentsDto studentsDto) {
        LocalDateTime updatedAt = LocalDateTime.now(); // Set the current date and time
        System.out.println("--------updating-----------");
        System.out.println(updatedAt);
        System.out.println("--------date-----------");
        System.out.println(admNo);
        System.out.println("--------done-----------");
        System.out.println(studentsDto.getStudentName());
        StudentsDto updatedStudentDto = studentsService.updateStudent(
                admNo,
                studentsDto.getStudentName(),
                studentsDto.getPhone(),
                studentsDto.getStudentClass(),
                studentsDto.getGender(),
                studentsDto.getTermName(),
                studentsDto.getTermAdmitted(),
                updatedAt
        );
        Response response=new Response();
        response.setCode("200");
        response.setMessage("student  with admno "+" "+admNo+" "+"updated successfully");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
    @DeleteMapping("/{admNo}/delete")
    public ResponseEntity<Response> deleteStudentById(@PathVariable String admNo){
      StudentsDto students= studentsService.deleteStudent(admNo);
      Response response=new Response();
      response.setCode("200");
      response.setMessage("student with adm no"+students.getAdmNo()+" deleted successfully");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
