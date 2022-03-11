package edu.iba.lilya.action;

import edu.iba.lilya.DAO.DAOException;
import edu.iba.lilya.DAO.GroupDAO;
import edu.iba.lilya.bean.GroupBean;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GroupEdit
 */
@WebServlet("/GroupEdit")
public class GroupEdit extends HttpServlet {
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
				request.getRequestDispatcher("Actions?button=Groups").forward(request, response);
				break;
			case "Update":
                if (Objects.equals(request.getParameter("groupNumber"), ""))
                    addGroup(request, response);
                else
				    updateGroup(request, response);
				break;
			case "Delete":
				request.getRequestDispatcher("GroupDelete").forward(request, response);
				break;
			default:
				request.getRequestDispatcher("/pages/AccessDenied.jsp").forward(request, response);
				break;
		}
	}

	private void addGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            GroupDAO gp = new GroupDAO();
            GroupBean group = new GroupBean();
            group.setGroupNumber(request.getParameter("newGroupNumber"));
            group.setAvgMark(Float.parseFloat(request.getParameter("avgMark")));
            gp.add(group);
            request.getRequestDispatcher("Actions?button=Groups").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

	private void updateGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GroupDAO gp = new GroupDAO();
			GroupBean group = gp.getByKey(request.getParameter("groupNumber"));
			if (group != null) {
				group.setGroupNumber(request.getParameter("newGroupNumber"));
				group.setAvgMark(Float.parseFloat(request.getParameter("avgMark")));
				gp.update(group);
				request.getRequestDispatcher("Actions?button=Groups").forward(request, response);
			} else {
				request.setAttribute("msg", "There is no such group.");
				request.getRequestDispatcher("GroupGet").forward(request, response);
			}
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
}
