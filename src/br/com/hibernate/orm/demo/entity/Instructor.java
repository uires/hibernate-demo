package br.com.hibernate.orm.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

public @Data class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "registration_code")
	private String registrationCode;
	@OneToMany(mappedBy = "instructor", cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<Course> courses;

	public Instructor(Long id, String name, String registrationCode) {
		this.id = id;
		this.name = name;
		this.registrationCode = registrationCode;
	}

	public void add(Course course) {
		if (this.courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(course);
		course.setInstructor(this);
	}

}
