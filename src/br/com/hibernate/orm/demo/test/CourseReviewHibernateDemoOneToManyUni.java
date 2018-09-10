package br.com.hibernate.orm.demo.test;

import java.sql.SQLException;

import br.com.hibernate.demo.DAO.CourseDAO;
import br.com.hibernate.demo.DAO.InstructorDAO;
import br.com.hibernate.orm.demo.entity.Course;
import br.com.hibernate.orm.demo.entity.Instructor;

public class CourseReviewHibernateDemoOneToManyUni {
	public static void main(String[] args) {
		// criando o objeto
		InstructorDAO dao = new InstructorDAO();
		CourseDAO daoCourse = new CourseDAO();
		try {
			Instructor instructor = dao.selectById(6L);
			
			
			//System.out.println(course.getReviews().get(0).getDescricao());
			
			

		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
	}
}
