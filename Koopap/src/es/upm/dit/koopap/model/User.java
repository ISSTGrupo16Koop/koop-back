package es.upm.dit.koopap.model;
import java.io.Serializable; 
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String email;
	@JsonIgnore
	private String password;
	private String name;
	private String description;
	//private String photo;
	private int status;
	private double professorValoration;
	private double studentValoration;
	private String location;
	//private List?? schedule
	
	@JsonIgnore
	@ManyToMany
	private Collection<Subject> professorSubjects;
	
	@JsonIgnore
	@ManyToMany
	private Collection<Subject> studentSubjects;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor", fetch =
			FetchType.EAGER)
	private Collection<Class> professorClasses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch =
			FetchType.EAGER)
	private Collection<Class> studentClasses;
	
	
	public User() {
		status = 0;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public double getProfessorValoration() {
		return professorValoration;
	}


	public void setProfessorValoration(double professorValoration) {
		this.professorValoration = professorValoration;
	}


	public double getStudentValoration() {
		return studentValoration;
	}


	public void setStudentValoration(double studentValoration) {
		this.studentValoration = studentValoration;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Collection<Subject> getProfessorSubjects() {
		return professorSubjects;
	}


	public void setProfessorSubjects(Collection<Subject> professorSubjects) {
		this.professorSubjects = professorSubjects;
	}


	public Collection<Subject> getStudentSubjects() {
		return studentSubjects;
	}


	public void setStudentSubjects(Collection<Subject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}


	public Collection<Class> getProfessorClasses() {
		return professorClasses;
	}


	public void setProfessorClasses(Collection<Class> professorClasses) {
		this.professorClasses = professorClasses;
	}


	public Collection<Class> getStudentClasses() {
		return studentClasses;
	}


	public void setStudentClasses(Collection<Class> studentClasses) {
		this.studentClasses = studentClasses;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", description=" + description
				+ ", status=" + status + ", professorValoration=" + professorValoration + ", studentValoration="
				+ studentValoration + ", location=" + location + ", professorSubjects=" + professorSubjects
				+ ", studentSubjects=" + studentSubjects + ", professorClasses=" + professorClasses
				+ ", studentClasses=" + studentClasses + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	

	}