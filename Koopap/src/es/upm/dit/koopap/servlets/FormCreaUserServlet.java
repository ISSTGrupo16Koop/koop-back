package es.upm.dit.koopap.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		
		UserDAOImplementation.getInstance().create(user);
		List<User> lu = new ArrayList<User>();
		lu.addAll((List<User>)         
                          req.getSession().getAttribute("users"));
		lu.add (user);
		req.getSession().setAttribute("users", lu);
		getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
