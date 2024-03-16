package com.example.exams.reports;

import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/v1/reports/")
@RequiredArgsConstructor
public class PdfController {
    private final PdfGenerator pdfGenerator;
    private final PdfService pdfService;


    @GetMapping("students")
    public String allStudents() throws DocumentException, FileNotFoundException {
        return pdfGenerator.allStudents(pdfService.allStudents());
    }


}
