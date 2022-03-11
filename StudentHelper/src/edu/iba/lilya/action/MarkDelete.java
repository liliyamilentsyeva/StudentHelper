package edu.iba.lilya.action;

import edu.iba.lilya.DAO.DAOException;
import edu.iba.lilya.DAO.MarkDAO;
import edu.iba.lilya.DAO.ProcedureDAO;
import edu.iba.lilya.DAO.StudentDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class MarkDelete
 */
@WebServlet("/MarkDelete")
public class MarkDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String markID = request.getParameter("id");
			MarkDAO dao = new MarkDAO();
			dao.delete(markID);
            ProcedureDAO procDao = new ProcedureDAO();
            procDao.updateStudyAvrgMarks();
            procDao.updateProfAvrgMarks();
            procDao.updateStudentAvrgMarks();
            procDao.updateGroupAvrgMarks();
			request.getRequestDispatcher("Actions?button=Marks").forward(request, response);
		} catch (DAOException e) {
			throw new ServletException(e);
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
