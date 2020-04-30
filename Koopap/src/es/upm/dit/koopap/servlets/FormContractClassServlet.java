package es.upm.dit.koopap.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.upm.dit.koopap.dao.ClassDAO;
import es.upm.dit.koopap.dao.ClassDAOImplementation;
import es.upm.dit.koopap.dao.UserDAO;
import es.upm.dit.koopap.dao.UserDAOImplementation;
import es.upm.dit.koopap.model.User;
import es.upm.dit.koopap.model.Class;

/**
 * Servlet implementation class FormContractClassServlet
 */
@WebServlet("/FormContractClassServlet")
public class FormContractClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormContractClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	String studentEmail = req.getParameter("student");
    	String classIdString = req.getParameter("classId");
    	
    	
		UserDAO studentDAO = UserDAOImplementation.getInstance();
		User student = studentDAO.read(studentEmail);
		int classId = Integer.parseInt(classIdString);
		ClassDAO classroomDAO = ClassDAOImplementation.getInstance();
		Class classroom = classroomDAO.read(classId);
		UserDAO professorDAO = UserDAOImplementation.getInstance();
		User professor = professorDAO.read(classroom.getProfessor().getEmail());

		int price = classroom.getPrice();
		
		int newProfStatus = professor.getStatus()+price;
		professor.setStatus(newProfStatus);
		int newStudStatus = student.getStatus()-price;
		student.setStatus(newStudStatus);
		classroom.setStudent(student);
		classroom.setFinished(true);

		
		classroomDAO.update(classroom);
		professorDAO.update(professor);
		studentDAO.update(student);
		

	    PrintWriter out = resp.getWriter();
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");

	    JsonObject jsonObject;
	    jsonObject = Json.createObjectBuilder()
	                    .add("code",200) 
	                    .build();

	    out.print(jsonObject.toString());
	    out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

}
