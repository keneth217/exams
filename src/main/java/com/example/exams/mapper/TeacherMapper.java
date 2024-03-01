package com.example.exams.mapper;


import com.example.exams.dtos.TeacherDto;
import com.example.exams.entity.Teachers;

public class TeacherMapper {
    //map dto to entity
    public static Teachers mapToteacher(TeacherDto teacherDto){

        Teachers teachers=new Teachers(
                teacherDto.getId(),
                teacherDto.getTeacherCode(),
                teacherDto.getTeacherName(),
                teacherDto.getTphone()


        );
        return teachers;
    }
    //map entity to dto
    public static TeacherDto mapToTeacherDto(Teachers teachers){
        TeacherDto teacherDto=new TeacherDto(
                teachers.getId(),
                teachers.getTeacherCode(),
                teachers.getTeacherName(),
                teachers.getTphone()


        );
        return teacherDto;
    }
}
