package es.upm.dit.koopap.dao;


import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.koopap.model.Subject;

public class SubjectDAOImplementation implements SubjectDAO {

	private static  SubjectDAOImplementation instance = null;
	
	private SubjectDAOImplementation() {
	}

	public static SubjectDAOImplementation getInstance() {
		if( null == instance ) 
			instance = new SubjectDAOImplementation();
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Subject subject) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(subject);		
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Subject read(String name) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.get(Subject.class , name);
		
		session.getTransaction().commit();
		session.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Subject subject) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(subject);
		
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Subject subject) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(subject);
		
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Subject> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<Subject> subjects = session.createQuery("from Subject").list();
		session.getTransaction().commit();
		session.close();
		return subjects;
	}

}
