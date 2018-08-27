package br.com.hibernate.demo.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import br.com.hibernate.orm.demo.entity.Student;

public class StudentDAO {
	private Session session = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory()
			.getCurrentSession();

	public void saveObject(Student estudante) {
		try {
			session.beginTransaction();
			session.save(estudante);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
