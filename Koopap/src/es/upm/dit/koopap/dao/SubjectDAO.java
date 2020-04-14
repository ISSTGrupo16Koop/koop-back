package es.upm.dit.koopap.dao;


import java.util.Collection;

import es.upm.dit.koopap.model.Subject;

public interface SubjectDAO {
		public void create(Subject subject);
		public Subject read(String name);
		public void update(Subject subject);
		public void delete(Subject subject);
		public Collection<Subject> readAll();
}
