package edu.iba.lilya.action;

import edu.iba.lilya.DAO.DAOException;
import edu.iba.lilya.DAO.UserDAO;
import edu.iba.lilya.bean.UserBean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            UserDAO dao = new UserDAO();
            UserBean user = dao.getByKey(login);
            if (user != null && user.getPassword().equals(password)) {
                request.getSession().setAttribute("loginUser", user);
                request.getRequestDispatcher("pages/actions.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Login or password is incorrect");
                request.getRequestDispatcher("pages/login.jsp").forward(request, response);
            }
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
