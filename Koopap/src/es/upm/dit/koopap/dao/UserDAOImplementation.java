package es.upm.dit.koopap.dao;


import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.koopap.model.User;

public class UserDAOImplementation implements UserDAO {
	
	private static  UserDAOImplementation instance = null;
	
	private UserDAOImplementation() {
	}

	public static UserDAOImplementation getInstance() {
		if( null == instance ) 
			instance = new UserDAOImplementation();
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(User user) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(user);		
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public User read(String email) {
			Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			User user = session.get(User.class , email);
			
			session.getTransaction().commit();
			session.close();
			return user;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(User user) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		
		session.getTransaction().commit();
		session.close();


	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(User user) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(user);
		
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<User> users = session.createQuery("from User").list();
		session.getTransaction().commit();
		session.close();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		User u = null;
		Query q = session.createQuery("select u from User u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<User> users = q.getResultList();
		if (users.size() > 0)
			u = (User) (q.getResultList().get(0));

		
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
