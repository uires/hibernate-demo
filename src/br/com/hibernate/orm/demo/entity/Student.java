package br.com.hibernate.orm.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@NoArgsConstructor
public @Data class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "second_name")
	private String secondName;
	@Column(name = "email_adress")
	private String emailAdress;

	public Student(String first, String secondName, String email) {
		this.setFirstName(first);
		this.setEmailAdress(email);
		this.setSecondName(secondName);
	}
}
