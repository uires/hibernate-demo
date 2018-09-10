package br.com.hibernate.orm.demo.test;

import java.sql.SQLException;

import br.com.hibernate.demo.DAO.CourseDAO;
import br.com.hibernate.demo.DAO.InstructorDAO;
import br.com.hibernate.orm.demo.entity.Course;
import br.com.hibernate.orm.demo.entity.Instructor;

public class InstructorHibernateDemoOneToMany {
	public static void main(String[] args) {
		// criando o objeto
		InstructorDAO dao = new InstructorDAO();
		CourseDAO daoCourse = new CourseDAO();
		try {
			Instructor instructor = dao.selectById(6L);

			// criando os objetos
			Course course = new Course();
			course.setTitle("Guitar Play");
			Course course2 = new Course();
			course2.setTitle("ECMAScript 6");

			// adicionando os elementos a lista
			instructor.add(course);
			instructor.add(course2);

			// salvando os objetos
			daoCourse.save(course);
			daoCourse.save(course2);

		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
	}
}
