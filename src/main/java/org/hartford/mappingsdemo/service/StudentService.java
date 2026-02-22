package org.hartford.mappingsdemo.service;

import org.hartford.mappingsdemo.model.Course;
import org.hartford.mappingsdemo.model.Student;
import org.hartford.mappingsdemo.repository.CourseRepository;
import org.hartford.mappingsdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Course> getCoursesByStudentId(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        return student.getCourses();
    }

    public Student enrollCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Invalid student id"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Invalid course id"));
        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
