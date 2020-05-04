package es.upm.dit.koopap.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Class implements Serializable {
	public Class() {
		super();
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	@JsonIgnore
	@ManyToOne
	private Subject subject;
	private boolean finished;
	private int studentValoration;
	private int professorValoration;
	private int price;
	private boolean rated;
	
	public boolean isRated() {
		return rated;
	}
	public void setRated(boolean rated) {
		this.rated = rated;
	}
	@ManyToOne
	private User professor;
	
	@ManyToOne
	private User student;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public int getStudentValoration() {
		return studentValoration;
	}
	public void setStudentValoration(int studentValoration) {
		this.studentValoration = studentValoration;
	}
	public int getProfessorValoration() {
		return professorValoration;
	}
	public void setProfessorValoration(int professorValoration) {
		this.professorValoration = professorValoration;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public User getProfessor() {
		return professor;
	}
	public void setProfessor(User professor) {
		this.professor = professor;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", subject=" + subject + ", finished=" + finished + ", studentValoration="
				+ studentValoration + ", professorValoration=" + professorValoration + ", price=" + price
				+ ", professor=" + professor + ", student=" + student + "]";

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Class other = (Class) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
