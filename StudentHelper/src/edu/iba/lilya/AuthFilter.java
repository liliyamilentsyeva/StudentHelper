package edu.iba.lilya;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class AuthFilter
 */
// @WebFilter("/*")
public class AuthFilter implements Filter {
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request2 = (HttpServletRequest) request;
		if (request2.getServletPath().endsWith(".js") || 
				request2.getServletPath().endsWith(".css") ||
				request2.getServletPath().endsWith(".html") ||
				request2.getServletPath().endsWith("Login") ||
				request2.getServletPath().endsWith("Auth") ||
				request2.getServletPath().length() == 0 ||
				request2.getSession().getAttribute("loginUser") != null){
			
			chain.doFilter(request, response);
		} else {
			HttpServletResponse response2 = (HttpServletResponse) response;
			response2.sendRedirect("Login");
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
