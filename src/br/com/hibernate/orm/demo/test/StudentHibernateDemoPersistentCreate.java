package br.com.hibernate.orm.demo.test;

import br.com.hibernate.demo.DAO.StudentDAO;
import br.com.hibernate.orm.demo.entity.Student;

public class StudentHibernateDemoPersistentCreate {

	public static void main(String[] args) {
		StudentDAO dao = null;
		dao = StudentDAO.getInstanceOf();
		dao.saveObject(new Student("Uíres", "Sousa", "uires@gmail.com"));
	}
}
