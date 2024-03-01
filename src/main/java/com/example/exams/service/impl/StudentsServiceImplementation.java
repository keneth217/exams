package com.example.exams.service.impl;

import com.example.exams.dtos.StudentsDto;
import com.example.exams.entity.Students;
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
            throw new RuntimeException("Admission number should be provided for all students");
        }else {
            if (tclass == null ){  throw new RuntimeException("class should be provided for all students");
            } else if (name == null) {
                throw new RuntimeException("Student name should be provided for all students");
            }else

            if (existingStudentOptional.isPresent()) {
                Students existingStudent = existingStudentOptional.get();
                //declare exist admission
                String existingAdm = existingStudent.getStudentName();
                throw new RuntimeException("Admission number " + admNo + " is already taken by " + existingAdm + ". Please try another admission number.");
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
        Students student = studentOptional.orElseThrow(() -> new RuntimeException("Student with admission number " + admNo + " not found"));
        return StudentMapper.mapToStudentDtos(student);
    }

//    @Override
//    public StudentsDto updateStudent(String admNo) {
//        return null;
//    }

    @Override
    public StudentsDto updateStudent(
            String admNo,
            String name,
            String phone,
            String studentClass,
            String gender,
            String termname,
            String termadmitted,
            LocalDateTime updatedAt
//            String updatedBY="keneth",
//            LocalDateTime updatedAt = LocalDateTime.now();

    ) {

        Optional<Students> studentOptional = studentsRepository.findByAdmNo(admNo);
        Students student = studentOptional.orElseThrow(() ->
                new RuntimeException("Student with admission number " + admNo + " not found"));
        if (!admNo.equals(student.getAdmNo())) {
            throw new IllegalArgumentException("Admission number cannot be updated");
        }
        student.setStudentName(name);
        student.setStudentClass(studentClass);
        student.setGender(gender);
        student.setTermAdmitted(termadmitted);
        student.setPhone(phone);
        student.setTermName(termname);
        student.setUpdatedBy("keneth korir");
        student.setUpdatedAt(updatedAt);
        Students updatedStudent =studentsRepository.save(student);
        return StudentMapper.mapToStudentDtos(updatedStudent);
    }
    @Override
    public StudentsDto deleteStudent(String admNo) {
        Optional<Students> studentOptional = studentsRepository.findByAdmNo(admNo);
        Students student = studentOptional.orElseThrow(() ->
                new RuntimeException("Student with admission number " + admNo + " not found"));
        studentsRepository.delete(student);
        return StudentMapper.mapToStudentDtos(student);
    }

    @Override
    public List<StudentsDto> getAllStudents() {
        List<Students>  students=studentsRepository.findAll();
        return  students.stream().map((Students) -> StudentMapper.mapToStudentDtos(Students))
                .collect(Collectors.toList());
    }


}
