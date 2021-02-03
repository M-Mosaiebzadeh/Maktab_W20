package ir.maktab.employeeServlet.filters;

import ir.maktab.employeeServlet.entities.Employee;
import ir.maktab.employeeServlet.services.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static ir.maktab.employeeServlet.util.EntityManagerFactoryUtil.*;

public class SaveFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        String firstname = servletRequest.getParameter("firstname");
        String lastname = servletRequest.getParameter("lastname");
        String email = servletRequest.getParameter("email");

        if (!(firstname.equals("") || lastname.equals("") || email.equals(""))){
            List<Employee> employeeList = EmployeeService.isExist(email);
            if (employeeList.size() == 0) {
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                out.println("<center><h3>");
                out.println("<p style='font-size:40px;color:red;'>");
                out.println("This Person now exist");
                out.println("</p></h3></center>");
                servletRequest.getRequestDispatcher("save.html").include(servletRequest,servletResponse);
            }
        }else {

            out.println("<center><h2>");
            out.println("please fill all fields");
            out.println("</h2></center>");
            servletRequest.getRequestDispatcher("save.html").include(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
