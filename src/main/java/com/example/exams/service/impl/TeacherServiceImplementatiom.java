package com.example.exams.service.impl;

import com.example.exams.dtos.TeacherDto;
import com.example.exams.entity.Classes;
import com.example.exams.entity.Subjects;
import com.example.exams.entity.Teachers;
import com.example.exams.exceptions.ResourceNotFoundExceptions;
import com.example.exams.mapper.TeacherMapper;
import com.example.exams.repository.ClassesRepository;
import com.example.exams.repository.SubjectsRepository;
import com.example.exams.repository.TeacherRepository;
import com.example.exams.service.TeacherService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherServiceImplementatiom implements TeacherService {
    private TeacherRepository teacherRepository;
    private SubjectsRepository subjectsRepository;
    private ClassesRepository classesRepository;

    // Constructor to inject both repositories
    public TeacherServiceImplementatiom(TeacherRepository teacherRepository, SubjectsRepository subjectsRepository, ClassesRepository classesRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectsRepository = subjectsRepository;
        this.classesRepository=classesRepository;
    }


    /**
     * @param teacherDto
     * @param createdBy
     * @param createdAt
     * @return
     */
    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto, String createdBy, LocalDateTime createdAt) {
        Teachers teachers=TeacherMapper.mapToteacher(teacherDto);

        teachers.setCreatedAt(createdAt);
        teachers.setCreatedBy(createdBy);
        Teachers savedTeacher=teacherRepository.save(teachers);
        return TeacherMapper.mapToTeacherDto(savedTeacher);
    }

    /**
     * @param teacherId
     * @param subjectId
     * @return
     */




//    A teacher can be associated with multiple subjects through a many-to-many relationship.
//    A subject can belong to only one class through a many-to-one relationship.
//    A class can have multiple subjects through a one-to-many relationship.
    @Override
    public TeacherDto assignSubjectToTeacher(Long teacherId, Long subjectId, Set<Long> classIds) {
        LocalDateTime updatedAt = LocalDateTime.now();

        Optional<Teachers> optionalTeacher = teacherRepository.findById(teacherId);
        Optional<Subjects> optionalSubject = subjectsRepository.findById(subjectId);

        Teachers teacher = optionalTeacher.orElseThrow(() ->
                new ResourceNotFoundExceptions("Teacher with ID " + teacherId + " not found", 404));

        Subjects subject = optionalSubject.orElseThrow(() ->
                new ResourceNotFoundExceptions("Subject with ID " + subjectId + " not found", 404));

        // Check if the teacher is already assigned to the subject in any of the classes
        boolean isAssigned = teacher.getSubjects().stream()
                .anyMatch(s -> s.getId().equals(subjectId) && classIds.contains(s.getAClass().getId()));

        if (isAssigned) {
            throw new ResourceNotFoundExceptions("Teacher with ID " + teacherId +
                    " is already assigned to subject with ID " + subjectId + " in one of the provided classes",404);
        }

        // Assign subject to teacher
        Set<Subjects> subjects = teacher.getSubjects();
        subjects.add(subject);
        teacher.setSubjects(subjects);

        // Assign classes to subject
        Set<Classes> classesSet = new HashSet<>();
        for (Long classId : classIds) {
            Optional<Classes> optionalClass = classesRepository.findById(classId);
            Classes classes = optionalClass.orElseThrow(() ->
                    new ResourceNotFoundExceptions("Class with ID " + classId + " not found", 404));
            classesSet.add(classes);
        }
        subject.setAClass((Classes) classesSet);

        // Update teacher
        teacher.setUpdatedAt(updatedAt);
        teacherRepository.save(teacher);

        return TeacherMapper.mapToTeacherDto(teacher);
    }




    /**
     * @param id
     * @return
     */
    @Override
    public TeacherDto getTeacher(Long id) {
        Optional<Teachers> teacherOptional = teacherRepository.findById(id);
        Teachers teachers = teacherOptional.orElseThrow(() ->
                new ResourceNotFoundExceptions("Teacher wit id  " + id + " not found",404));
        return TeacherMapper.mapToTeacherDto(teachers);
    }

}
