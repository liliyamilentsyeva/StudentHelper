package edu.iba.lilya.action;

import edu.iba.lilya.DAO.ProfessorDAO;
import edu.iba.lilya.bean.ProfessorBean;

import java.io.IOException;
import java.sql.Date;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ProfessorEdit
 */
@WebServlet("/ProfessorEdit")
public class ProfessorEdit extends HttpServlet {
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
                request.getRequestDispatcher("Actions?button=Professors").forward(request, response);
                break;
            case "Update":
                if (Objects.equals(request.getParameter("id"), ""))
                    addProfessor(request, response);
                else
                    updateProfessor(request, response);
                break;
            case "Delete":
                request.getRequestDispatcher("ProfessorDelete").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("pages/AccessDenied.jsp").forward(request, response);
                break;
        }
    }

    private void addProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfessorDAO dao = new ProfessorDAO();
        ProfessorBean professor = new ProfessorBean();
        professor.setFirstName(request.getParameter("firstName"));
        professor.setFatherName(request.getParameter("fatherName"));
        professor.setSecondName(request.getParameter("secondName"));
        professor.setBirthDate(Date.valueOf(request.getParameter("birthDate")));
        professor.setAvgMark(Float.parseFloat(request.getParameter("avgMark")));
        dao.add(professor);
        request.getRequestDispatcher("Actions?button=Professors").forward(request, response);
    }

    private void updateProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfessorDAO dao = new ProfessorDAO();
        ProfessorBean professor = dao.getByKey(request.getParameter("id"));
        if (professor != null) {
            professor.setFirstName(request.getParameter("firstName"));
            professor.setFatherName(request.getParameter("fatherName"));
            professor.setSecondName(request.getParameter("secondName"));
            professor.setBirthDate(Date.valueOf(request.getParameter("birthDate")));
            professor.setAvgMark(Float.parseFloat(request.getParameter("avgMark")));
            dao.update(professor);
            request.getRequestDispatcher("Actions?button=Professors").forward(request, response);
        } else {
            request.setAttribute("msg", "There is no such professor.");
            request.getRequestDispatcher("ProfessorGet").forward(request, response);
        }
    }
}
