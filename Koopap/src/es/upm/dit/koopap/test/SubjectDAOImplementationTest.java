package es.upm.dit.koopap.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.koopap.dao.SubjectDAO;
import es.upm.dit.koopap.dao.SubjectDAOImplementation;
import es.upm.dit.koopap.model.Subject;

class SubjectDAOImplementationTest {

	@Test
	void test() {
		SubjectDAO subjectdao = SubjectDAOImplementation.getInstance();
		Subject subject = new Subject();
		subject.setName("nombreTest");
		subjectdao.create(subject);		
		Subject subject2 = subjectdao.read("nombreTest");
		assertEquals(subject2.getName(), "nombreTest");
		Subject subject3 = subjectdao.read("");
		assertNull(subject3);
		subjectdao.delete(subject);
	}

}
