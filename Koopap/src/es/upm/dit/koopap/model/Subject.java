package es.upm.dit.koopap.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import antlr.collections.List;

@Entity
public class Subject implements Serializable {
	public Subject() {
		super();
	}
	private static final long serialVersionUID = 1L;
	@Id
	private String name;
	
	@JsonIgnore
	@ManyToMany
	private Collection<User> professors;
	
	@JsonIgnore
	@ManyToMany
	private Collection<User> students;
	
	@OneToMany(mappedBy = "subject", fetch =
			FetchType.EAGER)
	private Collection<Class> classes;
	
	public Collection<User> getProfessors() {
		return professors;
	}

	public void setProfessors(Collection<User> professors) {
		this.professors = professors;
	}

	public Collection<User> getStudents() {
		return students;
	}

	public void setStudents(Collection<User> students) {
		this.students = students;
	}

	public Collection<Class> getClasses() {
		return classes;
	}

	public void setClasses(Collection<Class> classes) {
		this.classes = classes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Subject [name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
