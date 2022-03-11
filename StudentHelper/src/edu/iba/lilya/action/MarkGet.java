package edu.iba.lilya.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.lilya.DAO.DAOException;
import edu.iba.lilya.DAO.MarkDAO;
import edu.iba.lilya.bean.MarkBean;

/**
 * Servlet implementation class MarkGet
 */
@WebServlet("/MarkGet")
public class MarkGet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String markID = request.getParameter("id");
            MarkDAO dao = new MarkDAO();
            request.setAttribute("mark", dao.getByKey(markID));
            request.getRequestDispatcher("pages/forms/markForm.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
