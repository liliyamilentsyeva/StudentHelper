package edu.iba.lilya.action;

import java.io.IOException;
import java.sql.Date;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.lilya.DAO.DAOException;
import edu.iba.lilya.DAO.MarkDAO;
import edu.iba.lilya.DAO.ProcedureDAO;
import edu.iba.lilya.bean.MarkBean;

/**
 * Servlet implementation class MarkEdit
 */
@WebServlet("/MarkEdit")
public class MarkEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("button")) {
            case "Back":
                request.getRequestDispatcher("Actions?button=Marks").forward(request, response);
                break;
            case "Update":
                if (Objects.equals(request.getParameter("id"), ""))
                    addMark(request, response);
                else
                    updateMark(request, response);
                ProcedureDAO procDao = new ProcedureDAO();
                procDao.updateStudyAvrgMarks();
                procDao.updateProfAvrgMarks();
                procDao.updateStudentAvrgMarks();
                procDao.updateGroupAvrgMarks();
                break;
            case "Delete":
                request.getRequestDispatcher("MarkDelete").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("pages/AccessDenied.jsp").forward(request, response);
                break;
        }
	}

    private void addMark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MarkDAO dao = new MarkDAO();
            MarkBean mark = new MarkBean();
            mark.setProfessorId(Integer.parseInt(request.getParameter("professorID")));
            mark.setStudyId(Integer.parseInt(request.getParameter("studyID")));
            mark.setDate(Date.valueOf(request.getParameter("markDate")));
            mark.setStudentId(Integer.parseInt(request.getParameter("studentID")));
            mark.setMark(Integer.parseInt(request.getParameter("mark")));
            mark.setComments(request.getParameter("comments"));
            dao.add(mark);
            request.getRequestDispatcher("Actions?button=Marks").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

	private void updateMark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MarkDAO dao = new MarkDAO();
            MarkBean mark = dao.getByKey(request.getParameter("id"));
			if (mark != null) {
				mark.setStudyId(Integer.parseInt(request.getParameter("studyID")));
				mark.setStudentId(Integer.parseInt(request.getParameter("studentID")));
				mark.setMark(Integer.parseInt(request.getParameter("markDate")));
				mark.setProfessorId(Integer.parseInt(request.getParameter("professorID")));
				mark.setMark(Integer.parseInt(request.getParameter("mark")));
				mark.setComments(request.getParameter("comments"));
				dao.update(mark);
				request.getRequestDispatcher("Actions?button=Marks").forward(request, response);
			} else {
				request.setAttribute("msg", "There is no such mark.");
				request.getRequestDispatcher("MarkGet").forward(request, response);
			}
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
}
