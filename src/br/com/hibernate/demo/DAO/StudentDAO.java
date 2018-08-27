package br.com.hibernate.demo.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import br.com.hibernate.orm.demo.entity.Student;

public class StudentDAO {
	// define uma sessão do hibernate vinda do hibernateFactory
	private Session session;

	// prover uma sessão para a classe pesistir
	private Session getSessionByTheHibernateFactory() {
		return new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory()
				.getCurrentSession();
	}

	public void saveObject(Student estudante) {
		session = this.getSessionByTheHibernateFactory();
		try {
			// prover uma transaction para realizar a persistência
			session.beginTransaction();
			// salva o objeto Student.class
			session.save(estudante);
			// começa realiza a operação (commit)
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			// finaliza a sessão fecha-a
			session.close();
		}
	}

	public List<Student> selectAllObjects() {
		session = this.getSessionByTheHibernateFactory();
		List<Student> studentsList = null;
		try {
			session.beginTransaction();
			studentsList = session.createQuery("from Student").getResultList();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return studentsList;
	}
}
