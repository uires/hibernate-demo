package br.com.hibernate.orm.demo.test;

import org.junit.Test;

import br.com.hibernate.demo.DAO.StudentDAO;
import br.com.hibernate.orm.demo.entity.Student;

public class StudentHibernateDemoPersistentCreate {

	@Test
	public void testInsertObject() {
		StudentDAO dao = null;
		dao = StudentDAO.getInstanceOf();
		dao.saveObject(new Student("Uíres", "Sousa", "uires@gmail.com"));
	}
}
