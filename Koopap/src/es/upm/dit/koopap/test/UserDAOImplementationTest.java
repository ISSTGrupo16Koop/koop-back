package es.upm.dit.koopap.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.koopap.dao.UserDAO;
import es.upm.dit.koopap.dao.UserDAOImplementation;
import es.upm.dit.koopap.model.User;

class UserDAOImplementationTest {

	@Test
	void testCrearUsuario() {
		UserDAO userdao = UserDAOImplementation.getInstance();
		User user = new User();
		user.setEmail("emailTest");
		user.setName("nombreTest");
		user.setPassword("passwordTest");
		user.setDescription("descriptionTest");
		user.setLocation("locationTest");
		userdao.create(user);		
		User user2 = userdao.login("emailTest", "passwordTest");
		assertEquals(user2.getEmail(), "emailTest");
		User user3 = userdao.login("emailTest", "");
		assertNull(user3);
		userdao.delete(user);
	}

}
