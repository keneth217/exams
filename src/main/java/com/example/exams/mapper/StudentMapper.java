package com.example.exams.mapper;

import com.example.exams.dtos.StudentsDto;
import com.example.exams.entity.Students;

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
//               studentsDto.getSubjects()


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
//            students.getSubjects()
    );
    return studentsDto;
}
}
