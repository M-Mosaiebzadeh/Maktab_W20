package ir.maktab.busTerminal.filters;


import ir.maktab.busTerminal.services.UserService;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;


public class SignUpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        String firstname = servletRequest.getParameter("firstname");
        String lastname = servletRequest.getParameter("lastname");
        String phoneNumber = servletRequest.getParameter("phoneNumber");

        if (username == null || password == null || firstname == null || lastname == null || phoneNumber == null){
            out.println("<center><h3>");
            out.println("please fill all fields !!");
            out.println("</h3></center>");
            servletRequest.getRequestDispatcher("signUp.jsp").include(servletRequest,servletResponse);

        }else if (UserService.isExistUser(username).size() == 0){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            out.println("<center><h3>");
            out.println("username " + username + " is exist!!");
            out.println("please sign in ...");
            out.println("</h3></center>");

            servletRequest.getRequestDispatcher("login.jsp").include(servletRequest,servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
