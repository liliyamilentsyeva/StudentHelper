package edu.iba.lilya.action;

import edu.iba.lilya.DAO.DAOException;
import edu.iba.lilya.DAO.StudentDAO;
import edu.iba.lilya.bean.StudentBean;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentEdit
 */
@WebServlet("/StudentEdit")
public class StudentEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String button = request.getParameter("button");
			if (button.equals("Back"))
				request.getRequestDispatcher("Actions?button=Students").forward(request, response);
			else if (button.equals("Update"))
                if (Objects.equals(request.getParameter("id"), ""))
                    addStudent(request, response);
                else
				    updateStudent(request, response);
			else if (button.equals("Delete"))
				request.getRequestDispatcher("StudentDelete").forward(request, response);
			else
				request.getRequestDispatcher("pages/AccessDenied.jsp").forward(request, response);
		}
		catch (DAOException e) {
			throw new ServletException(e);
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
		StudentDAO sp = new StudentDAO();
		StudentBean student = new StudentBean();
        student.setFirstName(request.getParameter("firstName"));
        student.setSecondName(request.getParameter("secondName"));
        student.setAvgMark(Float.parseFloat(request.getParameter("avgMark")));
        student.setGroupNumber(request.getParameter("groupNumber"));
        sp.add(student);
        request.getRequestDispatcher("Actions?button=Students").forward(request, response);
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
		StudentDAO sp = new StudentDAO();
		StudentBean student = sp.getByKey(request.getParameter("id"));
		if (student != null) {
			student.setFirstName(request.getParameter("firstName"));
			student.setSecondName(request.getParameter("secondName"));
			student.setAvgMark(Float.parseFloat(request.getParameter("avgMark")));
			student.setGroupNumber(request.getParameter("groupNumber"));
			sp.update(student);
			request.getRequestDispatcher("Actions?button=Students").forward(request, response);
		} else {
			request.setAttribute("msg", "There is no such student.");
			request.getRequestDispatcher("StudentGet").forward(request, response);
		}
	}

}
