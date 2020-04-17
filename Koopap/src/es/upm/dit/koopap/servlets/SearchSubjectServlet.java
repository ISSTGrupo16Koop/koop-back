package es.upm.dit.koopap.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.upm.dit.koopap.dao.SubjectDAO;
import es.upm.dit.koopap.dao.SubjectDAOImplementation;
import es.upm.dit.koopap.model.Class;
import es.upm.dit.koopap.model.Subject;

/**
 * Servlet implementation class SearchSubjectServlet
 */
@WebServlet("/SearchSubjectServlet")
public class SearchSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("subject");
		Subject subject = SubjectDAOImplementation.getInstance().read(name);
		System.out.println(subject.getName());
		Collection<Class> classlist;
		classlist = subject.getClasses();

	    PrintWriter out = resp.getWriter();
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    
	    ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(classlist);
	    JsonObject jsonObject;
	    jsonObject = Json.createObjectBuilder()
	                    .add("code",200)
	                    .add("classlist", json) 
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
