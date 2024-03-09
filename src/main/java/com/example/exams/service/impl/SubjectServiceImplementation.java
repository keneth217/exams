package com.example.exams.service.impl;

import com.example.exams.dtos.SubjectDto;
import com.example.exams.entity.Classes;
import com.example.exams.entity.Subjects;
import com.example.exams.exceptions.ResourceNotFoundExceptions;
import com.example.exams.mapper.SubjectMapper;
import com.example.exams.repository.ClassesRepository;
import com.example.exams.repository.SubjectsRepository;
import com.example.exams.service.SubjectService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SubjectServiceImplementation implements SubjectService {

    private SubjectsRepository subjectsRepository;
    private ClassesRepository classesRepository;


    public SubjectServiceImplementation(SubjectsRepository subjectsRepository,ClassesRepository classesRepository) {
        this.subjectsRepository = subjectsRepository;
        this.classesRepository = classesRepository;
    }

    /**
     * @param subjectDto
     * @param createdBy
     * @param createdAt
     * @return
     */
    @Override
    public SubjectDto addSubject(SubjectDto subjectDto, String createdBy, LocalDateTime createdAt) {
        Subjects  subjects= SubjectMapper.mapToSubject(subjectDto);
        subjects.setCreatedAt(createdAt);
        subjects.setCreatedBy(createdBy);
        Subjects savedSubject= subjectsRepository.save(subjects);
        return SubjectMapper.mapToSubjectsDtos(savedSubject);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SubjectDto getClassAssigned(Long id) {
        Optional<Subjects> subjectOptional = subjectsRepository.findById(id);
      Subjects subjects = subjectOptional.orElseThrow(() ->
                new ResourceNotFoundExceptions("subject with id  " + id + " not found",404));
        return SubjectMapper.mapToSubjectsDtos(subjects);
    }

    /**
     * @param subjectId
     * @param classId
     * @param subjectDto
     * @param classDto
     * @return
     */
//    @Override
//    public SubjectDto assignClassToSubject(Long subjectId, Long classId, SubjectDto subjectDto, ClassDto classDto) {
//        return null;
//    }

    /**
     * @param subjectId
     * @param classId
     * @return
     */

    @Override
    public SubjectDto assignClassToSubject(Long subjectId, Long classId) {
        LocalDateTime updatedAt = LocalDateTime.now();

        // Retrieve the subject and class entities
        Optional<Subjects> optionalSubject = subjectsRepository.findById(subjectId);
        Optional<Classes> optionalClass = classesRepository.findById(classId);

        // Throw exception if subject or class is not found
        Subjects subject = optionalSubject.orElseThrow(() ->
                new ResourceNotFoundExceptions("Subject with ID " + subjectId + " not found", 404));
        Classes classes = optionalClass.orElseThrow(() ->
                new ResourceNotFoundExceptions("Class with ID " + classId + " not found", 404));

        // Check if class is already assigned to the subject
        if (subject.getAClass() != null && subject.getAClass().equals(classId)) {
            throw new ResourceNotFoundExceptions("Class with ID " + classId + " is already assigned to subject with ID " + subjectId,404);
        }

        // Assign class to the subject
        subject.setAClass(subject.getAClass());
        subject.setUpdatedAt(updatedAt);

        // Save the updated subject
        Subjects updatedSubject = subjectsRepository.save(subject);

        return SubjectMapper.mapToSubjectsDtos(updatedSubject);
    }

}
