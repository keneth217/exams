package com.example.exams.mapper;


import com.example.exams.dtos.TeacherDto;
import com.example.exams.entity.Teachers;
import org.modelmapper.ModelMapper;

public class TeacherMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public TeacherMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //map dto to entity
    public static Teachers mapToteacher(TeacherDto teacherDto){

        Teachers teachers=new Teachers();
        teachers=modelMapper.map(teacherDto,Teachers.class);
        return teachers;
    }
    //map entity to dto
    public static TeacherDto mapToTeacherDto(Teachers teachers){
        TeacherDto teacherDto=new TeacherDto();
        teacherDto=modelMapper.map(teachers,TeacherDto.class);
        return teacherDto;
    }
}
