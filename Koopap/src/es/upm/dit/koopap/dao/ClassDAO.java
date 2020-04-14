package es.upm.dit.koopap.dao;

import java.util.Collection;

import es.upm.dit.koopap.model.Class;

public interface ClassDAO {
		public void create(Class classroom);
		public Class read(int id);
		public void update(Class classroom);
		public void delete(Class classroom);
		public Collection<Class> readAll();

}
