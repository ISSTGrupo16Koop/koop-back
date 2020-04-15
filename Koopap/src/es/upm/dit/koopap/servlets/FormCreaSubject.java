package es.upm.dit.koopap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.koopap.dao.SubjectDAOImplementation;
import es.upm.dit.koopap.model.Subject;

/**
 * Servlet implementation class FormCreaSubject
 */
@WebServlet("/FormCreaSubject")
public class FormCreaSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String subjectName = request.getParameter("subject");
		Subject subject = new Subject();
		subject.setName(subjectName);
		SubjectDAOImplementation.getInstance().create(subject);
		request.getSession().setAttribute("subject", subject);
		getServletContext().getRequestDispatcher("/Admin.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
