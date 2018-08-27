package br.com.hibernate.demo.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import br.com.hibernate.orm.demo.entity.Student;

public class StudentDAO {
	// define uma sessão do hibernate vinda do hibernateFactory
	private Session session;
	private static StudentDAO instancia = null;

	private StudentDAO() {

	}

	public static StudentDAO getInstanceOf() {
		if (instancia == null) {
			instancia = new StudentDAO();
		}
		return instancia;
	}

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

	public Student selectStudentById(Long idParameterUniqueObject) {
		Student student = null;
		session = this.getSessionByTheHibernateFactory();
		try {
			session.beginTransaction();
			student = session.get(Student.class, idParameterUniqueObject);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.err.println("Erro");
		} finally {
			session.close();
		}
		return student;
	}

	public void updateObject(Long id, String emailAdress, String firstName, String secondName) {
		session = this.getSessionByTheHibernateFactory();
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, id);
			student.setEmailAdress(emailAdress);
			student.setFirstName(firstName);
			student.setSecondName(secondName);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			this.getSessionByTheHibernateFactory().close();
		}
	}

}
