package edu.iba.lilya.action;

import edu.iba.lilya.DAO.DAOException;
import edu.iba.lilya.DAO.StudentDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class StudentGet
 */
@WebServlet("/StudentGet")
public class StudentGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studID = request.getParameter("id");
		StudentDAO sp = new StudentDAO();
		try {
			request.setAttribute("stud", sp.getByKey(studID));
		} catch (DAOException e) {
			throw new ServletException(e);
		}
		request.getRequestDispatcher("pages/forms/studForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
