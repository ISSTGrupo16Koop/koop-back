package es.upm.dit.koopap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.koopap.dao.ClassDAOImplementation;
import es.upm.dit.koopap.model.Class;

class ClassDAOImplementationTest {

	@Test
	void testClass() {
		ClassDAOImplementation classdao = ClassDAOImplementation.getInstance();
		Class classroom = new Class();
		classroom.setId(1);
		classroom.setPrice(15);
		classdao.create(classroom);		
		Class classroom2 = classdao.read(1);
		assertEquals(classroom2.getId(), 1);
		assertEquals(classroom2.getPrice(), 15);
	}

}
