package com.example.exams.controller;


import com.example.exams.dtos.MarkDto;
import com.example.exams.dtos.Response;
import com.example.exams.service.MarkService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/marks")
public class MarksController {
    private final MarkService markService;

    public MarksController(MarkService markService) {
        this.markService = markService;
    }

    @PostMapping("/add")
    public ResponseEntity<MarkDto> addStudentMark(@RequestBody MarkDto markDto){
        String grade=markDto.getGrade();
        System.out.println("my grade:"+grade);
        String createdBy="keneth";
        LocalDateTime createdAt = LocalDateTime.now();

        return new ResponseEntity<>(markService.enterMarks(markDto,grade,createdBy,createdAt), HttpStatus.OK);

    }
   @PutMapping("/{admNo}/{subjectCode}/{teacherCode}/{studentClass}/update")
//    @PutMapping("/{admNo}/update")
    public ResponseEntity<Response> updateMark(@PathVariable   String admNo,
                                               @PathVariable   String subjectCode,
                                               @PathVariable  String studentClass,
                                               @PathVariable       String teacherCode,
                                               String termName,
                                               @RequestBody MarkDto updateMark){
        markService.updateMark(admNo,subjectCode,studentClass,teacherCode,termName,updateMark);
        Response response=new Response();
        response.setCode("200");
        response.setMessage("student marks with admno "+" "+admNo+" "+"updated successfully");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
