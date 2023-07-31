package com.school.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.assessment.model.Student;
import com.school.assessment.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student save(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	
	
	public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
        	existingStudent.setFullNameEnglish(updatedStudent.getFullNameEnglish());
        	existingStudent.setFullNameArabic(updatedStudent.getFullNameArabic());
        	existingStudent.setEmail(updatedStudent.getEmail());
        	existingStudent.setAddress(updatedStudent.getAddress());
        	existingStudent.setTelephoneNumber(updatedStudent.getTelephoneNumber());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(Long id) {
    	studentRepository.deleteById(id);
    }
    
    public List<Student> findAll() {
        // Fetch all students with their allocated courses
        return studentRepository.findAll();
    }
}

