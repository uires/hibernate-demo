package br.com.hibernate.orm.demo.test;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.hibernate.demo.DAO.CourseDAO;
import br.com.hibernate.demo.DAO.StudentDAO;
import br.com.hibernate.orm.demo.entity.Course;
import br.com.hibernate.orm.demo.entity.Student;

public class ManyToManyDemo {
	public static void main(String[] args) {
		StudentDAO dao = null;
		CourseDAO daoC = new CourseDAO();
		
		try {
			dao = StudentDAO.getInstanceOf();
			Course course = daoC.selectById(25L);
			

			ArrayList<Student> students = new ArrayList<>();
			students = (ArrayList<Student>) dao.selectAllObjects();
			course.setStudents(students);

			daoC.update(course);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
