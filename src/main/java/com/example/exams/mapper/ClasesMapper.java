package com.example.exams.mapper;

import com.example.exams.dtos.StudentsDto;
import com.example.exams.dtos.SubjectDto;
import com.example.exams.entity.Students;
import com.example.exams.entity.Subjects;
import java.util.stream.Collectors;

public class ClasesMapper {
    //map dto to entity
    public static Subjects mapToSubject(SubjectDto subjectDto){

        Subjects subjects=new Subjects(
                subjectDto.getId(),
                subjectDto.getSubjectAlias(),
                subjectDto.getSubjectName(),
                subjectDto.getSubjectCategory(),
                subjectDto.getOutOf(),
                subjectDto.getTotalScore()
        );
        return subjects;
    }
    //map entity to dto
    public static SubjectDto mapToSubjectsDtos(Subjects subjects){
        SubjectDto subjectDto = new SubjectDto(
                subjects.getId(),
                subjects.getSubjectAlias(),
                subjects.getSubjectName(),
                subjects.getSubjectCategory(),
                subjects.getSubjectCode(),
                subjects.getOutOf(),
                subjects.getTotalScore()


        );
        return subjectDto;
    }
}
