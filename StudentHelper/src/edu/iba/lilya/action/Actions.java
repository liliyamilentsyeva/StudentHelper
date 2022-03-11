package edu.iba.lilya.action;

import edu.iba.lilya.DAO.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Actions
 */
@WebServlet("/Actions")
public class Actions extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		if (button != null) {
			switch (button) {
				case "Students":
					handleStudents(request, response);
					break;
				case "Groups":
					handleGroups(request, response);
					break;
				case "Professors":
					handleProfessors(request, response);
					break;
				case "Studies":
					handleStudies(request, response);
					break;
				case "Marks":
					handleMarks(request, response);
					break;
				case "Users":
					handleUsers(request, response);
					break;
				default:
					request.setAttribute("msg", "U'v pressed " + button + " button.");
					request.getRequestDispatcher("pages/welcome.jsp").forward(request, response);
					break;
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	private void handleStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		request.setAttribute("studList", dao.loadAll());
		request.getRequestDispatcher("pages/lists/studentList.jsp").forward(request, response);
	}
	
	private void handleGroups(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            GroupDAO dao = new GroupDAO();
            request.setAttribute("groupList", dao.loadAll());
            request.getRequestDispatcher("pages/lists/groupsList.jsp").forward(request, response);
        } catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	private void handleProfessors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProfessorDAO dao = new ProfessorDAO();
			request.setAttribute("professorList", dao.loadAll());
			request.getRequestDispatcher("pages/lists/professorsList.jsp").forward(request, response);
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	private void handleStudies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StudyDAO dao = new StudyDAO();
			request.setAttribute("studyList", dao.loadAll());
			request.getRequestDispatcher("pages/lists/studiesList.jsp").forward(request, response);
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	private void handleMarks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MarkDAO dao = new MarkDAO();
			request.setAttribute("markList", dao.loadAll());
			request.getRequestDispatcher("pages/lists/marksList.jsp").forward(request, response);
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	private void handleUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			request.setAttribute("userList", dao.loadAll());
			request.getRequestDispatcher("pages/lists/usersList.jsp").forward(request, response);
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
}
