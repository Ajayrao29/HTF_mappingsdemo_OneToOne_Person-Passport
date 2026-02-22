package org.hartford.mappingsdemo.controller;

import org.hartford.mappingsdemo.model.Course;
import org.hartford.mappingsdemo.model.Student;
import org.hartford.mappingsdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @PutMapping("/{studentId}/enroll/{courseId}")
    public Student enrollCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.enrollCourse(studentId, courseId);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
