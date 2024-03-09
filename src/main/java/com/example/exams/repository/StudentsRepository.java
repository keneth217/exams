package com.example.exams.repository;

import com.example.exams.dtos.StudentsDto;
import com.example.exams.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {
    Optional<Students> findByAdmNo(String admNo);
    Optional<Students> deleteByAdmNo(String admNo);

    List<Students> findAllByOrderByAdmNoAsc();
    @Query("SELECT NEW com.example.exams.dtos.StudentsDto(COUNT(s)) FROM Students s")
    List<StudentsDto> totalStudentsCount();

    //JPQL QUERY-use class name
    @Query("SELECT s FROM Students s WHERE " +
            "s.studentName LIKE CONCAT('%', :query, '%') OR " +
            "s.admNo LIKE CONCAT('%', :query, '%')")
    List<Students> searchStudent(@Param("query") String query);

    //native query-use table name
    @Query(value = "SELECT * FROM students s WHERE " +
            "s.StudentName LIKE CONCAT('%', :query, '%') OR " +
            "s.admNo LIKE CONCAT('%', :query, '%')",
            nativeQuery = true)
    List<Students> searchStudentNative(@Param("query") String query);

}
