package ir.maktab.employeeServlet.servlets;

import ir.maktab.employeeServlet.entities.Employee;
import ir.maktab.employeeServlet.services.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");

        if (!(firstname.equals("") && lastname.equals("") && email.equals(""))) {

            List<Employee> employeeList = EmployeeService.findEmployee(firstname,lastname,email);

            if (employeeList.size() != 0) {
                req.setAttribute("list",employeeList);
                req.getRequestDispatcher("second.jsp").forward(req,resp);

            }else {
                out.println("<center><h3>");
                out.println("we cant find any match");
                out.println("</center></h3>");
                req.getRequestDispatcher("index.html").include(req,resp);
            }
        }else {
            out.println("<center><h3>");
            out.println("please fill some field for search...!!");
            out.println("</center></h3>");
            req.getRequestDispatcher("index.html").include(req,resp);
        }
    }
}
