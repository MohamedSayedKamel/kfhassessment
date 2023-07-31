package com.school.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.assessment.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
