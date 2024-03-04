package com.example.exams.mapper;

import com.example.exams.dtos.MarkDto;
import com.example.exams.entity.Marks;
import org.modelmapper.ModelMapper;

public class MarkMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public MarkMapper(ModelMapper modelMapper) {
        MarkMapper.modelMapper = modelMapper;
    }

    public static MarkDto convertToDto(Marks marks) {
        return modelMapper.map(marks, MarkDto.class);
    }

    public static Marks convertToEntity(MarkDto markDto) {
        return modelMapper.map(markDto, Marks.class);
    }
}