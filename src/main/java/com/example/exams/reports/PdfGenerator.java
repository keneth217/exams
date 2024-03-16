package com.example.exams.reports;

import com.example.exams.entity.Students;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class PdfGenerator {
    private final String documentUrl = "C:\\Reports\\";

    private String generateUniqueFileName() {
        String randomString = UUID.randomUUID().toString().replace("-", "");
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "report_" + randomString + "_" + timestamp;
    }

    public String allStudents(List<Students> allStudents) throws DocumentException, FileNotFoundException {
        String docName = generateUniqueFileName() + ".pdf";
        String filePath = documentUrl + docName;
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, Font.BOLD, BaseColor.RED);
            Paragraph title = new Paragraph("All Students Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(10);
            document.add(title);

            Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Color tableBackgroundColor = new DeviceRgb(220, 220, 220);
            System.out.println(tableBackgroundColor);

            PdfPTable table = new PdfPTable(7);// Specify the number of columns for the table

            // Add table headers
            table.addCell(createTableCell("Adm No", tableHeaderFont));
            table.addCell(createTableCell("Student Name", tableHeaderFont));
            table.addCell(createTableCell("class", tableHeaderFont));
            table.addCell(createTableCell("gender", tableHeaderFont));
            table.addCell(createTableCell("phone", tableHeaderFont));
            table.addCell(createTableCell("term Admitted", tableHeaderFont));
            table.addCell(createTableCell("current term", tableHeaderFont));

            // Add student information to the table
            for (Students students:allStudents) {
                table.addCell(createTableCell(students.getAdmNo(), contentFont));
                table.addCell(createTableCell(students.getStudentName(), contentFont));
                table.addCell(createTableCell(students.getStudentClass(), contentFont));
                table.addCell(createTableCell(students.getGender(), contentFont));
                table.addCell(createTableCell(students.getPhone(), contentFont));
                table.addCell(createTableCell(students.getTermAdmitted(), contentFont));
                table.addCell(createTableCell(students.getTermName(), contentFont));
            }

            document.add(table);
        } finally {
            document.close();
        }
        return docName;
    }

    private PdfPCell createTableCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(5);
        return cell;
    }

}
