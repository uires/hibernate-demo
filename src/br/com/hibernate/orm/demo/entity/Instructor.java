package br.com.hibernate.orm.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "instructor")
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

	public Instructor(String name, String registrationCode) {
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
