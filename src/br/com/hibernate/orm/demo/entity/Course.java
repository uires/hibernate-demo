package br.com.hibernate.orm.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course")
public @Data class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_instructor")
	private Instructor instructor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_course")
	private List<Review> reviews;

	@ManyToMany
	@JoinTable(
			name="course_student",
			joinColumns = @JoinColumn(name = "id_course"),
			inverseJoinColumns= @JoinColumn(name = "id_student")
		)
	private List<Student> students;
	
	public Course() {

	}

	public Course(String title, Instructor instructor) {
		this.title = title;
		this.instructor = instructor;
	}

	public void add(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(review);
	}

}
