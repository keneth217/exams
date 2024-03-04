package com.example.exams.service.impl;

import com.example.exams.dtos.StudentsDto;
import com.example.exams.entity.Students;
import com.example.exams.exceptions.ResourceNotFoundExceptions;
import com.example.exams.mapper.StudentMapper;
import com.example.exams.repository.StudentsRepository;
import com.example.exams.service.StudentsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImplementation implements StudentsService {
    private final StudentsRepository studentsRepository;

    public StudentsServiceImplementation(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public StudentsDto addStudent(StudentsDto studentsDto,String createdBy,LocalDateTime createdAt) {
        Students students = StudentMapper.mapToStudent(studentsDto);



        System.out.println("--------adding student-----------");
        System.out.println("student details:"+studentsDto);
        System.out.println("created by:" +createdBy);
        System.out.println("created at:" +createdAt);
        System.out.println("--------adding student -----------");

        // Check if admission number is already taken.extract admission
        String admNo = studentsDto.getAdmNo();
        String name=studentsDto.getStudentName();
        String tclass= studentsDto.getStudentClass();

        System.out.println("Admission number: " + admNo);
        System.out.println("Class: " + tclass);
        System.out.println("Name: " + name);

        Optional<Students> existingStudentOptional = studentsRepository.findByAdmNo(admNo);
        if (admNo == null) {
            throw new ResourceNotFoundExceptions("Admission number should be provided for all students",404);
        }else {
            if (tclass == null ){  throw new ResourceNotFoundExceptions("class should be provided for all students",404);
            } else if (name == null) {
                throw new ResourceNotFoundExceptions("Student name should be provided for all students",404);
            }else

            if (existingStudentOptional.isPresent()) {
                Students existingStudent = existingStudentOptional.get();
                //declare exist admission
                String existingAdm = existingStudent.getStudentName();
                throw new ResourceNotFoundExceptions("Admission number " + admNo + " is already taken by "
                        + existingAdm + ". Please try another admission number.",404);
            }
        }
        students.setCreatedAt(createdAt);
        students.setCreatedBy(createdBy);
        Students savedStudents=studentsRepository.save(students);
        System.out.println("--------adding student done-----------");
        return StudentMapper.mapToStudentDtos(savedStudents);
    }

    @Override
    public StudentsDto getStudentByAdm(String admNo) {
        Optional<Students> studentOptional = studentsRepository.findByAdmNo(admNo);
        Students student = studentOptional.orElseThrow(() ->
                new ResourceNotFoundExceptions("Student with admission number " + admNo + " not found",404));
        return StudentMapper.mapToStudentDtos(student);
    }

//    @Override
//    public StudentsDto updateStudent(String admNo) {
//        return null;
//    }

    @Override
    public StudentsDto updateStudent(String admNo, StudentsDto updateSt1) {
        LocalDateTime updatedAt=LocalDateTime.now();
        Optional<Students> studentOptional = studentsRepository.findByAdmNo(admNo);
        Students student = studentOptional.orElseThrow(() ->
                new ResourceNotFoundExceptions("Student with admission number " + admNo + " not found",404));
        if (!admNo.equals(student.getAdmNo())) {
            throw new ResourceNotFoundExceptions("Admission number cannot be updated",404);
        }
        student.setStudentName(updateSt1.getStudentName());
        student.setStudentClass(updateSt1.getStudentClass());
        student.setGender(updateSt1.getGender());
        student.setTermAdmitted(updateSt1.getTermAdmitted());
        student.setPhone(updateSt1.getPhone());
        student.setTermName(updateSt1.getTermName());
        student.setUpdatedBy("keneth korir");
        student.setUpdatedAt(updatedAt);
        Students updatedStudent =studentsRepository.save(student);
        return StudentMapper.mapToStudentDtos(updatedStudent);
    }
    //   void does not return anything
    @Override
    public void  deleteStudent(String admNo) {
        Optional<Students> studentOptional = studentsRepository.findByAdmNo(admNo);
        Students student = studentOptional.orElseThrow(() ->
                new ResourceNotFoundExceptions("Student with admission number " + admNo + " not found",404));
        studentsRepository.delete(student);
    }

    @Override
    public List<StudentsDto> getAllStudents() {
        List<Students>  students=studentsRepository.findAllByOrderByAdmNoAsc();
        System.out.println("---------------ordering by asc___________-");
        return  students.stream().map((Students) -> StudentMapper.mapToStudentDtos(Students))
                .collect(Collectors.toList());
    }

    /**
     * @param query
     * @return
     */
    @Override
    public List<StudentsDto> searchStudents(String query) {
        List<Students> students = studentsRepository.searchStudent(query);
        System.out.println("params:"+query);
        if (students.isEmpty()) {
            throw new RuntimeException("No students found");
//            throw new RuntimeException("No students found with the given query: " + query);
        }
        return students.stream()
                .map(student -> StudentMapper.mapToStudentDtos(student))
                .collect(Collectors.toList());
    }


}
