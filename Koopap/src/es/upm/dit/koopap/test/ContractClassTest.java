package es.upm.dit.koopap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.koopap.dao.ClassDAO;
import es.upm.dit.koopap.dao.ClassDAOImplementation;
import es.upm.dit.koopap.dao.UserDAO;
import es.upm.dit.koopap.dao.UserDAOImplementation;
import es.upm.dit.koopap.model.Class;
import es.upm.dit.koopap.model.User;

class ContractClassTest {

	@Test
	void test() {
		UserDAO studentdao = UserDAOImplementation.getInstance();
		User student = new User();
		student.setEmail("studentEmailTest");
		studentdao.create(student);
		
		UserDAO professordao = UserDAOImplementation.getInstance();
		User professor = new User();
		professor.setEmail("professorEmailTest");
		professordao.create(professor);
		
		ClassDAOImplementation classdao = ClassDAOImplementation.getInstance();
		Class classroom = new Class();
		classroom.setId(1);
		classroom.setPrice(15);
		classroom.setProfessor(professor);
		classroom.setStudent(student);
		classdao.create(classroom);	

		int price = classroom.getPrice();
		
		int newProfStatus = professor.getStatus()+price;
		professor.setStatus(newProfStatus);
		int newStudStatus = student.getStatus()-price;
		student.setStatus(newStudStatus);

		
		classdao.update(classroom);
		professordao.update(professor);
		studentdao.update(student);
		
		Class classroom2 = classdao.read(1);
		User professor2 = professordao.read("professorEmailTest");
		User student2 = professordao.read("studentEmailTest");
		assertEquals(classroom2.getId(), 1);
		assertEquals(classroom2.getPrice(), 15);
		assertEquals(classroom2.getProfessor(), professor2 );
		assertEquals(classroom2.getStudent(), student2);
		assertEquals(professor2.getStatus(), 15);
		assertEquals(student2.getStatus(), -15);
		
	}

}
