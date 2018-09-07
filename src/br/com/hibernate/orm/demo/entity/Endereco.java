package br.com.hibernate.orm.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "rua", nullable = false)
	private String rua;
	@Column(name = "bairro", nullable = false)
	private String bairro;
	@Column(name = "numero", nullable = false)
	private String numero;

	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
	private Student student;

	public Endereco() {
	}

	public Endereco(String rua, String bairro, String numero) {
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
	}
}
