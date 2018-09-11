package br.com.hibernate.orm.demo.test;

import java.sql.SQLException;

import br.com.hibernate.demo.DAO.CourseDAO;
import br.com.hibernate.orm.demo.entity.Course;
import br.com.hibernate.orm.demo.entity.Review;

public class CourseReviewHibernateDemoOneToManyUni {
	public static void main(String[] args) {
		// criando o objeto DAO
		CourseDAO daoCourse = new CourseDAO();
		try {
			// busca o objeto no banco
			Course course = daoCourse.selectById(20L);

			// realiza um interação na lista de review do curso

			for (Review review : course.getReviews()) {
				System.out.println(review.getDescricao());
				System.out.println(review.getNota());
			}
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
	}
}
