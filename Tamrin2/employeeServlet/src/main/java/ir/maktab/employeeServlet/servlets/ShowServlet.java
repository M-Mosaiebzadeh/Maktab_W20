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


public class ShowServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Employee> employeeList = EmployeeService.loadAll();

        req.setAttribute("list",employeeList);

        req.getRequestDispatcher("second.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
