package edu.iba.lilya.action;

import edu.iba.lilya.DAO.StudyDAO;
import edu.iba.lilya.bean.StudyBean;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudyEdit
 */
@WebServlet("/StudyEdit")
public class StudyEdit extends HttpServlet {
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
        String button = request.getParameter("button");
        switch (button) {
            case "Back":
                request.getRequestDispatcher("Actions?button=Studies").forward(request, response);
                break;
            case "Update":
                if (Objects.equals(request.getParameter("id"), ""))
                    addStudy(request, response);
                else
                    updateStudy(request, response);
                break;
            case "Delete":
                request.getRequestDispatcher("StudyDelete").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("pages/AccessDenied.jsp").forward(request, response);
                break;
        }
    }

    private void addStudy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudyDAO dao = new StudyDAO();
        StudyBean study = new StudyBean();
        study.setName(request.getParameter("name"));
        study.setHours(Integer.parseInt(request.getParameter("hours")));
        study.setProfessorId(Integer.parseInt(request.getParameter("professorID")));
        study.setAvgMark(Float.parseFloat(request.getParameter("avgMark")));
        dao.add(study);
        request.getRequestDispatcher("Actions?button=Studies").forward(request, response);
    }

    private void updateStudy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudyDAO dao = new StudyDAO();
        StudyBean study = dao.getByKey(request.getParameter("id"));
        if (study != null) {
            study.setName(request.getParameter("name"));
            study.setHours(Integer.parseInt(request.getParameter("hours")));
            study.setProfessorId(Integer.parseInt(request.getParameter("professorID")));
            study.setAvgMark(Float.parseFloat(request.getParameter("avgMark")));
            dao.update(study);
            request.getRequestDispatcher("Actions?button=Studies").forward(request, response);
        } else {
            request.setAttribute("msg", "There is no such study.");
            request.getRequestDispatcher("StudyGet").forward(request, response);
        }
    }
}
