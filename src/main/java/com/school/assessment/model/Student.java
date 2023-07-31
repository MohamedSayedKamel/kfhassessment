package com.school.assessment.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "students")
@Entity
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false)
    private String fullNameEnglish;
	@Column(nullable = false)
    private String fullNameArabic;
	@Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String telephoneNumber;
    @Column(nullable = false)
    private String address;
    
    // Many-to-many relationship with courses
    @ManyToMany
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();
    
    public Student(String fullNameEnglish, String fullNameArabic, String email, String telephoneNumber, String address) {
        this.fullNameEnglish = fullNameEnglish;
        this.fullNameArabic = fullNameArabic;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullNameEnglish() {
		return fullNameEnglish;
	}
	public void setFullNameEnglish(String fullNameEnglish) {
		this.fullNameEnglish = fullNameEnglish;
	}
	public String getFullNameArabic() {
		return fullNameArabic;
	}
	public void setFullNameArabic(String fullNameArabic) {
		this.fullNameArabic = fullNameArabic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

    
}
