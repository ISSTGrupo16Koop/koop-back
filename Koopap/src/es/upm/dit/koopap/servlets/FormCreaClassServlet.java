package es.upm.dit.koopap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.koopap.dao.ClassDAOImplementation;
import es.upm.dit.koopap.dao.SubjectDAOImplementation;
import es.upm.dit.koopap.dao.UserDAOImplementation;
import es.upm.dit.koopap.model.Subject;
import es.upm.dit.koopap.model.User;
import es.upm.dit.koopap.model.Class;

/**
 * Servlet implementation class FormCreaClassServlet
 */
@WebServlet("/FormCreaClassServlet")
public class FormCreaClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) (Math.random()*1000);
		String priceString = request.getParameter("price");
		int price = Integer.parseInt(priceString);
		String subjectName = request.getParameter("subject");
		Subject subject =
                SubjectDAOImplementation.getInstance().read(subjectName);
		String userName = request.getParameter("user");
		User user =
                UserDAOImplementation.getInstance().read(userName);
		if( null != subject && null != user ) {
			Class classroom = new Class();
			classroom.setSubject(subject);
			classroom.setPrice(price);
			classroom.setProfessor(user);
			classroom.setId(id);
			ClassDAOImplementation.getInstance().create(classroom);
			request.getSession().setAttribute("classroom", classroom);
		} else if (subject == null) {
			Subject newSubject = new Subject();
			newSubject.setName(subjectName);
			SubjectDAOImplementation.getInstance().create(newSubject);
			Class classroom = new Class();
			classroom.setSubject(newSubject);
			classroom.setPrice(price);
			classroom.setProfessor(user);
			classroom.setId(id);
			ClassDAOImplementation.getInstance().create(classroom);
			request.getSession().setAttribute("classroom", classroom);
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
