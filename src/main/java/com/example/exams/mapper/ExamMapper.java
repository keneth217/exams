package com.example.exams.mapper;

import com.example.exams.dtos.ExamDto;
import com.example.exams.dtos.TeacherDto;
import com.example.exams.entity.Exams;
import com.example.exams.entity.Teachers;

public class ExamMapper {

    //map dto to entity
    public static Exams  mapToExams(ExamDto examDto){

       Exams exams=new Exams(
            examDto.getId(),
               examDto.getExamName(),
               examDto.getTermName(),
               examDto.getTotalMarks()

        );
        return exams;
    }
    //map entity to dto
    public static ExamDto mapToExamDto(Exams exams){
       ExamDto examDto=new ExamDto(
               exams.getId(),
               exams.getExamName(),
               exams.getTermName(),
               exams.getTotalMarks()
        );
        return examDto;
    }
}
