package es.upm.dit.koopap.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.upm.dit.koopap.dao.UserDAOImplementation;
import es.upm.dit.koopap.model.User;

/**
 * Servlet implementation class FormCreaProfesorServlet
 */
@WebServlet("/FormCreaUserServlet")
public class FormCreaUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
           throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String location = req.getParameter("location");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setDescription(description);
		user.setLocation(location);
		
		UserDAOImplementation.getInstance().create(user);

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
