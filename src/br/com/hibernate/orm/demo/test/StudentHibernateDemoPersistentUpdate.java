package br.com.hibernate.orm.demo.test;

import br.com.hibernate.demo.DAO.StudentDAO;

public class StudentHibernateDemoPersistentUpdate {

	public static void main(String[] args) {
		StudentDAO dao = null;
		dao = StudentDAO.getInstanceOf();
		dao.updateObject(1L, "teste@gmail.com", "Nami", "Johnson");

	}
}
