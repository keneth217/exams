package com.example.exams.service.impl;

import com.example.exams.dtos.MarkDto;
import com.example.exams.entity.Marks;
import com.example.exams.exceptions.ResourceNotFoundExceptions;
import com.example.exams.mapper.MarkMapper;
import com.example.exams.repository.MarksRepository;
import com.example.exams.service.MarkService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MarkServiceImplementation  implements MarkService {
    private  final MarksRepository marksRepository;

    public MarkServiceImplementation( MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
;
    }

    /**
     * @param markDto
     * @param createdBy
     * @param createdAt
     * @return
     */
    @Override
    public MarkDto enterMarks(MarkDto markDto,String grade,String createdBy, LocalDateTime createdAt) {
        Marks marks= MarkMapper.convertToEntity(markDto);
        String actualScore = marks.getActualScore();
        String totalmarks= marks.getTotalMarks();

        if (actualScore == null) {
            throw new ResourceNotFoundExceptions("Grade cannot be null",404);
        }

        int gradeValue;
        int total;
        try {
            gradeValue = Integer.parseInt(actualScore);
            total=Integer.parseInt(totalmarks);
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundExceptions("Invalid score format",404);
        }
        if (gradeValue<0  ) {
            throw new ResourceNotFoundExceptions("Student score cannot be less than 0 or negative value",404);
        }

        if (gradeValue > total  ) {
            throw new ResourceNotFoundExceptions("Student score cannot be more than total marks for a given exam subject.You have set your exam to be out of:"+totalmarks,404);
        }

        if (gradeValue >= 80) {
            marks.setGrade("A");
        } else if (gradeValue >= 70) {
            marks.setGrade("B");
        } else if (gradeValue >= 60) {
            marks.setGrade("B+");
        } else if (gradeValue >= 50) {
            marks.setGrade("C");
        } else if (gradeValue >= 40) {
            marks.setGrade("C+");
        } else if (gradeValue >= 30) {
            marks.setGrade("D");
        } else if (gradeValue <= 20) {
            marks.setGrade("E");
        }

        System.out.println("grade :" +gradeValue);
//        System.out.println("grade2:" +grade);

        marks.setCreatedAt(createdAt);
   marks.setCreatedBy(createdBy);
       Marks addedMark= marksRepository.save(marks);
               return MarkMapper.convertToDto(addedMark);
    }

    /**
     * @param admNo
     * @param subjectCode
     * @param studentClass
     * @param teacherCode
     * @param termName
     * @param updateMark
     * @return
     */
    @Override
    public MarkDto updateMark(String admNo, String subjectCode, String studentClass, String teacherCode, String termName, MarkDto updateMark) {
        LocalDateTime updatedAt = LocalDateTime.now();

        // Retrieve the marks entity from the database
        Optional<Marks> markOptional = marksRepository.findByAdmNo(admNo);
        Marks marks = markOptional.orElseThrow(() ->
                new ResourceNotFoundExceptions("Student with admission number " + admNo + " not found",404));

        // Validate updateMark and existing marks data
        String actualScore = updateMark.getActualScore();
        String totalMarks = updateMark.getTotalMarks();
        if (actualScore == null || totalMarks == null) {
            throw new ResourceNotFoundExceptions("Actual score and total marks must not be null",404);
        }

        int updatedActualScore;
        int total;
        try {
            updatedActualScore = Integer.parseInt(actualScore);
            total = Integer.parseInt(totalMarks);
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundExceptions("Invalid score format",404);
        }

        if (updatedActualScore < 0 || updatedActualScore > total) {
            throw new ResourceNotFoundExceptions("Invalid actual score",404);
        }

        // Recalculate grade based on the updated actual score
        String grade;
        if (updatedActualScore >= 80) {
            grade = "A";
        } else if (updatedActualScore >= 70) {
            grade = "B";
        } else if (updatedActualScore >= 60) {
            grade = "B+";
        } else if (updatedActualScore >= 50) {
            grade = "C";
        } else if (updatedActualScore >= 40) {
            grade = "C+";
        } else if (updatedActualScore >= 30) {
            grade = "D";
        } else {
            grade = "E";
        }

        // Update marks entity with new data
        marks.setTotalMarks(totalMarks);
        marks.setActualScore(actualScore);
        marks.setGrade(grade);
        marks.setUpdatedBy("keneth korir");
        marks.setUpdatedAt(updatedAt);

        // Save the updated marks entity
        Marks updatedMarks = marksRepository.save(marks);
        return MarkMapper.convertToDto(updatedMarks);
    }

}
