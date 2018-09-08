package br.com.hibernate.orm.demo.test;

import java.sql.SQLException;

import br.com.hibernate.demo.DAO.InstructorDAO;
import br.com.hibernate.orm.demo.entity.Instructor;

public class InstructorHibernateDemoOneToMany {
	public static void main(String[] args) {
		// criando o objeto
		Instructor instructor = new Instructor("John Wiccken Kezziah", Double.toString(Math.random() * 1000000));
		InstructorDAO dao = new InstructorDAO();
		try {
			// salva o objeto
			dao.save(instructor);
		} catch (SQLException e) {
			System.err.println("SQLException: "  + e.getMessage());
		}
	}
}
