package br.com.hibernate.orm.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	/*
	*	Cascade: Configura o relacionamento de um objeto ao outro,
	*	dessa forma por examplo caso haja a exclus�o do objeto
	*	pai pela foreing key o objeto relacionado ser� excluido.
	*	Sendo assim qualquer outra a��o como edi��o do pai ir�
	*	ocorrer o mesmo ao objeto relacionando;
	*/
	
	// configura todo tipo de opera��o remo��o, altera��o, save, etc.
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco", nullable = false, unique = true)
	private Endereco endereco;

	@Column(name = "email_adress")
	private String emailAdress;

	public Student(String first, String secondName, String email) {
		this.setFirstName(first);
		this.setEmailAdress(email);
		this.setSecondName(secondName);
	}
}
