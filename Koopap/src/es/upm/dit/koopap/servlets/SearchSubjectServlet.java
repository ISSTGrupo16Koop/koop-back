package es.upm.dit.koopap.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.koopap.dao.SubjectDAOImplementation;
import es.upm.dit.koopap.model.Subject;
import es.upm.dit.koopap.model.Class;

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
		
		String name = req.getParameter("name");

		
		SubjectDAOImplementation.getInstance().read(name);
		List<Class> classlist = new ArrayList<Class>();

		req.getSession().setAttribute("classlist", classlist);
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
