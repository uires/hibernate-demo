package br.com.hibernate.orm.demo.test;

import br.com.hibernate.demo.DAO.StudentDAO;
import br.com.hibernate.orm.demo.entity.Endereco;

public class StudentHibernateDemoPersistentOneToOneBiDirectional {

	public static void main(String[] args) {
		StudentDAO dao = null;
		dao = StudentDAO.getInstanceOf();
		Endereco endereco = dao.selectEnderecoById(2L);
		System.out.println(endereco.toString());
	}
}
