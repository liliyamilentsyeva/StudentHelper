package edu.iba.lilya;

import edu.iba.lilya.bean.UserBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lilya on 02.12.16.
 */
public class RolesFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request2 = (HttpServletRequest) request;
        UserBean user = (UserBean) request2.getSession().getAttribute("loginUser");

        if (request2.getServletPath().equals("/Actions")) {
            String button = request2.getParameter("button");
            if (button != null) {
                switch (button) {
                    case "Marks":
                    case "Students":
                    case "Groups":
                    case "Professors":
                    case "Studies":
                        chain.doFilter(request, response);
                        return;
                    case "Users":
                        if (user.getRole().equals("admin")) {
                            chain.doFilter(request, response);
                            return;
                        }
                        break;
                    default:
                        break;
                }
            }
        } else if (request2.getServletPath().contains("User")) {
            if (user.getRole().equals("admin")) {
                chain.doFilter(request, response);
                return;
            }
        } else if (request2.getServletPath().contains("Mark")) {
            if (request2.getServletPath().endsWith("Get") ||
                    user.getRole().equals("admin") || user.getRole().equals("professor")) {
                chain.doFilter(request, response);
                return;
            }
        } else if (request2.getServletPath().endsWith("Get") || user.getRole().equals("admin")) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletResponse response2 = (HttpServletResponse) response;
        response2.sendRedirect("Login");
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }
}
