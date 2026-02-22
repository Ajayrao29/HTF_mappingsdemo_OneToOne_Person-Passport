package org.hartford.mappingsdemo.repository;

import org.hartford.mappingsdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
