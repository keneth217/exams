package com.example.exams.mapper;

import com.example.exams.dtos.ExamDto;
import com.example.exams.dtos.TeacherDto;
import com.example.exams.entity.Exams;
import com.example.exams.entity.Teachers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ExamMapper {

     private static ModelMapper modelMapper = new ModelMapper();

    public ExamMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    //map dto to entity
//    public static Exams  mapToExams(ExamDto examDto){
//
//       Exams exams=new Exams(
//            examDto.getId(),
//               examDto.getExamName(),
//               examDto.getTermName(),
//               examDto.getTotalMarks()
//
//        );
//        return exams;
//    }
    public static Exams  mapDtoToEntity(ExamDto examDto){

        Exams exams=new Exams();
        exams = modelMapper.map(examDto,Exams.class);

        return exams;
    }
    //map entity to dto
//    public static ExamDto mapToExamDto(Exams exams){
//       ExamDto examDto=new ExamDto(
//               exams.getId(),
//               exams.getExamName(),
//               exams.getTermName(),
//               exams.getTotalMarks()
//        );
//        return examDto;
//    }
    public static ExamDto mapEntityToDto(Exams exams){
        ExamDto examDto=new ExamDto();
        examDto= modelMapper.map(exams,ExamDto.class);
        return examDto;
    }
}
