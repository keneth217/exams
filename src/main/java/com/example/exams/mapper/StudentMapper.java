package com.example.exams.mapper;

import com.example.exams.dtos.StudentsDto;

import com.example.exams.entity.Students;
import org.modelmapper.ModelMapper;

import java.util.Set;
import java.util.stream.Collectors;

public class StudentMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //map dto to entity
    public static Students mapToStudent(StudentsDto studentsDto){

        Students students = new Students();
        students=modelMapper.map(studentsDto,Students.class);
        return students;
    }

//map entity to dto
public static StudentsDto mapToStudentDtos(Students students){
    StudentsDto studentsDto = new StudentsDto();
    studentsDto=modelMapper.map(students,StudentsDto.class);
    return studentsDto;
}
}
