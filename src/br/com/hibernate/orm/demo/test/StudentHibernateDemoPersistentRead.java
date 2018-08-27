package br.com.hibernate.orm.demo.test;

import br.com.hibernate.demo.DAO.StudentDAO;

public class StudentHibernateDemoPersistentRead {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		for (Object object : dao.selectAllObjects()) {
			System.out.println(object.toString());
		}
	}
}
