package org.hartford.mappingsdemo.repository;

import org.hartford.mappingsdemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
