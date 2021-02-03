package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.entities.User;
import ir.maktab.busTerminal.services.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setFirstname(req.getParameter("firstname"));
        user.setLastname(req.getParameter("lastname"));
        user.setPhoneNumber(req.getParameter("phoneNumber"));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        UserService.save(user);


        req.getRequestDispatcher("login.jsp").forward(req,resp);

    }

}
