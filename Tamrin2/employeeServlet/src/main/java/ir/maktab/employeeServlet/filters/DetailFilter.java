package ir.maktab.employeeServlet.filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class DetailFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        String firstname = servletRequest.getParameter("firstname");
        String lastname = servletRequest.getParameter("lastname");

        if (!(firstname.equals("") || lastname.equals(""))){
            filterChain.doFilter(servletRequest,servletResponse);

        }else {
            out.println("<center><h2>");
            out.println("Firstname and Lastname should not be empty");
            out.println("</h2></center>");
            servletRequest.getRequestDispatcher("index.html").include(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
