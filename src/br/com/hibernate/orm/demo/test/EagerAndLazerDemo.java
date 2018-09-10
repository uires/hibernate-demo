package br.com.hibernate.orm.demo.test;

import java.sql.SQLException;

import br.com.hibernate.demo.DAO.InstructorDAO;
import br.com.hibernate.orm.demo.entity.Course;
import br.com.hibernate.orm.demo.entity.Instructor;

public class EagerAndLazerDemo {
	public static void main(String[] args) {
		InstructorDAO dao = new InstructorDAO();
		try {
			Instructor instructor = dao.selectById(6L);

			for (Course course : instructor.getCourses()) {
				System.out.println(course.getTitle() + " -> " + course.getInstructor().getId());
			}

			dao = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
