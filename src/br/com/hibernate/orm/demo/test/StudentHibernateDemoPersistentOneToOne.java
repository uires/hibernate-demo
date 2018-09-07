package br.com.hibernate.orm.demo.test;

import br.com.hibernate.demo.DAO.StudentDAO;
import br.com.hibernate.demo.factory.HibernateFactory;
import br.com.hibernate.orm.demo.entity.Endereco;
import br.com.hibernate.orm.demo.entity.Student;

public class StudentHibernateDemoPersistentOneToOne {

	public static void main(String[] args) {
		StudentDAO dao = null;
		dao = StudentDAO.getInstanceOf();
		
		// criando os objetos
		Student student = new Student("Yuri", "D'vlleavv'cy Kezzian", "kezzian@outlook.com");
		// relacionando um objeto ao outro OneToOne
		student.setEndereco(new Endereco("Av. Dorival Dos Santos", "Minas Gerais", "nº 989"));
		// salvando objeto
		dao.saveObject(student);
		
		Student selectStudentById = dao.selectStudentById(4L);
		System.out.println(selectStudentById.toString());
	}
}
