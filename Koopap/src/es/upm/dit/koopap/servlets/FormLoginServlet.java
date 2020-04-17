package es.upm.dit.koopap.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private final String ADMIN_EMAIL = "Root";
    private final String ADMIN_PASSWORD = "root";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setHeader("Access-Control-Allow-Origin", "*");
    	resp.setHeader("Access-Control-Max-Age", "3600");
    	resp.setHeader("Access-Control-Allow-Credentials", "true");
    	resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Authorization");
    	try {
    	String email = req.getParameter("email");
    	String password = req.getParameter("password");
    	List<User> users = (List<User>) UserDAOImplementation.getInstance().readAll();
    	User user = UserDAOImplementation.getInstance().login(email, password);
    	if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
    		req.getSession().setAttribute("admin", true);
    		req.getSession().setAttribute("users", users);
    		getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
    	} else if ( null != user ) {
    		req.getSession().setAttribute("user", UserDAOImplementation.getInstance().read(user.getEmail()));
    	    PrintWriter out = resp.getWriter();
    	    resp.setContentType("application/json");
    	    resp.setCharacterEncoding("UTF-8");
    	    
    	    ObjectMapper mapper = new ObjectMapper();
    	    String json = mapper.writeValueAsString(user);
    	    JsonObject jsonObject;
    	    jsonObject = Json.createObjectBuilder()
    	                    .add("code",200)
    	                    .add("user", json) 
    	                    .build();
    	    out.print(jsonObject.toString());
    	    out.flush();
    	    System.out.println(jsonObject.toString());
    	} else {
    		PrintWriter out = resp.getWriter();
    		JsonObject jsonObject;
    		jsonObject = Json.createObjectBuilder()
                    .add("code",401)
                    .build();
            out.print(jsonObject.toString());
    	}
    	} catch (Exception e){
    		PrintWriter out = resp.getWriter();
    		JsonObject jsonObject;
            jsonObject = Json.createObjectBuilder()
                    .add("code",401)
                    .add("excepcion", e.toString())
                    .build();
            out.print(jsonObject.toString());
        }
    	
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
