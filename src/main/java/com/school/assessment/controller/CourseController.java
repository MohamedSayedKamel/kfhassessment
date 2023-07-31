package com.school.assessment.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.school.assessment.dto.error.ErrorDTO;
import com.school.assessment.dto.error.ErrorListDTO;
import com.school.assessment.exceptions.AssessmentException;
import com.school.assessment.model.Course;
import com.school.assessment.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	@Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        Course course = courseService.updateCourse(id, updatedCourse);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler({ AssessmentException.class })
	public ErrorListDTO handleAssessmentExceptionException(final AssessmentException ex){
		ErrorListDTO errorListDTO=new ErrorListDTO();
		ErrorDTO errorDTO=new ErrorDTO();
		
		errorDTO.setErrorCode(ex.getType().getErrorCode());
		errorDTO.setExceptionMessage(ex.getMessage());
		errorDTO.setReason(ex.getType().getErrorMessage());
		errorDTO.setType(ex.getType().toString());
		errorListDTO.setErrors(Arrays.asList(errorDTO));
		
		return errorListDTO;
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler({ IllegalArgumentException.class })
	public ErrorListDTO handleIllegalArgumentException(final IllegalArgumentException ex){
		ErrorListDTO errorListDTO=new ErrorListDTO();
		ErrorDTO errorDTO=new ErrorDTO();
		
		errorDTO.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		errorDTO.setExceptionMessage(ex.getMessage());
		errorDTO.setReason(ex.getMessage());
		errorDTO.setType("IllegalArgumentException");
		errorListDTO.setErrors(Arrays.asList(errorDTO));
		
		return errorListDTO;
	}
}
