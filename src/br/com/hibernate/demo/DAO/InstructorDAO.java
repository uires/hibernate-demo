package br.com.hibernate.demo.DAO;

import java.sql.SQLException;

import org.hibernate.Session;

import br.com.hibernate.demo.factory.HibernateFactory;
import br.com.hibernate.orm.demo.entity.Instructor;

public class InstructorDAO {
	private Session session;

	public void save(Instructor instructor) throws SQLException {
		session = HibernateFactory.getSessionByTheHibernateFactory();
		session.beginTransaction();
		// salvando o objeto
		session.save(instructor);
		// realiza a persistência
		session.getTransaction().commit();
		// fecha a sessão
		session.close();
	}

	public Instructor selectById(Long id) throws SQLException {
		session = HibernateFactory.getSessionByTheHibernateFactory();
		session.beginTransaction();
		// busca o objeto pelo id
		Instructor instructor = session.get(Instructor.class, id);
		session.getTransaction().commit();
		// fecha a sessão
		session.close();
		return instructor;
	}
}
