package com.example.exams.mapper;

import com.example.exams.dtos.ClassDto;
import com.example.exams.dtos.StudentsDto;
import com.example.exams.dtos.SubjectDto;
import com.example.exams.entity.Classes;
import com.example.exams.entity.Students;
import com.example.exams.entity.Subjects;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

public class ClasesMapper {
    private static ModelMapper modelMapper  =new ModelMapper();;

    public ClasesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //map dto to entity
    public static Classes mapToClasses(ClassDto classDto){

        Classes class1= new Classes();
        class1=modelMapper.map(classDto,Classes.class);
        return class1;
    }
    //map entity to dto
    public static ClassDto mapToSubjectsDtos(Classes classes){
       ClassDto classDto=new ClassDto();
       classDto=modelMapper.map(classes,ClassDto.class);
        return classDto;
    }
}
