package br.com.hibernate.demo.DAO;

import java.sql.SQLException;

import org.hibernate.Session;

import br.com.hibernate.demo.factory.HibernateFactory;
import br.com.hibernate.orm.demo.entity.Course;

public class CourseDAO {
	private Session session;

	public void save(Course course) throws SQLException {
		session = HibernateFactory.getSessionByTheHibernateFactory();
		session.beginTransaction();
		// salvando o objeto
		session.save(course);
		// realiza a persistência
		session.getTransaction().commit();
		// fecha a sessão
		session.close();
	}

	public Course selectById(Long id) throws SQLException {
		session = HibernateFactory.getSessionByTheHibernateFactory();
		session.beginTransaction();
		// busca o objeto pelo id
		Course course = session.get(Course.class, id);
		session.getTransaction().commit();
		// fecha a sessão
		session.close();
		return course;
	}
}
