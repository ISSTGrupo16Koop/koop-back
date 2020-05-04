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

import es.upm.dit.koopap.dao.ClassDAO;
import es.upm.dit.koopap.dao.ClassDAOImplementation;
import es.upm.dit.koopap.dao.UserDAO;
import es.upm.dit.koopap.dao.UserDAOImplementation;
import es.upm.dit.koopap.model.Class;
import es.upm.dit.koopap.model.User;

/**
 * Servlet implementation class FormRateClassServlet
 */
@WebServlet("/FormRateClassServlet")
public class FormRateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormRateClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	String classIdString = req.getParameter("classId");
    	String ratedString = req.getParameter("rated");
    	int rated = Integer.parseInt(ratedString);
    	
    	int classId = Integer.parseInt(classIdString);
    	ClassDAO classroomDAO = ClassDAOImplementation.getInstance();
		Class classroom = classroomDAO.read(classId);
		UserDAO professorDAO = UserDAOImplementation.getInstance();
		User professor = professorDAO.read(classroom.getProfessor().getEmail());
		
		classroom.setProfessorValoration(rated);
		classroom.setRated(true);
		
		double profVal = professor.getProfessorValoration();
		int numVal = professor.getNumberValorations();		
		double newVal = (profVal*numVal+rated)/(numVal+1);
		professor.setNumberValorations(numVal+1);
		professor.setProfessorValoration(newVal);
		
		classroomDAO.update(classroom);
		professorDAO.update(professor);
		
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
