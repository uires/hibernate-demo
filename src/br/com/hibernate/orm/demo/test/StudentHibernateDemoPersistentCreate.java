package br.com.hibernate.orm.demo.test;

import br.com.hibernate.demo.DAO.StudentDAO;
import br.com.hibernate.orm.demo.entity.Endereco;
import br.com.hibernate.orm.demo.entity.Student;

public class StudentHibernateDemoPersistentCreate {

	public static void main(String[] args) {

		StudentDAO dao = null;
		dao = StudentDAO.getInstanceOf();
		Student student = new Student("Poliana", "Santana", "poli@gmail.com");
		student.setEndereco(new Endereco("Rua das Flores", "Magalhães", "nº7754"));
		dao.saveObject(student);

	}
}
