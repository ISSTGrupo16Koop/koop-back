package es.upm.dit.koopap.dao;


import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.koopap.model.Class;

public class ClassDAOImplementation implements ClassDAO {
	private static  ClassDAOImplementation instance = null;
	
	private ClassDAOImplementation() {
	}

	public static ClassDAOImplementation getInstance() {
		if( null == instance ) 
			instance = new ClassDAOImplementation();
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Class classroom) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(classroom);
		
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Class read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Class classroom = session.get(Class.class , id);
		
		session.getTransaction().commit();
		session.close();
		return classroom;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Class classroom) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(classroom);
		
		session.getTransaction().commit();
		session.close();


	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Class classroom) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(classroom);
		
		session.getTransaction().commit();
		session.close();


	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Class> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<Class> classes = session.createQuery("from Class").list();
		session.getTransaction().commit();
		session.close();
		return classes;
	}

}
