package ir.maktab.employeeServlet.servlets;

import ir.maktab.employeeServlet.entities.Employee;
import ir.maktab.employeeServlet.services.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DetailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        Employee employee = (Employee) session.getAttribute("details");
//        Employee employee = (Employee) req.getAttribute("details");

        if (req.getParameter("submit") != null) {
            employee.setFirstname(req.getParameter("firstname"));
            employee.setLastname(req.getParameter("lastname"));
            employee.setEmail(req.getParameter("email"));
//            if (!req.getParameter("fatherName").equals("")){
                employee.setFatherName(req.getParameter("fatherName"));
//            }
//           if (!req.getParameter("nationalCode").equals("")){
               employee.setNationalCode(req.getParameter("nationalCode"));
//           }

            employee.setAddress(req.getParameter("address"));
            EmployeeService.update(employee);

            req.getRequestDispatcher("/show").forward(req,resp);

        }else {
            EmployeeService.delete(employee);
            out.println("<center><h3>");
            out.println("Employee deleted");
            out.println("</center></h3>");
            req.getRequestDispatcher("/show").include(req,resp);
        }
    }
}
