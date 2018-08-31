package br.com.hibernate.orm.demo.test;

import br.com.hibernate.demo.DAO.StudentDAO;
import br.com.hibernate.orm.demo.entity.Endereco;
import br.com.hibernate.orm.demo.entity.Student;

public class StudentHibernateDemoPersistentOneToOne {

	public static void main(String[] args) {
		StudentDAO dao = null;
		dao = StudentDAO.getInstanceOf();
		Student student = new Student("Luis", "Felipe", "luis@outlook.com");
		student.setEndereco(new Endereco("Av. Paulista", "São Paulo", "nº 1445"));
		dao.saveObject(student);
	}
}
