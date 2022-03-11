package edu.iba.lilya.action;

import edu.iba.lilya.DAO.DAOException;
import edu.iba.lilya.DAO.UserDAO;
import edu.iba.lilya.bean.UserBean;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserEdit
 */
@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {
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
        String button = request.getParameter("button");
        switch (button) {
            case "Back":
                request.getRequestDispatcher("Actions?button=Users").forward(request, response);
                break;
            case "Update":
                if (Objects.equals(request.getParameter("user"), ""))
                    addUser(request, response);
                else
                    updateUser(request, response);
                break;
            case "Delete":
                request.getRequestDispatcher("UserDelete").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("pages/AccessDenied.jsp").forward(request, response);
                break;
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO up = new UserDAO();
            UserBean bean = new UserBean();
            bean.setUser(request.getParameter("newUser"));
            bean.setPassword(request.getParameter("password"));
            bean.setRole(request.getParameter("role"));
            up.add(bean);
            request.getRequestDispatcher("Actions?button=Users").forward(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO up = new UserDAO();
            UserBean bean = up.getByKey(request.getParameter("user"));
            if (bean.getUser() != null) {
                bean.setUser(request.getParameter("newUser"));
                bean.setPassword(request.getParameter("password"));
                bean.setRole(request.getParameter("role"));
                up.update(bean);
                request.getRequestDispatcher("Actions?button=Users").forward(request, response);
            } else {
                request.setAttribute("msg", "There is no such user.");
                request.getRequestDispatcher("UserGet").forward(request, response);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
