package es.upm.dit.koopap.dao;

import java.util.Collection;

import es.upm.dit.koopap.model.User;

public interface UserDAO {
	public void create(User user);
	public User read(String email);
	public void update(User user);
	public void delete(User user);
	public Collection<User> readAll();
	public User login(String email, String psd);
}
