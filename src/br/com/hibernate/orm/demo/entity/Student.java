package br.com.hibernate.orm.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "second_name")
	private String secondName;

	@ManyToMany
	@JoinTable(
			name = "course_student", 
			joinColumns = @JoinColumn(name = "id_student"), 
			inverseJoinColumns = @JoinColumn(name = "id_course")
		)
	private List<Course> courses;

	/*
	 * Cascade: Configura o relacionamento de um objeto ao outro, dessa forma por
	 * examplo caso haja a exclusão do objeto pai pela foreing key o objeto
	 * relacionado será excluido. Sendo assim qualquer outra ação como edição do pai
	 * irá ocorrer o mesmo ao objeto relacionando;
	 */

	// configura para todos os tipos de operações
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco", nullable = false, unique = true)
	private Endereco endereco;

	@Column(name = "email_adress")
	private String emailAdress;

	public Student() {
	}

	public Student(String first, String secondName, String email) {
		this.setFirstName(first);
		this.setEmailAdress(email);
		this.setSecondName(secondName);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", endereco="
				+ endereco + ", emailAdress=" + emailAdress + "]";
	}

}
