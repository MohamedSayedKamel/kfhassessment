package com.school.assessment.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.assessment.model.Course;
import com.school.assessment.model.Student;
import com.school.assessment.service.CourseService;
import com.school.assessment.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;

	@PostMapping
	public Student registerStudent(@RequestBody Student student) {
		// Save the student details to the database
		return studentService.save(student);
	}
	
	   @GetMapping
	    public List<Student> getAllStudents() {
	        return getAllStudents();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	        Student student = studentService.getStudentById(id);
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public Student addStudent(@RequestBody Student student) {
	        return studentService.addStudent(student);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Student> updateCourse(@PathVariable Long id, @RequestBody Student updatedStudent) {
	        Student student = studentService.updateStudent(id, updatedStudent);
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
	    	studentService.deleteStudent(id);
	        return ResponseEntity.noContent().build();
	    }
	    @GetMapping("/all-with-courses")
	    public List<Student> getAllStudentsWithCourses() {
	        // Fetch all students with their allocated courses
	        return studentService.findAll();
	    }
	    
	    @PostMapping("/{studentId}/allocate-courses")
	    public Student allocateCoursesToStudent(@PathVariable Long studentId, @RequestBody List<Long> courseIds) {
	        // Find the student by ID
	        Student student = studentService.getStudentById(studentId);

	        if (student != null) {
	            // Find the courses by their IDs
	            Set<Course> courses = new HashSet<>(courseService.findAllById(courseIds));
	            // Allocate courses to the student
	            student.setCourses(courses);
	            // Save the updated student to the database
	            return studentService.save(student);
	        }

	        // If the student is not found, return null or throw an exception
	        return null;
	    }
	    
		@PutMapping("/{studentId}/update-courses")
		public Student updateCoursesForStudent(@PathVariable Long studentId, @RequestBody List<Long> courseIds) {
			// Find the student by ID
			Student student = studentService.getStudentById(studentId);

			if (student != null) {
				// Find the courses by their IDs
				Set<Course> courses = new HashSet<>(courseService.findAllById(courseIds));
				// Update the student's courses
				student.setCourses(courses);
				// Save the updated student to the database
				return studentService.save(student);
			}
			// If the student is not found, return null or throw an exception
	        return null;
		}
}
