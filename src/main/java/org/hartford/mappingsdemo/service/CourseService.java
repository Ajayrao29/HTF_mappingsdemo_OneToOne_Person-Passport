package org.hartford.mappingsdemo.service;

import org.hartford.mappingsdemo.model.Course;
import org.hartford.mappingsdemo.model.Student;
import org.hartford.mappingsdemo.repository.CourseRepository;
import org.hartford.mappingsdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Student> getStudentsByCourseId(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        return course.getStudents();
    }

    public Course addStudentToCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Invalid course id"));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Invalid student id"));
        student.getCourses().add(course);
        studentRepository.save(student);
        return course;
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
