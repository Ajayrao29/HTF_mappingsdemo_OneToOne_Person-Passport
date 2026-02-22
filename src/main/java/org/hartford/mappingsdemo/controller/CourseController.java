package org.hartford.mappingsdemo.controller;

import org.hartford.mappingsdemo.model.Course;
import org.hartford.mappingsdemo.model.Student;
import org.hartford.mappingsdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/{id}/students")
    public List<Student> getStudentsByCourseId(@PathVariable Long id) {
        return courseService.getStudentsByCourseId(id);
    }

    @PutMapping("/{courseId}/add/{studentId}")
    public Course addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        return courseService.addStudentToCourse(courseId, studentId);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
