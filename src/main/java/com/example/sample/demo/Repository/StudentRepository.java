// StudentRepository.java
package com.example.sample.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sample.demo.Entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s.rollNumber FROM Student s")
    List<Long> findAllRollNumbers();

    @Query("SELECT s FROM Student s WHERE s.rollNumber = :rollNumber")
    Student findByRollNumber(Long rollNumber);
}
