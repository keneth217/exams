package com.example.exams.mapper;


import com.example.exams.dtos.SubjectDto;

import com.example.exams.entity.Subjects;
import org.modelmapper.ModelMapper;


public class SubjectMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public SubjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //map dto to entity
    public static Subjects mapToSubject(SubjectDto subjectDto){

        Subjects subjects=new Subjects();
        subjects= modelMapper.map(subjectDto,Subjects.class);
        return subjects;
    }
    //map entity to dto
    public static SubjectDto mapToSubjectsDtos(Subjects subjects){
        SubjectDto subjectDto = new SubjectDto();
        subjectDto=modelMapper.map(subjects,SubjectDto.class);
        return subjectDto;
    }
}
