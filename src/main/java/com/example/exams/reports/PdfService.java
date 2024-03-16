package com.example.exams.reports;

import com.example.exams.entity.Students;
import com.example.exams.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PdfService {
    private  final StudentsRepository studentsRepository;

//    public List<BookTransaction> bookTransaction(String token)
//    {
//        String username = ExtractUserNameJwtMyCustom.extractUsername(token);
//        List<BookTransaction> notReturnedBooks= transactionRepository.findBybookIsReturnedAndSchoolName(false,username);
//        List<BookTransaction> returnedBooks= transactionRepository.findBybookIsReturnedAndSchoolName(true,username);
//        List<BookTransaction> allBooks = new ArrayList<>();
//        allBooks.addAll(notReturnedBooks);
//        allBooks.addAll(returnedBooks);
//        return allBooks;
//    }
    public List<Students> allStudents() {
        List<Students> all= studentsRepository.findAll();
        return all;
    }

}
