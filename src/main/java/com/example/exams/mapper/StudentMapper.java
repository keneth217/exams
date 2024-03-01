package com.example.exams.mapper;

import com.example.exams.dtos.StudentsDto;
//import com.example.exams.dtos.SubjectDto;
import com.example.exams.entity.Students;

import java.util.Set;
import java.util.stream.Collectors;

public class StudentMapper {
    //map dto to entity
    public static Students mapToStudent(StudentsDto studentsDto){

        Students students = new Students(
                studentsDto.getId(),
               studentsDto.getAdmNo(),
               studentsDto.getStudentName(),
               studentsDto.getStudentClass(),
               studentsDto.getGender(),
               studentsDto.getTermName(),
               studentsDto.getTermAdmitted(),
              studentsDto.getPhone()
//                studentsDto.getSubjects().stream().map(subject1 -> subject1.getSubjectCode()).collect(Collectors.toSet())
//               studentsDto.getSubjects().stream().map(SubjectDto::new).collect(Collectors.toSet())
        );
        return students;
    }

//map entity to dto
public static StudentsDto mapToStudentDtos(Students students){
    StudentsDto studentsDto = new StudentsDto(
            students.getId(),
            students.getAdmNo(),
            students.getStudentName(),
            students.getStudentClass(),
            students.getGender(),
            students.getTermName(),
            students.getTermAdmitted(),
            students.getPhone()
//        students.getSubjects().stream().map()
    );
    return studentsDto;
}
}
